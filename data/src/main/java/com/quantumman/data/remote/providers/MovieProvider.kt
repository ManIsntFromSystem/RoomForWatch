package com.quantumman.data.remote.providers

import com.quantumman.data.remote.model.MovieApi
import com.quantumman.data.remote.model.MoviePreview
import kotlinx.coroutines.Deferred

interface MovieProvider {
    suspend fun receiveMoviesAsync(): Deferred<List<MovieApi>>
    suspend fun receiveLocalMoviesAsync(): Deferred<List<MoviePreview>>
}