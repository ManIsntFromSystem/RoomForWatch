package com.quantumman.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class Genres(val listGenres: List<Genre>) {

    @Serializable
    data class Genre(val id: Int, val name: String) {  }
}