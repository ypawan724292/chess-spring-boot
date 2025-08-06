package com.yenimi.infrastructure.config

import com.yenimi.application.usecase.HandleMatchRequestUseCase
import com.yenimi.domain.port.Matchmaker
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfig {
    @Bean
    fun handleMatchRequestUseCase(matchmaker: Matchmaker): HandleMatchRequestUseCase {
        return HandleMatchRequestUseCase(matchmaker)
    }
}