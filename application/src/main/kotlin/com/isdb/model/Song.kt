package com.isdb.model

import javax.persistence.*

@Entity
@Table(name = "song")
data class Song(
    @Id @Column(name = "id") val id: Int = 0,
    @Column(name = "name") val name: String = "",
    @Column(name = "uri") val uri: String = "",
    @Column(name = "album") val album: String = "",
    @Column(name = "year") val releaseDate: String = ""
)
