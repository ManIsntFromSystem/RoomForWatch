package com.quantumman.data.remote.providers

import com.quantumman.data.remote.model.PopularMovieApi
import kotlinx.coroutines.Deferred

interface MovieProvider {
    suspend fun fetchMoviesPopularAsync(): Deferred<List<PopularMovieApi>>
}