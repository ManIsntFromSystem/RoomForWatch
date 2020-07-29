package com.quantumman.roomforwatch.repositories.model

import com.quantumman.data.remote.api.params.PagingState
import com.quantumman.data.remote.model.movies.CategoryType
import com.quantumman.data.remote.model.movies.MovieDTO

data class MovieCategoryModel(
  val title: String,
  val category: CategoryType,
  val dataState: PagingState<List<MovieDTO>>
)