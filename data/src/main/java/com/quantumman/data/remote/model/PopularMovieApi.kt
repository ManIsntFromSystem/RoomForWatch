package com.quantumman.data.remote.model

import com.google.gson.annotations.SerializedName

data class PopularMovieApi(
  @SerializedName("id") val id: Int,
  @SerializedName("title") val title: String,
  @SerializedName("genre_ids") val genres: List<Int>,
  @SerializedName("popularity") val popularity: String,
  @SerializedName("vote_average") val voteAverage: Float,
  @SerializedName("release_date") val releaseDate: String,
  @SerializedName("poster_path") val posterVertical: String,
  @SerializedName("backdrop_path") val posterHorizontal: String) { }