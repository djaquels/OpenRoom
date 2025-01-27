package com.djaquels.OpenRoom.controllers
import com.djaquels.OpenRoom.models.User
import com.djaquels.OpenRoom.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.stereotype.Controller

@RestController
@RequestMapping("/api/users")
class UsersController(@Autowired private val userService: UserService) {
    @GetMapping("")
    fun getUsers(): List<User> {
        return userService.getAll()
    }

    @PostMapping("/create")
    fun postUser(@RequestBody user: User): ResponseEntity<User> {
        val newUser = userService.createUser(user)
        return ResponseEntity(newUser, HttpStatus.CREATED)
    }

}