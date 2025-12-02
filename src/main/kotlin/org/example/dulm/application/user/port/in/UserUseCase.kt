package org.example.dulm.application.user.port.`in`

import org.example.dulm.presentation.dto.response.UserResponse
import org.springframework.http.ResponseEntity

interface UserUseCase {
    fun signUp(email : String, password : String, nickname : String) : UserResponse
    fun getUser(id : Long) : UserResponse
}