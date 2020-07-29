package com.quantumman.data.remote.providers

import com.quantumman.data.remote.model.movies.MovieDTO
import kotlinx.coroutines.Deferred

interface MovieProvider {
    suspend fun fetchMoviesPopularAsync(): Deferred<List<MovieDTO>>
}