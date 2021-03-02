package com.isdb.spotify

import com.isdb.endpoints.getToken
import com.isdb.endpoints.getTrack
import com.isdb.enums.Action
import com.isdb.model.Authentications
import com.isdb.model.SimpleTrack
import com.isdb.utils.RetrofitAdapter

class SpotifyAPI {

    private fun getAuthToken(): Authentications? {
        val retrofitService = RetrofitAdapter.getRetrofit(action = Action.AUTH)
        val auth = getToken(retrofitService)
        return auth.body()
    }

    fun getUserTrack(track: String): List<SimpleTrack> {
        val token = getAuthToken()?.access_token ?: ""
        val retrofitService = RetrofitAdapter.getRetrofit(action = Action.TRACK, token = token)
        val tracks = getTrack(service = retrofitService, trackSearchValue = track, "track")

        return when {
            tracks.isSuccessful -> tracks.body()!!.items.tracksList
            tracks.errorBody() != null -> listOf()
            else -> listOf()
        }
    }
}