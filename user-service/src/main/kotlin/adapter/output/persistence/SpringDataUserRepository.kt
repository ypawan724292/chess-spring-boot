package com.yenimi.adapter.output.persistence

import com.yenimi.domain.model.User
import com.yenimi.domain.port.UserRepository
import com.yenimi.infrastructure.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component

interface SpringDataUserRepository : JpaRepository<UserEntity, String> {
    fun findByAndroidId(androidId: String): UserEntity?
}

@Component
class JpaUserRepository(
    private val springRepo: SpringDataUserRepository
) : UserRepository {

    override fun save(user: User): User {
        return springRepo.save(UserEntity.from(user)).toDomain()
    }

    override fun findByAndroidId(androidId: String): User? {
        return springRepo.findByAndroidId(androidId)?.toDomain()
    }

    override fun findById(id: String): User? {
        return springRepo.findById(id).orElse(null)?.toDomain()
    }
}