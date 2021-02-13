package com.login.spotify.model

import com.squareup.moshi.Json
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

//@Entity
//@Table(name = "artist")
data class Artist(
    @Id @Json(name = "tracks") val items: Item
//    val name: String = ""
//    val type: String = "",
)

data class Item(
    @Json(name = "items") val i: List<Track>
)
