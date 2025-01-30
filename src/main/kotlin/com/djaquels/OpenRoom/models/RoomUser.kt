package com.djaquels.OpenRoom.models
import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name="room_users")
class RoomUser (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @ManyToOne 
    @JoinColumn(name = "user_id")
    val user: User,
    @ManyToOne
    @JoinColumn(name="room_id")
    val room: Room,
    @ManyToOne
    @JoinColumn(name = "role_id")
    val role: Role,
    @Column(name="created_at")
    val createdAt: LocalDateTime? = LocalDateTime.now(),
    @Column(name="updated_at")
    val updatedAT: LocalDateTime? = LocalDateTime.now()
)