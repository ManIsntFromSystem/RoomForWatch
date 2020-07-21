package com.quantumman.data.remote.implementations

import com.quantumman.data.remote.helpers.RetrofitFactory
import com.quantumman.data.remote.model.PopularMovieApi
import com.quantumman.data.remote.providers.MovieProvider
import kotlinx.coroutines.Deferred
import kotlinx.serialization.UnstableDefault

@UnstableDefault
class MoviesProviderImpl: MovieProvider {

    private val TAG = MoviesProviderImpl::class.java.simpleName

    override suspend fun fetchMoviesPopularAsync(): Deferred<List<PopularMovieApi>> {
        return RetrofitFactory.getMoviesService().getPopularMoviesAsync()
    }
}
