package com.yenimi.application.usecase

import com.yenimi.domain.model.GameResult
import com.yenimi.domain.port.GameHistoryRepository

class SaveGameResultUseCase(
    private val repo: GameHistoryRepository
) {
    fun execute(result: GameResult) {
        repo.save(result)
    }
}