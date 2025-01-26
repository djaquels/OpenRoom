package com.djaquels.OpenRoom.models

import jakarta.persistence.*

@Entity
@Table(name="users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val name: String,
    val email: String,
    @Column(name="profile_img")
    val profileImg: String
) {

}