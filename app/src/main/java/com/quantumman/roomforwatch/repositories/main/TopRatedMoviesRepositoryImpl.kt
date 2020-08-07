package com.quantumman.roomforwatch.repositories.main

import com.quantumman.data.remote.api.datasources.MoviesRemoteDataSource
import com.quantumman.data.remote.model.movies.CategoryType
import com.quantumman.roomforwatch.R
import com.quantumman.roomforwatch.repositories.model.MovieCategoryModel
import com.quantumman.roomforwatch.util.ResourceProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TopRatedMoviesRepositoryImpl @Inject constructor(
  private val dataSource: MoviesRemoteDataSource,
  private val resource: ResourceProvider
) : MovieCategoryRepository {

  private val categoryType = CategoryType.TopRated

  override fun data(): Flow<MovieCategoryModel> = dataSource.observe().map {
    MovieCategoryModel(
      title = resource.string(R.string.category_top_rated),
      category = categoryType,
      dataState = it
    )
  }

  override suspend fun init() {
    dataSource.initialLoading(categoryType)
  }

  override suspend fun loadMore(index: Int) {
    dataSource.loadMore(categoryType, index)
  }
}