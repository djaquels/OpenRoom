package com.djaquels.OpenRoom.repositories
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository
import com.djaquels.OpenRoom.models.User

@Repository
interface UsersRepository: JpaRepository<User,Int>