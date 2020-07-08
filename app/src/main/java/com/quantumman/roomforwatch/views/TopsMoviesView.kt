package com.quantumman.roomforwatch.views

import com.quantumman.domain.models.Movie
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface TopsMoviesView: MvpView  {
    fun presentMovies(data: List<Movie>)
    fun presentLoading()
}