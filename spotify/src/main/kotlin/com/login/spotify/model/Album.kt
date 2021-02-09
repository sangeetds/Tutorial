package com.login.spotify.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "album")
data class Album(
    @Id val id: String = "",
    val type: String = "",
    val releaseYear: String = "",
    val totalTracks: Int = 0,
    val name: String = ""
)
