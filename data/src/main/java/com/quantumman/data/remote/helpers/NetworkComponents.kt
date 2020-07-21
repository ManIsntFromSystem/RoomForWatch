package com.quantumman.data.remote.helpers

import com.quantumman.data.BuildConfig
import com.quantumman.data.remote.model.base.AllMovieApi
import com.quantumman.data.remote.model.base.Api.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface NetworkComponents {

  companion object {

    private fun getOkHttpInstance(): OkHttpClient {
      val logging = HttpLoggingInterceptor()
      logging.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BASIC
      else HttpLoggingInterceptor.Level.NONE
      return OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
    }

    fun createApi(): AllMovieApi =  Retrofit.Builder()
      .baseUrl(BASE_URL)
      .client(OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
          level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BASIC
          else HttpLoggingInterceptor.Level.NONE
        }).build())
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(AllMovieApi::class.java)
  }
}