package com.quantumman.data.remote.helpers

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.quantumman.data.BuildConfig
import com.quantumman.data.remote.model.base.Api.BASE_URL
import com.quantumman.data.remote.services.MovieServices
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
  companion object {
    private fun getOkHttpInstance(): OkHttpClient {
      val logging = HttpLoggingInterceptor()
      logging.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BASIC
      else HttpLoggingInterceptor.Level.NONE
      return OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
    }

    @UnstableDefault
    private fun getRetrofitInstance() = Retrofit.Builder()
      .baseUrl(BASE_URL)
      .client(getOkHttpInstance())
//      .addConverterFactory(GsonConverterFactory.create())
      .addConverterFactory(Json.asConverterFactory(contentType = "application/json".toMediaType()))
      .addCallAdapterFactory(CoroutineCallAdapterFactory())
      .build()

    @UnstableDefault
    fun getMoviesService(): MovieServices = getRetrofitInstance().create(MovieServices::class.java)
  }
}