package com.yenimi.domain.port

import com.yenimi.domain.model.User

interface UserRepository {
    fun save(user: User): User
    fun findByAndroidId(androidId: String): User?
    fun findById(id: String): User?
}