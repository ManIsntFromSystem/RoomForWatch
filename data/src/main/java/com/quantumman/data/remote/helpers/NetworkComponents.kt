package com.quantumman.data.remote.helpers

import com.quantumman.data.BuildConfig
import com.quantumman.data.remote.api.Api.BASE_URL
import com.quantumman.data.remote.services.MovieService
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface NetworkComponent {

  fun api(): MovieService
}

@Module
abstract class NetworkModule {

  companion object {
    @Provides
    @Singleton
    fun provideApi(okHttpClient: OkHttpClient): MovieService = Retrofit.Builder()
      .baseUrl(BASE_URL)
      .client(okHttpClient)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(MovieService::class.java)

    @Provides
    @Singleton
    fun getOkHttpInstance(): OkHttpClient {
      val logging = HttpLoggingInterceptor()
      logging.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
      return OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
    }
  }
}
