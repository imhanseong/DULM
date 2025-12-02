package org.example.dulm.application.user

import org.example.dulm.application.user.port.`in`.UserUseCase
import org.example.dulm.application.user.port.out.UserRepository
import org.example.dulm.domain.user.User
import org.example.dulm.global.error.BaseException
import org.example.dulm.global.error.ErrorCode
import org.example.dulm.presentation.user.dto.response.UserResponse
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService (
    private val userRepository : UserRepository,
    private val passwordEncoder : PasswordEncoder
): UserUseCase{

    override fun signUp(email: String, password: String, nickname: String): UserResponse {
        if (userRepository.findByEmail(email) != null) {
            throw BaseException(ErrorCode.EMAIL_ALREADY_EXISTS)
        }

        val encryptedPassword = passwordEncoder.encode(password)

        val user = User(email = email, password = password, nickname = nickname)
        val savedUser = userRepository.save(user)

        return UserResponse.from(savedUser)
    }

    override fun getUser(id: Long): UserResponse {
        val user = userRepository.findById(id)
            ?: throw BaseException(ErrorCode.USER_NOT_FOUND)

        return UserResponse.from(user)
    }

}