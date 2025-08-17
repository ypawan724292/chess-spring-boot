package com.yenimi.adapter.input

import com.yenimi.application.usecase.CreateUserUseCase
import com.yenimi.domain.model.User
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

data class CreateUserRequest(val androidId: String)

@RestController
@RequestMapping("api/v1/users")
class UserController(
    private val createUserUseCase: CreateUserUseCase
) {
    @PostMapping
    fun createUser(@RequestBody request: CreateUserRequest): User {
        return createUserUseCase.execute(request.androidId)
    }
}