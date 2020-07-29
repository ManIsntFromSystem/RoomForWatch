package com.quantumman.data.remote.model.movies

sealed class CategoryType {
    object NowPlaying : CategoryType()
    object Popular : CategoryType()
    object Upcoming : CategoryType()
    object TopRated : CategoryType()
    data class Genre(val id: Int): CategoryType()
}