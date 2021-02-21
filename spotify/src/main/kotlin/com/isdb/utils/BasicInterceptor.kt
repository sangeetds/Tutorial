package com.isdb.utils

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class BasicInterceptor(user: String, password: String? = null) : Interceptor {
    private val credentials: String? = if (password != null) Credentials.basic(user, password) else null
    private val token = "Bearer $user"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val authenticatedRequest: Request = request.newBuilder()
            .header("Authorization", this.credentials?:this.token).build()

        return chain.proceed(authenticatedRequest)
    }
}