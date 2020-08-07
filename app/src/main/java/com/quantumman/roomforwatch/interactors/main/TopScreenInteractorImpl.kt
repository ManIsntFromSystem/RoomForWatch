package com.quantumman.roomforwatch.interactors.main

import com.quantumman.data.remote.api.Api
import com.quantumman.data.remote.api.PagingState
import com.quantumman.data.remote.api.datasources.MoviesRemoteDataSource
import com.quantumman.data.remote.model.movies.CategoryType
import com.quantumman.data.remote.services.MovieService
import com.quantumman.roomforwatch.model.base.ListItem
import com.quantumman.roomforwatch.model.movies.topscreen.ItemTopsMovieThin
import com.quantumman.roomforwatch.model.movies.topscreen.ProgressThinItem
import com.quantumman.roomforwatch.model.movies.topscreen.TopsMoviesHorizontalItem
import com.quantumman.roomforwatch.repositories.main.*
import com.quantumman.roomforwatch.repositories.model.MovieCategoryModel
import com.quantumman.roomforwatch.util.ResourceProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class TopScreenInteractorImpl @Inject constructor(
  api: MovieService,
  resourceProvider: ResourceProvider
) : TopScreenInteractor {

  private val nowPlayingRepository: MovieCategoryRepository =
    NowPlayingMoviesRepositoryImpl(
      MoviesRemoteDataSource(api), resourceProvider
    )
  private val popularRepository: MovieCategoryRepository =
    PopularMoviesRepositoryImpl(
      MoviesRemoteDataSource(api), resourceProvider
    )
  private val upcomingRepository: MovieCategoryRepository =
    UpcomingMoviesRepositoryImpl(
      MoviesRemoteDataSource(api), resourceProvider
    )
  private val topRatedRepository: MovieCategoryRepository =
    TopRatedMoviesRepositoryImpl(
      MoviesRemoteDataSource(api), resourceProvider
    )

  override fun data(): Flow<List<ListItem>> = combine(
    nowPlayingRepository.data(),
    popularRepository.data(),
    upcomingRepository.data(),
    topRatedRepository.data()
  ) { nowPlaying, popular, upcoming, rated ->
    listOf(
      mapToCategory(nowPlaying),
      mapToCategory(popular),
      mapToCategory(upcoming),
      mapToCategory(rated)
    )
  }

  override suspend fun initCategory(category: CategoryType) {
    when (category) {
      is CategoryType.NowPlaying -> nowPlayingRepository.init()
      is CategoryType.Popular -> popularRepository.init()
      is CategoryType.Upcoming -> upcomingRepository.init()
      is CategoryType.TopRated -> topRatedRepository.init()
    }
  }

  override suspend fun tryToLoadMore(category: CategoryType, index: Int) {
    when (category) {
      is CategoryType.NowPlaying -> nowPlayingRepository.loadMore(index)
      is CategoryType.Popular -> popularRepository.loadMore(index)
      is CategoryType.Upcoming -> upcomingRepository.loadMore(index)
      is CategoryType.TopRated -> topRatedRepository.loadMore(index)
    }
  }

  private fun mapToCategory(model: MovieCategoryModel): ListItem = when (model.dataState) {
    is PagingState.Initial -> {
      TopsMoviesHorizontalItem(
        title = model.title,
        category = model.category,
        movies = IntRange(1, 3).map { ProgressThinItem }
      )
    }
    is PagingState.Content -> {
      TopsMoviesHorizontalItem(
        title = model.title,
        category = model.category,
        movies = model.dataState.data.map {
          ItemTopsMovieThin(
            id = it.id,
            title = it.title,
            image = Api.getPosterPath(it.posterVertical)
          )
        }
      )
    }
    is PagingState.Paging -> {
      TopsMoviesHorizontalItem(
        title = model.title,
        category = model.category,
        movies = model.dataState.availableContent.map {
          ItemTopsMovieThin(
            id = it.id,
            title = it.title,
            image = Api.getPosterPath(it.posterVertical)
          )
        }.plus(ProgressThinItem)
      )
    }
    else -> throw IllegalArgumentException("Wrong paging state: ${model.dataState}")
  }
}