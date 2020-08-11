package com.quantumman.roomforwatch.extensions

object ApiData {
  const val BASE_POSTER_PATH = "https://image.tmdb.org/t/p/w500/"
  const val BASE_BACKDROP_PATH = "https://image.tmdb.org/t/p/w780"
}

fun String?.getPosterPath() = if (this != null) "${ApiData.BASE_POSTER_PATH}$this" else null

fun String?.getBackdropPath() = if (this != null) "${ApiData.BASE_BACKDROP_PATH}$this" else null