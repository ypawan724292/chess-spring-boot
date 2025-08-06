package com.yenimi.domain.port

import com.yenimi.domain.model.MatchRequest
import com.yenimi.domain.model.MatchedPair

interface Matchmaker {
    fun requestMatch(request: MatchRequest): MatchedPair?
}