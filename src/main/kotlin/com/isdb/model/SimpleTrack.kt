package com.isdb.model

import com.squareup.moshi.Json

data class SimpleTrack(
    @Json(name = "id") val id: String = "",
    @Json(name = "type") val type: String = "",
    @Json(name = "name") val name: String = "",
    @Json(name = "album") val album: Album = Album()
)
