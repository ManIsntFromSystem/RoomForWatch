package com.quantumman.data.remote.services

object ApiEndPoint {
  private const val BASE_MOVIE_ENDPOINT = "/3/movie"
  const val ENDPOINT_POPULAR_MOVIES = "$BASE_MOVIE_ENDPOINT/popular"
  const val ENDPOINT_NOW_PLAYING_MOVIES = "$BASE_MOVIE_ENDPOINT/now_playing"
  const val ENDPOINT_UPCOMING_MOVIES = "$BASE_MOVIE_ENDPOINT/upcoming"
  const val ENDPOINT_TOP_RATED_MOVIES = "$BASE_MOVIE_ENDPOINT/top_rated"
  const val ENDPOINT_MOVIE_BY_ID = "$BASE_MOVIE_ENDPOINT/{movie_id}"
  const val ENDPOINT_MOVIE_GENRES = "/3/genre/movie/list"
}