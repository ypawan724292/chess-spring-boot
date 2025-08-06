package com.yenimi.domain.port

import com.yenimi.domain.model.GameResult

interface GameHistoryRepository {
    fun save(result: GameResult)
    fun findByUserId(userId: String): List<GameResult>
}