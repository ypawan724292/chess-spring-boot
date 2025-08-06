package com.yenimi.adapter.input

import com.yenimi.application.usecase.ProcessMoveUseCase
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.yenimi.domain.model.Move
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.util.concurrent.ConcurrentHashMap

class MoveWebSocketHandler(
    private val processMoveUseCase: ProcessMoveUseCase
) : TextWebSocketHandler() {

    private val objectMapper = jacksonObjectMapper()

    // gameId -> list of sessions
    private val gameSessions = ConcurrentHashMap<String, MutableList<WebSocketSession>>()

    override fun afterConnectionEstablished(session: WebSocketSession) {
        val gameId = session.uri?.query?.split("=")?.getOrNull(1)
        gameId?.let {
            gameSessions.computeIfAbsent(it) { mutableListOf() }.add(session)
        }
    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        val move: Move = objectMapper.readValue(message.payload)
        val processed = processMoveUseCase.execute(move)

        // Broadcast to all in game
        gameSessions[move.gameId]?.forEach {
            if (it.isOpen && it != session) {
                it.sendMessage(TextMessage(objectMapper.writeValueAsString(processed)))
            }
        }
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        gameSessions.values.forEach { it.remove(session) }
    }
}