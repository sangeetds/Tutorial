package com.isdb.controller

import com.adamratzman.spotify.SpotifyAppApi
import com.adamratzman.spotify.models.PagingObject
import com.adamratzman.spotify.models.SimpleAlbum
import com.adamratzman.spotify.spotifyAppApi
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.xml.bind.JAXBElement

@RestController
class SpotifyTrackController {

    @GetMapping("tracks")
    fun getTrack() {

    }

    private fun getSpotifyTrack() {

    }

}