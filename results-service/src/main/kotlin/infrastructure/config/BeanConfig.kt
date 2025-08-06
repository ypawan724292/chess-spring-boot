package com.yenimi.infrastructure.config

import com.yenimi.application.usecase.GetUserGameHistoryUseCase
import com.yenimi.application.usecase.SaveGameResultUseCase
import com.yenimi.domain.port.GameHistoryRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfig {

    @Bean
    fun saveGameResultUseCase(repo: GameHistoryRepository) =
        SaveGameResultUseCase(repo)

    @Bean
    fun getUserGameHistoryUseCase(repo: GameHistoryRepository) =
        GetUserGameHistoryUseCase(repo)
}