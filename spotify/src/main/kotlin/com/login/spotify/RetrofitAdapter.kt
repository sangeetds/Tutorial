package com.login.spotify

import com.login.spotify.config.SpotifyCredentials
import com.login.spotify.endpoints.SpotifyEndpoints
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitAdapter {

    companion object {

        fun getRetrofit(action: Action, token: String? = null): SpotifyEndpoints {
            val moshi = Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()

            val intercept = if (action == Action.AUTH) BasicInterceptor(SpotifyCredentials.spotifyClientId, SpotifyCredentials.spotifyClientSecret)
            else BasicInterceptor(token!!)

            val httpClient = OkHttpClient.Builder().addInterceptor(intercept).build()

            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(if (action == Action.AUTH) SpotifyCredentials.spotifyAuthApiUrl else SpotifyCredentials.spotifyTrackApiUrl)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(httpClient)
                .build()

            return retrofit.create(SpotifyEndpoints::class.java)
        }
    }
}