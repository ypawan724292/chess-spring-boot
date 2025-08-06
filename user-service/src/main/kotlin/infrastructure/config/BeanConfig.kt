package com.yenimi.infrastructure.config

import com.yenimi.application.usecase.CreateUserUseCase
import com.yenimi.domain.port.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class BeanConfig {
    @Bean
    fun createUserUseCase(userRepository: UserRepository): CreateUserUseCase {
        return CreateUserUseCase(userRepository)
    }
}