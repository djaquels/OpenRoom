provider "azurerm" {
  features {}
}

provider "kubernetes" {
  host                   = azurerm_kubernetes_cluster.aks.kube_admin_config[0].host
  client_certificate     = base64decode(azurerm_kubernetes_cluster.aks.kube_admin_config[0].client_certificate)
  client_key             = base64decode(azurerm_kubernetes_cluster.aks.kube_admin_config[0].client_key)
  cluster_ca_certificate = base64decode(azurerm_kubernetes_cluster.aks.kube_admin_config[0].cluster_ca_certificate)
}

resource "azurerm_resource_group" "rg" {
  name     = "openroom-rg"
  location = var.location
}

resource "azurerm_container_registry" "acr" {
  name                = "openroomacr"
  resource_group_name = azurerm_resource_group.rg.name
  location            = azurerm_resource_group.rg.location
  sku                 = "Basic"
  admin_enabled       = true
}

resource "azurerm_kubernetes_cluster" "aks" {
  name                = "openroom-aks"
  location            = azurerm_resource_group.rg.location
  resource_group_name = azurerm_resource_group.rg.name
  dns_prefix          = "openroom"

  default_node_pool {
    name       = "default"
    node_count = 1
    vm_size    = "Standard_DS2_v2"
  }

  identity {
    type = "SystemAssigned"
  }
}

resource "azurerm_key_vault" "kv" {
  name                        = "openroomkv"
  location                    = azurerm_resource_group.rg.location
  resource_group_name         = azurerm_resource_group.rg.name
  tenant_id                   = data.azurerm_client_config.current.tenant_id
  sku_name                    = "standard"
}

resource "azurerm_key_vault_secret" "db_url" {
  name         = "DB-URL"
  value        = var.db_url
  key_vault_id = azurerm_key_vault.kv.id
}

resource "azurerm_key_vault_secret" "db_user"
  name         = "DB-USER"
  value        = var.db_user
  key_vault_id = azurerm_key_vault.kv.id
}

resource "azurerm_key_vault_secret" "db_pass" {
  name         = "DB-PASS"
  value        = var.db_pass
  key_vault_id = azurerm_key_vault.kv.id
}

resource "kubernetes_secret" "openroom_api_secret" {
  metadata {
    name = "openroom-api-secret"
  }

  data = {
    DB_URL  = base64encode(var.db_url)
    DB_USER = base64encode(var.db_user)
    DB_PASS = base64encode(var.db_pass)
  }
}
