package com.isdb.repository

import com.isdb.model.Song
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SongsRepository : JpaRepository<Song, String>
