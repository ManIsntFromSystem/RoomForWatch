package com.quantumman.roomforwatch.repositories

import com.quantumman.roomforwatch.repositories.model.MovieDescModel
import kotlinx.coroutines.flow.Flow

interface DescMovieRepository {
  fun data(): Flow<MovieDescModel>

  suspend fun getMovieById(movieId: Int)
}