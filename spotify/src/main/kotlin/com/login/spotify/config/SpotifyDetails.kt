package com.login.spotify.config

interface SpotifyDetails {
    companion object {
        const val spotifyClientId = "608e8750aa7d4c3abbf82e12fc195210"
        const val spotifyClientSecret = "9fef286d66464886b6619c5bcc493852"
        const val spotifyAuthApiUrl = "https://accounts.spotify.com/api/token/"
        const val spotifyTrackApiUrl = "https://api.spotify.com/"
    }
}