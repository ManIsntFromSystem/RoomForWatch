package com.quantumman.roomforwatch.vm.favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavouritesMoviesViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is favourites Fragment"
    }
    val text: LiveData<String> = _text
}