package com.quantumman.data.remote.model.base

import com.google.gson.annotations.SerializedName
import com.quantumman.data.remote.model.movies.Dates
import com.quantumman.data.remote.model.movies.MovieDTO

data class BasePagedResponse(
  @SerializedName("page") val page: Int,
  @SerializedName("total_results") val totalResult: Int,
  @SerializedName("dates") val dates : Dates,
  @SerializedName("total_pages") val totalPages: Int,
  @SerializedName("results") val results: List<MovieDTO>
)

