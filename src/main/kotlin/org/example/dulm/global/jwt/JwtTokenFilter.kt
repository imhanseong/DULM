package org.example.dulm.global.jwt

import io.jsonwebtoken.JwtException
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter

class JwtTokenFilter(
    private val jwtTokenProvider: JwtTokenProvider
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = jwtTokenProvider.resolveToken(request)

        token?.let {
            try {
                val authentication = jwtTokenProvider.authentication(it)
                SecurityContextHolder.getContext().authentication = authentication
            } catch (_: io.jsonwebtoken.ExpiredJwtException) {
            } catch (_: JwtException) {
            } catch (_: Exception) {
            }
        }

        filterChain.doFilter(request, response)
    }
}