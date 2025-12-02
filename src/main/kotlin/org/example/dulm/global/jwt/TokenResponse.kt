package org.example.dulm.global.jwt

data class TokenResponse (
    val accessToken : String,
    val refreshToken : String
)