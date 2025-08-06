package com.yenimi.domain.model

data class User(
    val id: String,
    val androidId: String,
    val stats: UserStats = UserStats()
)

data class UserStats(
    val totalGames: Int = 0,
    val wins: Int = 0,
    val losses: Int = 0,
    val draws: Int = 0
)