package com.login.spotify

import okhttp3.Credentials
import java.util.*

fun main() {
//    val str = "NjA4ZTg3NTBhYTdkNGMzYWJiZjgyZTEyZmMxOTUyMTA6OWZlZjI4NmQ2NjQ2NDg4NmI2NjE5YzViY2M0OTM4NTI="
//    println(Credentials.basic("608e8750aa7d4c3abbf82e12fc195210", "9fef286d66464886b6619c5bcc493852"))

    val s = SpotifyAPI()
    s.getUserTrack()
}