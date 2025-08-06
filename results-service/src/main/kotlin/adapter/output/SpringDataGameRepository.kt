package com.yenimi.adapter.output

import com.yenimi.domain.model.GameResult
import com.yenimi.domain.port.GameHistoryRepository
import com.yenimi.infrastructure.entity.GameResultEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component

interface SpringDataGameRepository : JpaRepository<GameResultEntity, String> {
    fun findAllByPlayer1IdOrPlayer2Id(p1: String, p2: String): List<GameResultEntity>
}

@Component
class JpaGameHistoryRepository(
    private val repo: SpringDataGameRepository
) : GameHistoryRepository {

    override fun save(result: GameResult) {
        repo.save(GameResultEntity.Companion.from(result))
    }

    override fun findByUserId(userId: String): List<GameResult> {
        return repo.findAllByPlayer1IdOrPlayer2Id(userId, userId)
            .map { it.toDomain() }
    }
}