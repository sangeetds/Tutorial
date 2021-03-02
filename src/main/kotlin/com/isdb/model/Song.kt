package com.isdb.model

import javax.persistence.*

@Entity
@Table(name = "song")
data class Song(
    @Id @Column(name = "id") val id: Int = 0,
    @Column(name = "name") val name: String = "",
    @Column(name = "uri") val uri: String = "",
    @Column(name = "album") val album: String = "",
    @Column(name = "year") val releaseDate: String = "",
    @Column(name = "image") val image: String? = "",
    @Column(name = "user_ratings") val userRatings: Double = 0.0,
    @Column(name = "c_ratings") val criticsRatings: Double = 0.0,
    @Column(name = "votes") val votes: Int = 0,
    @Column(name = "s_id") val spotifyId: String = ""
)
