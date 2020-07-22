package com.quantumman.data.remote.model.base

object Api {

  const val API_KEY = "86b59aba7ad323dc9326d37105201143"
  const val BASE_URL = "https://api.themoviedb.org/"
  private const val BASE_POSTER_PATH = "https://image.tmdb.org/t/p/w500/"
  private const val BASE_BACKDROP_PATH = "https://image.tmdb.org/t/p/w780"

  fun getPosterPath(url: String?): String? = if (url != null) "$BASE_POSTER_PATH$url" else null

  fun getBackdropPath(url: String?): String? = if (url != null) "$BASE_BACKDROP_PATH$url" else null
}