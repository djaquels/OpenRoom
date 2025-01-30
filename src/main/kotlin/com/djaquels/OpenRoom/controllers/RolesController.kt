package com.djaquels.OpenRoom.controllers
import com.djaquels.OpenRoom.models.Role
import com.djaquels.OpenRoom.services.RolesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.stereotype.Controller

@RestController
@RequestMapping("/api/roles")
class RolesController(@Autowired private val rolesService: RolesService) {
    @GetMapping("")
    fun getRoles(): List<Role> {
        return rolesService.getAll()
    }

    @PostMapping("/create")
    fun postRole(@RequestBody role: Role): ResponseEntity<Role> {
        val newUser = rolesService.createRole(role)
        return ResponseEntity(newUser, HttpStatus.CREATED)
    }

}