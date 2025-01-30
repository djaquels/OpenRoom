package com.djaquels.OpenRoom.controllers
import com.djaquels.OpenRoom.models.Room
import com.djaquels.OpenRoom.services.RoomService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.stereotype.Controller

@RestController
@RequestMapping("/api/rooms")
class RoomsController(@Autowired private val roomService: RoomService) {
    @GetMapping("")
    fun getRooms(): List<Room> {
        return roomService.getAll()
    }

    @PostMapping("/create")
    fun postRoom(@RequestBody room: Room): ResponseEntity<Room> {
        val newUser = roomService.createRoom(room)
        return ResponseEntity(newUser, HttpStatus.CREATED)
    }

}