package com.quantumman.data.remote.model.base

import com.quantumman.data.remote.model.PopularMovieApi
import com.quantumman.data.remote.model.base.Api.API_KEY
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface AllMovieApi {
  @GET("3/movie/{category}")
  suspend fun fetchAllMovies(@Query("page") page: Int = 1,
                             @Path("category") category: String,
                             @Query("api_key") apiKey: String? = API_KEY,
                             @Query("language") language: String? = "ru"): PagedResponse

  @GET("movie/{movie_id}")
  fun getMovieReviews(@Path("movie_id") id: Int,
                      @Query("api_key") apiKey: String? = API_KEY,
                      @Query("language") language: String? = "ru"): PopularMovieApi

}