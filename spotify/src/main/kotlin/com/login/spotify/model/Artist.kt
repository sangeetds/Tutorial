package com.login.spotify.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "artist")
data class Artist(
    @Id val id: String = "",
    val name: String = "",
    val type: String = "",
)
