package org.example.dulm.global.error

open class BaseException (
    val errorCode : ErrorCode
) : RuntimeException(errorCode.message)