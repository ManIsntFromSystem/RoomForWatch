package com.quantumman.data.remote.api.datasources

import com.quantumman.data.remote.api.MovieState
import com.quantumman.data.remote.model.movies.MovieDetailedDTO
import com.quantumman.data.remote.services.MovieService
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject

class MovieDescRemoteDataSource @Inject constructor(private val api: MovieService) {

  private val chanel = ConflatedBroadcastChannel<MovieState<MovieDetailedDTO>>(MovieState.Initial)

  @Synchronized
  suspend fun getMovieByIdDS(movieId: Int) {
    if (chanel.value is MovieState.Initial) {
      val response = api.fetchMovieById(id = movieId)
      chanel.send(MovieState.Content(response))
    }
  }

  fun observe(): Flow<MovieState<MovieDetailedDTO>> = chanel.asFlow()
}