package com.example.login

import com.squareup.moshi.Json

enum class Status {
    @field:Json(name = "SUCCESS")SUCCESS,
    @field:Json(name = "USER_ALREADY_EXISTS")USER_ALREADY_EXISTS,
    @field:Json(name = "FAILURE")FAILURE
}