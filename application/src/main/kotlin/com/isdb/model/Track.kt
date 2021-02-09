package com.isdb.model

import com.adamratzman.spotify.models.SimpleAlbum
import com.adamratzman.spotify.models.SimpleArtist
import com.adamratzman.spotify.models.SpotifyImage
import com.adamratzman.spotify.models.SpotifyUri
import javax.persistence.*

@Entity
@Table(name = "track_item")
data class Track(
    @Id @Column(name = "id") val id: Int = 0,
    @Column(name = "artists") @OneToOne val artists: List<SimpleArtist> = mutableListOf(),
    @Column(name = "name") val name: String = "",
    @Column(name = "uri") val uri: SpotifyUri = SpotifyUri(""),
    @Column(name = "images") val images: List<SpotifyImage> = mutableListOf(),
)
