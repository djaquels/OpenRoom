package com.djaquels.OpenRoom.models
import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime


@Entity
@Table(name="rooms")
class Room(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val name: String,
    @Column(name="created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name="updated_at")
    val updatedAT: LocalDateTime = LocalDateTime.now(),
    @Column(name="start_date")
    val startDate: LocalDate,
    @Column(name="end_date")
    val endDate: LocalDate,
    @OneToMany(mappedBy = "room", cascade = [CascadeType.ALL], orphanRemoval = true)
    val users: MutableSet<RoomUser> = mutableSetOf()

)