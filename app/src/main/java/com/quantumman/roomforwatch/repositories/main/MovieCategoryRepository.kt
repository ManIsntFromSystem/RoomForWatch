package com.quantumman.roomforwatch.repositories.main

import com.quantumman.roomforwatch.repositories.model.MovieCategoryModel
import kotlinx.coroutines.flow.Flow

interface MovieCategoryRepository {

  fun data(): Flow<MovieCategoryModel>

  suspend fun init()

  suspend fun loadMore(index: Int)
}