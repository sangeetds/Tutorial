package com.login.spotify.model

import com.squareup.moshi.Json
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "album")
data class Track(
    @Id @Json(name = "id") val id: String = "",
    @Json(name = "type") val type: String = "",
//    val releaseYear: String = "",
//    val totalTracks: Int = 0,
    @Json(name = "name") val name: String = ""
)
