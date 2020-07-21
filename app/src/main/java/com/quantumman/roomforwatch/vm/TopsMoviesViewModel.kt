package com.quantumman.roomforwatch.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.quantumman.data.remote.helpers.NetworkComponents
import com.quantumman.data.remote.model.base.Api
import com.quantumman.roomforwatch.model.base.ListItem
import com.quantumman.roomforwatch.model.movies.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TopsMoviesViewModel() :
  BaseViewModel() { //param (private val repository: MovieRepository) // interface LifecycleObserver,

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
        movies = IntRange(1, 2).map { ProgressWideItem }
      ), TopsMoviesHorizontalItem(
        title = "The most popular",
        movies = IntRange(1, 3).map { ProgressThinItem }
      ), TopsMoviesHorizontalItem(
        title = "Latest",
        movies = IntRange(1, 2).map { ProgressWideItem }
      ), TopsMoviesHorizontalItem(
        title = "Top rated",
        movies = IntRange(1, 2).map { ProgressWideItem }
      )
    )
  }

  private suspend fun getItems(): List<ListItem> {
    val result = mutableListOf<ListItem>()
    try {
      val nowPlayingResponse = api.fetchAllMovies(category = "now_playing")
      val popularResponse = api.fetchAllMovies(category = "popular")
      val latestResponse = api.fetchAllMovies(category = "latest")
      val topRatedResponse = api.fetchAllMovies(category = "top_rated")

      val nowPlayingItems = nowPlayingResponse.results.map {
        ItemTopsMovieWide(
          id = it.id,
          title = it.title,
          image = Api.getPosterPath(it.posterHorizontal)
        )
      }
      val popularItems = popularResponse.results.map {
        println(
          "Id: ${it.id}/n" +
              "Title: ${it.title}/n" +
              "image: ${it.posterHorizontal}/n"
        )
        ItemTopsMovieThin(
          id = it.id,
          title = it.title,
          image = Api.getPosterPath(it.posterHorizontal)
        )
      }
      val latestItems = latestResponse.results.map {
        ItemTopsMovieThin(
          id = it.id,
          title = it.title,
          image = Api.getPosterPath(it.posterHorizontal)
        )
      }
      val topRatedItems = topRatedResponse.results.map {
        ItemTopsMovieThin(
          id = it.id,
          title = it.title,
          image = Api.getPosterPath(it.posterHorizontal)
        )
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
          title = "Latest",
          movies = latestItems
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


/*
    println("Get Items")
    delay(3000L)
    return listOf(
      TopsMoviesHorizontalItem(
        title = "Top Movies",
        movies = (1..13).map {
          ItemTopsMovieWide(
            id = it,
            title = "Top Movie $it"
          )
        }
      ), TopsMoviesHorizontalItem(
        title = "Popular Movies",
        movies = (1..13).map {
          ItemTopsMovieThin(
            id = it,
            title = "Popular Movie $it"
          )
        }
      ), TopsMoviesHorizontalItem(
        title = "Rating Movies",
        movies = (1..13).map {
          ItemTopsMovieWide(
            id = it,
            title = "Rating Movie $it"
          )
        }
      )
    ) */