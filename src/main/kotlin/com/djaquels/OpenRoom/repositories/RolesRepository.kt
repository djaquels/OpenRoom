package com.djaquels.OpenRoom.repositories
import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.djaquels.OpenRoom.models.Role

@Repository
interface RolesRepository:  JpaRepository<Role, Int>