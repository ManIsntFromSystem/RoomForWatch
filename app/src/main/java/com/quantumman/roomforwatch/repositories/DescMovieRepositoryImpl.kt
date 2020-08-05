package com.quantumman.roomforwatch.repositories

import com.quantumman.data.remote.api.datasources.MovieDescRemoteDataSource
import com.quantumman.data.remote.model.movies.MovieDTO
import com.quantumman.roomforwatch.R
import com.quantumman.roomforwatch.repositories.model.MovieDescModel
import com.quantumman.roomforwatch.util.ResourceProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DescMovieRepositoryImpl  @Inject constructor(
  private val dataSource: MovieDescRemoteDataSource,
  private val resource: ResourceProvider
) : DescMovieRepository {

  override fun data(): Flow<MovieDescModel> = dataSource.observe().map {
    MovieDescModel(
      title = resource.string(R.string.description_movie_title),
      dataState = it
    )
  }

  override suspend fun getMovieById(movieId: Int) = dataSource.getMovieByIdDS(movieId)
}