package com.quantumman.roomforwatch.interactors.detals

import com.quantumman.data.remote.api.Api
import com.quantumman.data.remote.api.MovieState
import com.quantumman.roomforwatch.model.base.DescriptionItem
import com.quantumman.roomforwatch.model.movies.description.DescriptionMovie
import com.quantumman.roomforwatch.model.movies.description.ProgressDescriptionMovie
import com.quantumman.roomforwatch.repositories.description.DescMovieRepository
import com.quantumman.roomforwatch.repositories.model.MovieDescModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class DescMovieScreenInteractorImpl @Inject constructor(
  private val descMovieRepository: DescMovieRepository
) : DescMovieScreenInteractor {

  override fun data(): Flow<DescriptionItem> = combine(descMovieRepository.data()) { mapToDescription(it.first()) }

  private fun mapToDescription(model: MovieDescModel): DescriptionItem = when(model.dataState){
    is MovieState.Initial -> {
      ProgressDescriptionMovie
    }
    is MovieState.Content -> {
      val movie = model.dataState.data
      DescriptionMovie(
        id = movie.id,
        title = movie.title,
        overview = movie.overview.orEmpty(),
        image = Api.getBackdropPath(movie.posterBackHorizontal)
      )
    }
  }

  override suspend fun getMovieById(movieId: Int) = descMovieRepository.getMovieById(movieId)
}