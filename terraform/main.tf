provider "azurerm" {
  features {}
}

# AZ central config
resource "azurerm_resource_group" "rg" {
  name     = "openroom-rg"
  location = var.location # Or the location it was actually created in
}

# Kubernets configuration
resource "azurerm_kubernetes_cluster" "aks" {
  name                = "aks-cluster"
  location            = var.location
  resource_group_name = azurerm_resource_group.name
  dns_prefix          = "open-room-64"

  default_node_pool {
    name       = "default"
    node_count = 2
    vm_size    = "Standard_DS2_v2"
  }

  identity {
    type = "SystemAssigned"
  }

  network_profile {
    network_plugin = "azure"
  }

  role_based_access_control {
    enabled = true
  }

  tags = {
    Environment = "production"
  }
}
# Database configuraiton

