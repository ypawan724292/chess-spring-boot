package com.yenimi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MatchmakingApplication

fun main(args: Array<String>) {
    runApplication<MatchmakingApplication>(*args)
}