package com.quantumman.data.remote.services

import com.quantumman.data.remote.helpers.ApiContract.API_KEY
import com.quantumman.data.remote.model.base.BasePagedResponse
import com.quantumman.data.remote.model.movies.Genres
import com.quantumman.data.remote.model.movies.MovieDetailedDTO
import com.quantumman.data.remote.services.ApiEndPoint.ENDPOINT_MOVIE_BY_ID
import com.quantumman.data.remote.services.ApiEndPoint.ENDPOINT_MOVIE_GENRES
import com.quantumman.data.remote.services.ApiEndPoint.ENDPOINT_NOW_PLAYING_MOVIES
import com.quantumman.data.remote.services.ApiEndPoint.ENDPOINT_POPULAR_MOVIES
import com.quantumman.data.remote.services.ApiEndPoint.ENDPOINT_TOP_RATED_MOVIES
import com.quantumman.data.remote.services.ApiEndPoint.ENDPOINT_UPCOMING_MOVIES
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
  @GET(ENDPOINT_POPULAR_MOVIES)
  suspend fun fetchPopularMovies(@Query("page") page: Int = 1,
                                 @Query("region") region: String = "RU",
                                 @Query("api_key") apiKey: String = API_KEY,
                                 @Query("language") language: String = "ru-Ru"): BasePagedResponse

  @GET(ENDPOINT_NOW_PLAYING_MOVIES)
  suspend fun fetchNowPlayingMovies(@Query("page") page: Int = 1,
                                    @Query("region") region: String = "RU",
                                    @Query("api_key") apiKey: String? = API_KEY,
                                    @Query("language") language: String? = "ru-Ru"): BasePagedResponse

  @GET(ENDPOINT_UPCOMING_MOVIES)
  suspend fun fetchUpcomingMovies(@Query("page") page: Int = 1,
                                  @Query("region") region: String = "RU",
                                  @Query("api_key") apiKey: String? = API_KEY,
                                  @Query("language") language: String = "ru-Ru"): BasePagedResponse

  @GET(ENDPOINT_TOP_RATED_MOVIES)
  suspend fun fetchTopRatedMovies(@Query("page") page: Int = 1,
                                  @Query("region") region: String = "RU",
                                  @Query("api_key") apiKey: String? = API_KEY,
                                  @Query("language") language: String? = "ru-Ru"): BasePagedResponse

  @GET(ENDPOINT_MOVIE_BY_ID)
  suspend fun fetchMovieById(@Path("movie_id") id: Int,
                             @Query("api_key") apiKey: String? = API_KEY,
                             @Query("language") language: String? = "ru"): MovieDetailedDTO

  @GET(ENDPOINT_MOVIE_GENRES)
  suspend fun fetchMovieGenres(@Query("api_key") apiKey: String? = API_KEY,
                       @Query("language") language: String? = "ru"): Genres
}