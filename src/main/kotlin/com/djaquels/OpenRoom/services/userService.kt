package com.djaquels.OpenRoom.services

import com.djaquels.OpenRoom.models.User
import com.djaquels.OpenRoom.repositories.UsersRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UsersRepository) {

    fun createUser(user: User): User {
        return userRepository.save(user)
    }

    fun getAll(): List<User>{
        return userRepository.findAll().toList()
    }
}