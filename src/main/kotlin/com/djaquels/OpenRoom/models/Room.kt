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
    val createdAt: LocalDateTime,
    @Column(name="updated_at")
    val updatedAT: LocalDateTime,
    @Column(name="start_date")
    val startDate: LocalDate,
    @Column(name="end_date")
    val endDate: LocalDate
) {
}