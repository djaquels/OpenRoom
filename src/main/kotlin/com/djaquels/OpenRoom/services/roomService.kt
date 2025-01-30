package com.djaquels.OpenRoom.services

import com.djaquels.OpenRoom.models.Room
import com.djaquels.OpenRoom.repositories.RoomsRepository
import org.springframework.stereotype.Service

@Service
class RoomService(private val roomsRepository: RoomsRepository) {

    fun createRoom(room: Room): Room {
        return roomsRepository.save(room)
    }

    fun getAll(): List<Room>{
        return roomsRepository.findAll().toList()
    }
}