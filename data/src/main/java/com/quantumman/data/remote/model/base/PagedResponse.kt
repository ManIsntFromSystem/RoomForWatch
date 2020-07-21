package com.quantumman.data.remote.model.base

import com.google.gson.annotations.SerializedName
import com.quantumman.data.remote.model.PopularMovieApi

data class PagedResponse(
  @SerializedName("page") val page: Int,
  @SerializedName("total_results") val totalResult: Int,
  @SerializedName("total_pages") val totalPages: Int,
  @SerializedName("results") val results: List<PopularMovieApi>
) {  } //TODO BaseClass and inherit from that one