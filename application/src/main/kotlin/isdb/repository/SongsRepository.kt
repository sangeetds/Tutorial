package isdb.repository

import isdb.model.Song
import org.springframework.data.jpa.repository.JpaRepository

interface SongsRepository : JpaRepository<Song, String>