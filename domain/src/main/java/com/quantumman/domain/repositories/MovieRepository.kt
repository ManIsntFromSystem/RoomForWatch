package com.quantumman.domain.repositories

import com.quantumman.domain.models.Movie
import kotlinx.coroutines.Deferred

interface MovieRepository {
    suspend fun receiveMoviesAsync(): Deferred<List<Movie>>
    suspend fun receiveLocalMoviesAsync(): Deferred<List<Movie>>
}