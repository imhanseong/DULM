package org.example.dulm.global.jwt

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class JwtTokenProvider (
    @Value("\${jwt.secret}") private val secretKey: String,
    @Value("\${jwt.access-expiration}") private val accessExp: Long,
    @Value("\${jwt.refresh-expiration}") private val refreshExp: Long
) : TokenProviderPort {
    
}