package com.login.spotify

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
        val httpClient = OkHttpClient.Builder().build()

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
        return getToken(service)
    }

    fun getUserTrack() {
        val token = getAuthToken()!!
        println(token)
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.spotify.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(httpClient)
            .build()
        val service2: SpotifyEndpoints = retrofit.create(SpotifyEndpoints::class.java)

        println(getTrack(service2, "Bearer + ${token.access_token}", "eye", "track"))
    }
}