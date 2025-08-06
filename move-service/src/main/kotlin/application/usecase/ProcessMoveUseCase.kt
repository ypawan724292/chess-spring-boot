package com.yenimi.application.usecase

import com.yenimi.domain.model.Move

class ProcessMoveUseCase {
    fun execute(move: Move): Move {
        // Later: validate, persist, or send to Kafka
        return move
    }
}