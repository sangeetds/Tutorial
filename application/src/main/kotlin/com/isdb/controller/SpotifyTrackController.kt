package com.isdb.controller

import com.adamratzman.spotify.SpotifyAppApi
import com.adamratzman.spotify.SpotifyCredentials
import com.adamratzman.spotify.models.PagingObject
import com.adamratzman.spotify.models.SimpleAlbum
import com.adamratzman.spotify.models.Track
import com.adamratzman.spotify.spotifyAppApi
import com.adamratzman.spotify.utils.Market
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.xml.bind.JAXBElement

@RestController
class SpotifyTrackController {

    @GetMapping("tracks")
    fun getTrack() {
        getSpotifyTrack()
    }

    private fun getSpotifyTrack() {
        val id = com.isdb.config.SpotifyCredentials.spotifyClientId
        val secret = com.isdb.config.SpotifyCredentials.spotifyClientSecret

        runBlocking {
            val sp = spotifyAppApi(clientId = id, clientSecret = secret).build()
            println(sp.tracks.getTracks("horse"))
        }

    }

}