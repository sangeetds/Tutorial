package com.isdb.repository

import com.isdb.model.Song
import org.springframework.data.jpa.repository.JpaRepository

interface SongsRepository : JpaRepository<Song, String>