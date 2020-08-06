package com.quantumman.roomforwatch.vm.main

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation.findNavController
import com.quantumman.roomforwatch.R
import com.quantumman.roomforwatch.interactors.detals.DescMovieScreenInteractor
import com.quantumman.roomforwatch.model.base.DescriptionItem
import com.quantumman.roomforwatch.vm.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieDescriptionViewModel  @Inject constructor(
  private val interactor: DescMovieScreenInteractor): BaseViewModel() {

  private val _data = MutableLiveData<DescriptionItem>()
  val data: LiveData<DescriptionItem> = _data

  init {
    viewModelScope.launch(Dispatchers.IO) {
      interactor.data().collect { _data.postValue(it) }
    }
  }

  fun getMovieById(movieId: Int) {
    viewModelScope.launch (Dispatchers.IO){
      interactor.getMovieById(movieId)
    }
  }

  fun goBackToTopPage(view: View) {
    findNavController(view).popBackStack(R.id.fragment_tops, false)
  }
}