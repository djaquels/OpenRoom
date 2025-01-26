package com.djaquels.OpenRoom.repositories
import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.djaquels.OpenRoom.models.Room

@Repository
interface RoomsRepository : JpaRepository<Room, Int>