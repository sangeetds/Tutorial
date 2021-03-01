package com.isdb.model

import com.squareup.moshi.Json

data class Authentications(
    @Json(name = "access_token") val access_token: String,
    @Json(name = "token_type") val token_type: String,
    @Json(name = "expires_in") val expiresIn: String
)
