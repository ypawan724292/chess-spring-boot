package com.yenimi.domain.model

enum class MatchType {
    QUICK, ROOM, BOT
}

data class MatchRequest(
    val userId: String,
    val type: MatchType,
    val roomCode: String? = null
)