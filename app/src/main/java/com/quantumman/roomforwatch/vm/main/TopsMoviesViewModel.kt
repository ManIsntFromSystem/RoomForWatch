package com.quantumman.roomforwatch.vm.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.quantumman.data.remote.helpers.NetworkComponents
import com.quantumman.data.remote.model.base.Api
import com.quantumman.roomforwatch.model.base.ListItem
import com.quantumman.roomforwatch.model.movies.*
import com.quantumman.roomforwatch.util.ResourceProvider
import com.quantumman.roomforwatch.vm.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class TopsMoviesViewModel @Inject constructor(private val resources: ResourceProvider) : BaseViewModel() { //param (private val repository: MovieRepository) // interface LifecycleObserver,

  private val _data = MutableLiveData<List<ListItem>>()
  val data: LiveData<List<ListItem>> = _data
  private val api = NetworkComponents.createApi()

    init {
    viewModelScope.launch(Dispatchers.IO) {
      _data.postValue(getLoaders())
      val items = getItems()
      _data.postValue(items)
    }
  }

  private fun getLoaders(): List<ListItem> {
    println("Get Loaders")
    return listOf(
      TopsMoviesHorizontalItem(
        title = "Now playing",
        movies = IntRange(1, 3).map { ProgressThinItem }
      ), TopsMoviesHorizontalItem(
        title = "The most popular",
        movies = IntRange(1, 3).map { ProgressThinItem }
      ), TopsMoviesHorizontalItem(
        title = "Upcoming",
        movies = IntRange(1, 3).map { ProgressThinItem }
      )
    )
  }

  private suspend fun getItems(): List<ListItem> {
    val result = mutableListOf<ListItem>()
    try {
      val nowPlayingResponse = api.fetchNowPlayingMovies()
      val popularResponse = api.fetchPopularMovies()
      val upcomingResponse = api.fetchUpcomingMovies()
      val topRatedResponse = api.fetchTopRatedMovies()

      val nowPlayingItems = nowPlayingResponse.results.map {
        ItemTopsMovieThin(id = it.id, title = it.title, image = Api.getPosterPath(it.posterVertical))
      }
      val popularItems = popularResponse.results.map {
        ItemTopsMovieThin(id = it.id, title = it.title, image = Api.getPosterPath(it.posterVertical))
      }
      val upcomingItems = upcomingResponse.results.map {
        ItemTopsMovieThin(id = it.id, title = it.title, image = Api.getPosterPath(it.posterVertical))
      }
      val topRatedItems = topRatedResponse.results.map {
        ItemTopsMovieThin(id = it.id, title = it.title, image = Api.getPosterPath(it.posterVertical))
      }

      result += listOf(
        TopsMoviesHorizontalItem(
          title = "Now playing",
          movies = nowPlayingItems
        ),
        TopsMoviesHorizontalItem(
          title = "The most popular",
          movies = popularItems
        ),
        TopsMoviesHorizontalItem(
          title = "Upcoming",
          movies = upcomingItems
        ),
        TopsMoviesHorizontalItem(
          title = "Top rated",
          movies = topRatedItems
        )
      )
    } catch (e: Exception) {
      e.printStackTrace()
    }
    return result
  }
}

//  private val state: MutableLiveData<MovieState> =
//    MutableLiveData<MovieState>().default(initialValue = MovieState.LoadingState)
//
//  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
//  fun receiveMovies() {
//    state.set(newValue = MovieState.LoadingState)
//    CoroutineScope(Dispatchers.IO).launch {
//      val movies = repository.fetchLocalMoviesAsync().await()
//      if (movies.isEmpty()) {
//        launch(Dispatchers.Main) {
//          state.set(newValue = MovieState.NoItemsState)
//        }
//      } else {
//        launch(Dispatchers.Main) {
//          state.set(newValue = MovieState.LoadedState(data = movies))
//        }
//      }
//    }
//  }