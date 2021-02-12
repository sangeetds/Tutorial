package com.login.spotify.endpoints

import com.login.spotify.model.Track
import com.login.spotify.model.Authentications
import retrofit2.Call
import retrofit2.http.*


interface SpotifyEndpoints {

    @FormUrlEncoded
    @Headers("Authorization: Basic ")
    @POST("/api/token")
    fun getAuthToken(@Field("grant_type") key: String = "client_credentials"): Call<Authentications>

    @GET("/v1/search")
    fun getTrack(
        @Header("Authorization") authToken: String,
        @Query("q") trackSearchValue: String,
        @Query("type") searchType: String
    ): Call<List<Track>>
}

fun getToken(service: SpotifyEndpoints) = service.getAuthToken().execute().body()

fun getTrack(service: SpotifyEndpoints, authToken: String, trackSearchValue: String, searchType: String) = service.getTrack(authToken,
    trackSearchValue, searchType).execute().body()