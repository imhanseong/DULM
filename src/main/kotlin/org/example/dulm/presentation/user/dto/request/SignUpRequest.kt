package org.example.dulm.presentation.dto.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class SignUpRequest (

    @field:Email(message = "이메일 형식이 올바르지 않습니다")
    @field:NotBlank(message = "이메일이 비어있을 수 없습니다")
    val email : String,

    @field:NotBlank(message = "비밀번호는 비어 있을  수 없습니다.")
    val password : String,

    @field:NotBlank(message = "닉네임은 비어 있을 수 없습니다.")
    val nickname : String

)