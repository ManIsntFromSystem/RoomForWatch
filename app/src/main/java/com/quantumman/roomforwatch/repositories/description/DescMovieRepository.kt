package com.quantumman.roomforwatch.repositories.description

import com.quantumman.roomforwatch.repositories.model.MovieDescriptionModel
import kotlinx.coroutines.flow.Flow

interface DescMovieRepository {
  fun data(): Flow<MovieDescriptionModel>

  suspend fun getMovieById(movieId: Int)
}