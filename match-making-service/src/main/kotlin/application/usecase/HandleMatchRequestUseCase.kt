package com.yenimi.application.usecase

import com.yenimi.domain.model.MatchRequest
import com.yenimi.domain.model.MatchedPair
import com.yenimi.domain.port.Matchmaker

class HandleMatchRequestUseCase(
    private val matchmaker: Matchmaker
) {
    fun execute(request: MatchRequest): MatchedPair? {
        return matchmaker.requestMatch(request)
    }
}