package com.djaquels.OpenRoom.services

import com.djaquels.OpenRoom.models.Role
import com.djaquels.OpenRoom.repositories.RolesRepository
import org.springframework.stereotype.Service

@Service
class RolesService(private val rolesRepository: RolesRepository){
    fun createRole(role: Role): Role {
        return rolesRepository.save(role)
    }

    fun getAll(): List<Role> {
        return rolesRepository.findAll().toList()
    }
}