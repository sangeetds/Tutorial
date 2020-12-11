package com.example.login

import com.squareup.moshi.Json


data class User(
    @field:Json(name = "username") val username: String,
    @field:Json(name = "password") var password: String,
    @field:Json(name = "email") val email: String? = null
    ){

}