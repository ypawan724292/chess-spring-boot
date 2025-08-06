package com.yenimi.adapter.output

import com.yenimi.domain.model.MatchRequest
import com.yenimi.domain.model.MatchType
import com.yenimi.domain.model.MatchedPair
import com.yenimi.domain.port.Matchmaker
import org.springframework.stereotype.Component
import java.util.Queue
import java.util.concurrent.ConcurrentLinkedQueue

@Component
class InMemoryMatchmaker : Matchmaker {
    private val quickMatchQueue: Queue<String> = ConcurrentLinkedQueue()

    override fun requestMatch(request: MatchRequest): MatchedPair? {
        return when (request.type) {
            MatchType.BOT -> MatchedPair(request.userId, null, MatchType.BOT)
            MatchType.ROOM -> {
                // You can implement roomCode -> userId mapping logic here
                MatchedPair(request.userId, "other-user", MatchType.ROOM) // stub
            }

            MatchType.QUICK -> {
                val opponent = quickMatchQueue.poll()
                if (opponent != null) {
                    MatchedPair(opponent, request.userId, MatchType.QUICK)
                } else {
                    quickMatchQueue.add(request.userId)
                    null
                }
            }
        }
    }
}
