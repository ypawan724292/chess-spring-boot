package com.yenimi.infrastrucure.config

import com.yenimi.adapter.input.MoveWebSocketHandler
import com.yenimi.application.usecase.ProcessMoveUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

@Configuration
@EnableWebSocket
class WebSocketConfig : WebSocketConfigurer {

    @Bean
    fun processMoveUseCase() = ProcessMoveUseCase()

    @Bean
    fun moveWebSocketHandler(useCase: ProcessMoveUseCase) = MoveWebSocketHandler(useCase)

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(moveWebSocketHandler(processMoveUseCase()), "/ws/move")
            .setAllowedOrigins("*")
    }
}