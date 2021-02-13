package com.login.spotify

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class BasicInterceptor(user: String, password: String? = null) : Interceptor {
    private val credentials: String = password?.apply { Credentials.basic(user, password) } ?: "Bearer $user"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val authenticatedRequest: Request = request.newBuilder()
            .header("Authorization", credentials).build()
        return chain.proceed(authenticatedRequest)
    }
}