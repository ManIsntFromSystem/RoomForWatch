package com.quantumman.data.remote.services

import com.quantumman.data.remote.api.Api.API_KEY
import com.quantumman.data.remote.model.base.BasePagedResponse
import com.quantumman.data.remote.model.movies.Genres
import com.quantumman.data.remote.model.movies.MovieDetailedDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
  @GET("3/movie/popular")
  suspend fun fetchPopularMovies(@Query("page") page: Int = 1,
                                 @Query("region") region: String = "RU",
                                 @Query("api_key") apiKey: String = API_KEY,
                                 @Query("language") language: String = "ru-Ru"): BasePagedResponse

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

  @GET("3/movie/{movie_id}")
  suspend fun fetchMovieDescription(@Path("movie_id") id: Int,
                            @Query("api_key") apiKey: String? = API_KEY,
                            @Query("language") language: String? = "ru"): MovieDetailedDTO

  @GET("3/genre/movie/list")
  suspend fun fetchMovieGenres(@Query("api_key") apiKey: String? = API_KEY,
                       @Query("language") language: String? = "ru"): Genres
}