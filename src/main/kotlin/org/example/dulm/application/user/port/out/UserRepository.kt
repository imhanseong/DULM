package org.example.dulm.application.user.port.out

import org.example.dulm.domain.user.User

interface UserRepository {
    fun save(user: User): User
    fun findByEmail(email: String): User?
    fun findById(id: Long): User?
}