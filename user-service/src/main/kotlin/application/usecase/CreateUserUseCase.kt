package com.yenimi.application.usecase

import com.yenimi.domain.model.User
import com.yenimi.domain.port.UserRepository
import java.util.UUID

class CreateUserUseCase(private val userRepository: UserRepository) {
    fun execute(androidId: String): User {
        return userRepository.findByAndroidId(androidId)
            ?: userRepository.save(User(UUID.randomUUID().toString(), androidId))
    }
}