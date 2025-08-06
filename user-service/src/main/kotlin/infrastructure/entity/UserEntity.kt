package com.yenimi.infrastructure.entity

import com.yenimi.domain.model.User
import com.yenimi.domain.model.UserStats
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users")
data class UserEntity(
    @Id val id: String,
    val androidId: String,
    val totalGames: Int = 0,
    val wins: Int = 0,
    val losses: Int = 0,
    val draws: Int = 0
) {
    fun toDomain() = User(
        id = id,
        androidId = androidId,
        stats = UserStats(totalGames, wins, losses, draws)
    )

    companion object {
        fun from(user: User) = UserEntity(
            id = user.id,
            androidId = user.androidId,
            totalGames = user.stats.totalGames,
            wins = user.stats.wins,
            losses = user.stats.losses,
            draws = user.stats.draws
        )
    }
}