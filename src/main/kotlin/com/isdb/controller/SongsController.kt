package com.isdb.controller

import com.isdb.mapper.TrackSongMapper.Companion.toSongs
import com.isdb.model.Song
import com.isdb.repository.UserRepository
import com.isdb.repository.SongsRepository
import com.isdb.spotify.SpotifyAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.lang.Nullable
import org.springframework.web.bind.annotation.*

@RestController
class SongsController(@Autowired val songsRepository: SongsRepository) {

    @GetMapping("tracks")
    fun getSongs(@Nullable @RequestParam("search") songName: String?): ResponseEntity<List<Song>> {
        songName?.let {
            val ratedSongs = this.songsRepository.findAll()
            val searchSongs = SpotifyAPI().getUserTrack(songName).toSongs()

            return ResponseEntity.ok().body(ratedSongs + searchSongs)
        }

        return ResponseEntity.ok().body(this.songsRepository.findAll())
    }

    @PostMapping("tracks")
    fun rateSong(@RequestBody song: Song): Song = this.songsRepository.save(song)

}