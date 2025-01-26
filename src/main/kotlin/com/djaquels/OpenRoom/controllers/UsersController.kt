package com.djaquels.OpenRoom.controllers
import com.djaquels.OpenRoom.models.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.djaquels.OpenRoom.repositories.UsersRepository
import org.springframework.stereotype.Controller

@RestController
@RequestMapping("/api/users")
class UsersController(@Autowired private val usersRepository: UsersRepository) {
    @GetMapping("")
    fun getUsers(): List<User> {
        return usersRepository.findAll().toList()
    }

}