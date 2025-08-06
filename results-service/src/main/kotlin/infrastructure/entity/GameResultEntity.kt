package com.yenimi.infrastructure.entity

import com.yenimi.domain.model.GameOutcome
import com.yenimi.domain.model.GameResult
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant

@Entity
@Table(name = "game_results")
data class GameResultEntity(
    @Id val gameId: String,
    val player1Id: String,
    val player2Id: String,
    val winnerId: String?,
    @Enumerated(EnumType.STRING)
    val result: GameOutcome,
    val endedAt: Instant
) {
    fun toDomain() = GameResult(
        gameId = gameId,
        player1Id = player1Id,
        player2Id = player2Id,
        winnerId = winnerId,
        result = result,
        endedAt = endedAt
    )

    companion object {
        fun from(result: GameResult) = GameResultEntity(
            gameId = result.gameId,
            player1Id = result.player1Id,
            player2Id = result.player2Id,
            winnerId = result.winnerId,
            result = result.result,
            endedAt = result.endedAt
        )
    }
}