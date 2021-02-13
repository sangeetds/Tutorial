package com.login.spotify.model

import com.squareup.moshi.Json
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

//@Entity
@Table(name = "album")
data class SimpleTrack(
    @Id @Json(name = "id") val id: String = "",
    @Json(name = "type") val type: String = "",
    @Json(name = "name") val name: String = "",
    @Json(name = "album") val album: Album = Album()
)
