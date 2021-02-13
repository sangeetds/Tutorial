package com.login.spotify

import com.login.spotify.config.SpotifyCredentials
import com.login.spotify.endpoints.SpotifyEndpoints
import com.login.spotify.endpoints.getToken
import com.login.spotify.endpoints.getTrack
import com.login.spotify.model.Authentications
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class SpotifyAPI {
//    init {
        val intercept = BasicInterceptor(SpotifyCredentials.spotifyClientId, SpotifyCredentials.spotifyClientSecret)
        val httpClient = OkHttpClient.Builder().addInterceptor(intercept).build()

        /**
         * Moshi helps in converting JSON objects into Java Classes and parameters.
         */
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://accounts.spotify.com/api/token/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(httpClient)
            .build()

        val service: SpotifyEndpoints = retrofit.create(SpotifyEndpoints::class.java)
//    }

    fun getAuthToken(): Authentications? {
        val a = getToken(service)
        println(a.message())
        return a.body()
    }

    fun getUserTrack() {
        val token = "BQCWhjf9-Pmb5PyJTFFM4GKjXfeOjVfi8MukM1rH3U1cit0f0poBE72xtPKi79RnqVXTFigLxX1lE6PZMxg"
        val intercept = BasicInterceptor(token)
        val httpClient = OkHttpClient.Builder().addInterceptor(intercept).build()
        val moshi2 = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
        val retrofit2: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.spotify.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi2))
            .client(httpClient)
            .build()
        val service2: SpotifyEndpoints = retrofit2.create(SpotifyEndpoints::class.java)

//        val authToken = "Bearer ${token?.access_token}"
        val ss = getTrack(service2, "horse", "track")
        println("${ss.message()} ${ss.body()}")
    }
}