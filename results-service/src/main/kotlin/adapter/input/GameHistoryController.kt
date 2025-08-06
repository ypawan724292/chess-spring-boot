package com.yenimi.adapter.input

import com.yenimi.application.usecase.GetUserGameHistoryUseCase
import com.yenimi.application.usecase.SaveGameResultUseCase
import com.yenimi.domain.model.GameResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/history")
class GameHistoryController(
    private val saveGameResult: SaveGameResultUseCase,
    private val getHistory: GetUserGameHistoryUseCase
) {
    @PostMapping
    fun saveGame(@RequestBody result: GameResult) {
        saveGameResult.execute(result)
    }

    @GetMapping("/{userId}")
    fun getUserGames(@PathVariable userId: String): List<GameResult> {
        return getHistory.execute(userId)
    }
}