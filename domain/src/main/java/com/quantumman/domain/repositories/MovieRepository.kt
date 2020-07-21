package com.quantumman.domain.repositories

import com.quantumman.domain.models.Movie
import kotlinx.coroutines.Deferred

interface MovieRepository {
    suspend fun fetchMoviesAsync(): Deferred<List<Movie>>
    suspend fun fetchLocalMoviesAsync(): Deferred<List<Movie>>
}