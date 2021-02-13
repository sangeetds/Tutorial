package com.login.spotify.model

data class Album(
    val id: String = "",
    val name: String = "",
    val releaseDate: String = "",
    val Images: List<Image> = listOf()
)
