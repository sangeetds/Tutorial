package com.isdb.mapper

import com.isdb.model.SimpleTrack
import com.isdb.model.Song

class TrackSongMapper {
    companion object {
        fun List<SimpleTrack>.toSongs(): List<Song> {
            return this.map { track ->
                Song(
                    name = track.name,
                    album = track.album.toString(),
                    releaseDate = track.album.releaseDate,
                    image = track.album.Images.toString(),
                    spotifyId = track.id
                )
            }.distinctBy { it.spotifyId }
        }
    }
}