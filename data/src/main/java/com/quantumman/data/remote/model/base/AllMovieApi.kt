package com.quantumman.data.remote.model.base

import com.quantumman.data.remote.model.PopularMovieApi
import com.quantumman.data.remote.model.base.Api.API_KEY
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface AllMovieApi {
  @GET("3/movie/popular")
  suspend fun fetchPopularMovies(@Query("page") page: Int = 1,
                                 @Query("api_key") apiKey: String = API_KEY,
                                 @Query("region") region: String = "RU",
                                 @Query("language") language: String = "ru-Ru"): PagedResponse

  @GET("3/movie/now_playing/")
  suspend fun fetchNowPlayingMovies(@Query("page") page: Int = 1,
                                    @Query("api_key") apiKey: String? = API_KEY,
                                    @Query("language") language: String? = "ru"): PagedResponse

  @GET("3/movie/upcoming")
  suspend fun fetchUpcomingMovies(@Query("page") page: Int = 1,
                                  @Query("api_key") apiKey: String? = API_KEY,
                                  @Query("region") region: String = "RU",
                                  @Query("language") language: String = "ru-Ru"): PagedResponse

  @GET("3/movie/top_rated")
  suspend fun fetchTopRatedMovies(@Query("page") page: Int = 1,
                                  @Query("api_key") apiKey: String? = API_KEY,
                                  @Query("language") language: String? = "ru"): PagedResponse

  @GET("movie/{movie_id}")
  fun getMovieReviews(@Path("movie_id") id: Int,
                      @Query("api_key") apiKey: String? = API_KEY,
                      @Query("language") language: String? = "ru"): PopularMovieApi

}