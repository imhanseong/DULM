package org.example.dulm.global.error

enum class ErrorCode (
    val message : String,
    val status : Int
){
    // USER
    USER_NOT_FOUND("사용자를 찾을 수 없습니다", 404),
    EMAIL_ALREADY_EXISTS("이미 존재하는 이메일입니다", 400),
    INVALID_PASSWORD("비밀번호가 잘못되었습니다", 400),

    // COMMON
    INVALID_INPUT("잘못된 입력값입니다", 400),
    INTERNAL_SERVER_ERROR("서버 오류가 발생했습니다", 500)
}