package com.quantumman.roomforwatch.vm.main

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation.findNavController
import com.quantumman.data.remote.model.movies.CategoryType
import com.quantumman.roomforwatch.interactors.main.TopScreenInteractor
import com.quantumman.roomforwatch.model.base.ListItem
import com.quantumman.roomforwatch.model.movies.topscreen.TopsMoviesHorizontalItem
import com.quantumman.roomforwatch.ui.main.TopsMoviesFragmentDirections
import com.quantumman.roomforwatch.vm.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class TopsMoviesViewModel @Inject constructor(
  private val interactor: TopScreenInteractor
) : BaseViewModel() {

  private val _data = MutableLiveData<List<ListItem>>()
  val data: LiveData<List<ListItem>> = _data

  init {
    viewModelScope.launch(Dispatchers.IO) {
      interactor.data().collect { _data.postValue(it) }
    }
  }

  fun initCategory(item: TopsMoviesHorizontalItem) {
    viewModelScope.launch(Dispatchers.IO) {
      interactor.initCategory(item.category)
    }
  }

  fun makeTryToLoadMore(category: CategoryType, index: Int) {
    viewModelScope.launch (Dispatchers.IO){
      interactor.tryToLoadMore(category, index)
    }
  }

  fun intoMovieDescription(view: View, movieId: Int) {
    val action = TopsMoviesFragmentDirections.actionFromTopToMovieDesc(movieId)
    findNavController(view).navigate(action)
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