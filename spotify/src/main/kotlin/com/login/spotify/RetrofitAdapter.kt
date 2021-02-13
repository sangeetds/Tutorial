package com.login.spotify

import com.login.spotify.config.SpotifyDetails.Companion.spotifyAuthApiUrl
import com.login.spotify.config.SpotifyDetails.Companion.spotifyClientId
import com.login.spotify.config.SpotifyDetails.Companion.spotifyClientSecret
import com.login.spotify.config.SpotifyDetails.Companion.spotifyTrackApiUrl
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

            val intercept = if (action == Action.AUTH) BasicInterceptor(spotifyClientId, spotifyClientSecret)
            else BasicInterceptor(token!!)

            val httpClient = OkHttpClient.Builder().addInterceptor(intercept).build()

            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(if (action == Action.AUTH) spotifyAuthApiUrl else spotifyTrackApiUrl)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(httpClient)
                .build()

            return retrofit.create(SpotifyEndpoints::class.java)
        }
    }
}