package com.login.spotify

import com.login.spotify.endpoints.getToken
import com.login.spotify.endpoints.getTrack
import com.login.spotify.model.Authentications

class SpotifyAPI {

    private fun getAuthToken(): Authentications? {
        val retrofitService = RetrofitAdapter.getRetrofit(action = Action.AUTH)
        val auth = getToken(retrofitService)
        return auth?.body()
    }

    fun getUserTrack() {
        val token = getAuthToken()?.access_token ?: ""
        val retrofitService = RetrofitAdapter.getRetrofit(action = Action.TRACK, token = token)
        val ss = getTrack(retrofitService, "horse", "track")
        println(ss?.body())
    }
}