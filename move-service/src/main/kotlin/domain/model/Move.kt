package com.yenimi.domain.model

data class Move(
    val gameId: String,
    val from: String,
    val to: String,
    val byUserId: String
)