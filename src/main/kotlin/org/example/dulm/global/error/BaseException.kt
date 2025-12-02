package org.example.dulm.exception

open class BaseException (
    val errorCode : ErrorCode
) : RuntimeException(errorCode.message)