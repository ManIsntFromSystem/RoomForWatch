package com.quantumman.data.remote.services

import com.quantumman.data.remote.model.MovieApi
import com.quantumman.data.remote.model.PopularMovieApi
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface MovieServices {

    @GET("/movie/popular")
    fun getPopularMoviesAsync(): Deferred<List<PopularMovieApi>>

//    @GET("movie/popular?api_key=86b59aba7ad323dc9326d37105201143&language=ru&page=")
//    fun getPopularMoviesAsync(): Deferred<List<PopularMovieApi>>
}