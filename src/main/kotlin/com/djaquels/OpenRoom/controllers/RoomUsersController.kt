package com.djaquels.OpenRoom.controllers
import com.djaquels.OpenRoom.models.RoomUser
import com.djaquels.OpenRoom.services.RoomUsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.stereotype.Controller

@RestController
@RequestMapping("/api/roomUsers")
class RoomUsersController(@Autowired private val roomUsersService: RoomUsersService) {
    @GetMapping("")
    fun getAsocs(): List<RoomUser> {
        return roomUsersService.getAll()
    }

    @PostMapping("/create/{user_id}")
    fun postAsoc(
        @PathVariable user_id: Int,    
        @RequestBody roomUserDto: RoomUserDto): ResponseEntity<RoomUser> {
        val newRoomUser: RoomUser =  roomUsersService.createRoomUser(user_id,roomUserDto)
        return ResponseEntity(newRoomUser, HttpStatus.CREATED)
    }
   

}