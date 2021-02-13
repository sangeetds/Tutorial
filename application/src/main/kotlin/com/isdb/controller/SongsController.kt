package com.isdb.controller

import com.isdb.model.Song
import com.isdb.repository.SongsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SongsController(@Autowired val songsRepository: SongsRepository) {

    @GetMapping("tracks")
    fun getSongs(): ResponseEntity<MutableList<Song>> {
        return ResponseEntity.ok().body(this.songsRepository.findAll())
    }
}