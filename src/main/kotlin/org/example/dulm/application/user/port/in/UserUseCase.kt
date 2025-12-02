package org.example.dulm.application.user.port.`in`

import org.example.dulm.presentation.user.dto.response.UserResponse

interface UserUseCase {
    fun signUp(email : String, password : String, nickname : String) : UserResponse
    fun getUser(id : Long) : UserResponse
}