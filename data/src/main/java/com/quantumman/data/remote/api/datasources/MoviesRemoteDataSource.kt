package com.quantumman.data.remote.api.datasources

import com.quantumman.data.remote.api.PagingState
import com.quantumman.data.remote.model.movies.CategoryType
import com.quantumman.data.remote.model.movies.MovieDTO
import com.quantumman.data.remote.services.MovieService
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject

class MoviesRemoteDataSource @Inject constructor(private val api: MovieService) {

  private val chanel = ConflatedBroadcastChannel<PagingState<List<MovieDTO>>>(
    PagingState.Initial)

  private var page = 1
  private var totalPage = 0

  @Synchronized
  suspend fun initialLoading(movieType: CategoryType) {
    if (chanel.value is PagingState.Initial) {
      val response = initResponse(movieType)
      totalPage = response.totalPages
      chanel.send(PagingState.Content(response.results))
    }
  }

  @Synchronized
  suspend fun loadMore(movieType: CategoryType, maybeLastPosition: Int ) {
    if (totalPage <= page) return
    val cache = chanel.value
    if (cache is PagingState.Content && (cache.data.size - 1) == maybeLastPosition) {
      chanel.send(PagingState.Paging(cache.data))
      val response = initResponse(movieType, page)
      chanel.send(PagingState.Content(cache.data.plus(response.results)))
      page += 1
    }
  }

  private suspend fun initResponse(movieType: CategoryType, page: Int = 0) = when (movieType) {
    is CategoryType.NowPlaying -> api.fetchNowPlayingMovies(page = page + 1)
    is CategoryType.Popular -> api.fetchPopularMovies(page = page + 1)
    is CategoryType.Upcoming -> api.fetchUpcomingMovies(page = page + 1)
    is CategoryType.TopRated -> api.fetchTopRatedMovies(page = page + 1)
    is CategoryType.Genre -> TODO()
  }

  fun observe(): Flow<PagingState<List<MovieDTO>>> = chanel.asFlow()
}