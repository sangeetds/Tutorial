package com.isdb.repository

import com.isdb.model.Track
import org.springframework.data.jpa.repository.JpaRepository

interface SongsRepository : JpaRepository<Track, String>