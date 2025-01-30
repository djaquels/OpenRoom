package com.djaquels.OpenRoom.services

import com.djaquels.OpenRoom.models.User
import com.djaquels.OpenRoom.models.Room
import com.djaquels.OpenRoom.models.RoomUser
import com.djaquels.OpenRoom.models.Role
import com.djaquels.OpenRoom.repositories.RoomUsersRepository
import com.djaquels.OpenRoom.repositories.UsersRepository
import com.djaquels.OpenRoom.repositories.RoomsRepository
import com.djaquels.OpenRoom.repositories.RolesRepository
import com.djaquels.OpenRoom.controllers.RoomUserDto
import org.springframework.stereotype.Service
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.boot.json.JacksonJsonParser
import jakarta.persistence.EntityNotFoundException

@Service
class RoomUsersService(
    private val roomUsersRepository: RoomUsersRepository,
    private val userRepository: UsersRepository,
    private val roomsRepository: RoomsRepository,
    private val rolesRepository: RolesRepository,
) {

    fun createRoomUser(
        user_id: Int,
        roomUserDTO: RoomUserDto): RoomUser {
            val user: User = userRepository.findById(user_id).orElseThrow{ EntityNotFoundException("User not found!") }
            val room: Room = roomsRepository.findById(roomUserDTO.roomId).orElseThrow{EntityNotFoundException("Room not found!")}
            val role: Role = rolesRepository.findById(roomUserDTO.roleId).orElseThrow({EntityNotFoundException("Role not found!")})
            val roomUserAsoc = roomUsersRepository.save(
            RoomUser(0,user,room,role)
            )
            return roomUserAsoc
    }

    fun getAll(): List<RoomUser>{
        return roomUsersRepository.findAll().toList()
    }
}