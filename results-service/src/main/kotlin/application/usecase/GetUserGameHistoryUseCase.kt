package com.yenimi.application.usecase

import com.yenimi.domain.model.GameResult
import com.yenimi.domain.port.GameHistoryRepository

class GetUserGameHistoryUseCase(
    private val repo: GameHistoryRepository
) {
    fun execute(userId: String): List<GameResult> {
        return repo.findByUserId(userId)
    }
}