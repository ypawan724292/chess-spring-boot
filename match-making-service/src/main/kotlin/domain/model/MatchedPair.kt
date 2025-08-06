package com.yenimi.domain.model

data class MatchedPair(
    val player1Id: String,
    val player2Id: String?,
    val type: MatchType
)