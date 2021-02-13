package com.login.spotify.endpoints

import com.login.spotify.model.Artist
import com.login.spotify.model.Track
import com.login.spotify.model.Authentications
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface SpotifyEndpoints {

    @FormUrlEncoded
//    @Headers("Authorization: Basic NjA4ZTg3NTBhYTdkNGMzYWJiZjgyZTEyZmMxOTUyMTA6OWZlZjI4NmQ2NjQ2NDg4NmI2NjE5YzViY2M0OTM4NTI=")
    @POST("/api/token")
    fun getAuthToken(@Field("grant_type") key: String = "client_credentials"): Call<Authentications>

    @Headers("Authorization: Bearer BQCdEzSBOoXLUimn5ceQmRHNHvXdEf3ac_d70h5DRQOUlDhT-W8o4QGuh9o44R-uGJWpR3S-BpP2KaaN9rI")
    @GET("/v1/search")
    fun getTrack(
        @Query("q") trackSearchValue: String,
        @Query("type") searchType: String
    ): Call<Artist>
}

fun getToken(service: SpotifyEndpoints) = service.getAuthToken().execute()

fun getTrack(service: SpotifyEndpoints, trackSearchValue: String, searchType: String): Response<Artist> {
    val a = service.getTrack(
        trackSearchValue, searchType
    )

    return a.execute()
}