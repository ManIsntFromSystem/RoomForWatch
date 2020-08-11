package com.quantumman.roomforwatch.repositories.description

import com.quantumman.data.remote.api.datasources.MovieDescRemoteDataSource
import com.quantumman.roomforwatch.R
import com.quantumman.roomforwatch.repositories.model.MovieDescriptionModel
import com.quantumman.roomforwatch.util.ResourceProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DescMovieRepositoryImpl  @Inject constructor(
  private val dataSource: MovieDescRemoteDataSource,
  private val resource: ResourceProvider
) : DescMovieRepository {

  override fun data(): Flow<MovieDescriptionModel> = dataSource.observe().map {
    MovieDescriptionModel(
      title = resource.string(R.string.description_movie_title),
      dataState = it
    )
  }

  override suspend fun getMovieById(movieId: Int) = dataSource.getMovieByIdDS(movieId)
}