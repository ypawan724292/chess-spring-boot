package com.yenimi.adapter.input

import com.yenimi.application.usecase.HandleMatchRequestUseCase
import com.yenimi.domain.model.MatchRequest
import com.yenimi.domain.model.MatchedPair
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/matchmaking")
class MatchmakingController(
    private val handleMatchRequestUseCase: HandleMatchRequestUseCase
) {
    @PostMapping
    fun requestMatch(@RequestBody req: MatchRequest): ResponseEntity<MatchedPair?> {
        val result = handleMatchRequestUseCase.execute(req)
        return ResponseEntity.ok(result)
    }
}