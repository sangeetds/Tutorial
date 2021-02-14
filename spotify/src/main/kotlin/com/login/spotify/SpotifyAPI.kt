package com.login.spotify

import com.login.spotify.endpoints.getToken
import com.login.spotify.endpoints.getTrack
import com.login.spotify.enums.Action
import com.login.spotify.model.Authentications
import com.login.spotify.model.SimpleTrack
import com.login.spotify.model.Tracks
import com.login.spotify.utils.RetrofitAdapter

class SpotifyAPI {

    private fun getAuthToken(): Authentications? {
        val retrofitService = RetrofitAdapter.getRetrofit(action = Action.AUTH)
        val auth = getToken(retrofitService)
        return auth?.body()
    }

    fun getUserTrack(track: String): List<SimpleTrack> {
        val token = getAuthToken()?.access_token ?: ""
        val retrofitService = RetrofitAdapter.getRetrofit(action = Action.TRACK, token = token)
        val tracks = getTrack(service = retrofitService, trackSearchValue = track, "track")

        return when {
            tracks == null -> listOf()
            tracks.isSuccessful -> tracks.body()!!.items.tracksList
            tracks.errorBody() != null -> listOf()
            else -> listOf()
        }
    }
}