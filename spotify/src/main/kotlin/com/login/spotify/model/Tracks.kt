package com.login.spotify.model

import com.squareup.moshi.Json
import javax.persistence.Id

data class Tracks(
    @Id @Json(name = "tracks") val items: Item
)

data class Item(
    @Json(name = "items") val i: List<SimpleTrack>
)
