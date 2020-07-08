package com.quantumman.roomforwatch.vm

import androidx.lifecycle.*
import com.quantumman.domain.repositories.MovieRepository
import com.quantumman.roomforwatch.extensions.default
import com.quantumman.roomforwatch.extensions.set
import com.quantumman.roomforwatch.helpers.MovieState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TopsMoviesViewModel(private val repository: MovieRepository) : LifecycleObserver {

    private val state: MutableLiveData<MovieState> =
        MutableLiveData<MovieState>().default(initialValue = MovieState.LoadingState)

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun receiveMovies() {
        state.set(newValue = MovieState.LoadingState)
        CoroutineScope(Dispatchers.IO).launch {
            val movies = repository.receiveLocalMoviesAsync().await()
            if (movies.isEmpty()) {
                launch(Dispatchers.Main) {
                    state.set(newValue = MovieState.NoItemsState)
                }
            } else {
                launch(Dispatchers.Main) {
                    state.set(newValue = MovieState.LoadedState(data = movies))
                }
            }
        }
    }
}
//    private val _text = MutableLiveData<String>().apply {
//        value = "This is top Fragment"
//    }
//    val text: LiveData<String> = _text