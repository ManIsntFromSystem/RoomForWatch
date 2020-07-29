package com.quantumman.data.remote.services

import com.quantumman.data.remote.api.Api.API_KEY
import com.quantumman.data.remote.model.movies.MovieDTO
import com.quantumman.data.remote.model.base.BasePagedResponse
import com.quantumman.data.remote.model.movies.Dates
import com.quantumman.data.remote.model.movies.Genres
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface MovieService {
  @GET("3/movie/popular")
  suspend fun fetchPopularMovies(@Query("page") page: Int = 1,
                                 @Query("region") region: String = "RU",
                                 @Query("api_key") apiKey: String = API_KEY,
                                 @Query("language") language: String = "ru-Ru"): BasePagedResponse

  @GET("3/movie/popular")
  suspend fun fetchPopularMovies1(@QueryMap params: Map<String, String>): BasePagedResponse

  @GET("3/movie/now_playing")
  suspend fun fetchNowPlayingMovies(@Query("page") page: Int = 1,
                                    @Query("region") region: String = "RU",
                                    @Query("api_key") apiKey: String? = API_KEY,
                                    @Query("language") language: String? = "ru-Ru"): BasePagedResponse

  @GET("3/movie/upcoming")
  suspend fun fetchUpcomingMovies(@Query("page") page: Int = 1,
                                  @Query("region") region: String = "RU",
                                  @Query("api_key") apiKey: String? = API_KEY,
                                  @Query("language") language: String = "ru-Ru"): BasePagedResponse

  @GET("3/movie/top_rated")
  suspend fun fetchTopRatedMovies(@Query("page") page: Int = 1,
                                  @Query("region") region: String = "RU",
                                  @Query("api_key") apiKey: String? = API_KEY,
                                  @Query("language") language: String? = "ru-Ru"): BasePagedResponse

  @GET("movie/{movie_id}")
  fun fetchMovieReview(@Path("movie_id") id: Int,
                       @Query("api_key") apiKey: String? = API_KEY,
                       @Query("language") language: String? = "ru"): MovieDTO

  @GET("movie/{movie_id}")
  fun fetchGenres(@Query("api_key") apiKey: String? = API_KEY,
                  @Query("language") language: String? = "ru"): Genres


  @GET("/movie/popular")
  fun getOtherPopularMoviesAsync(): Deferred<List<MovieDTO>>

}