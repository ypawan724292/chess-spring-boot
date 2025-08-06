package com.yenimi.domain.model

import java.time.Instant

data class GameResult(
    val gameId: String,
    val player1Id: String,
    val player2Id: String,
    val winnerId: String?,
    val result: GameOutcome,
    val endedAt: Instant
)

enum class GameOutcome {
    WIN, LOSS, DRAW, ABANDONED
}
