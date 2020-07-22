package com.quantumman.roomforwatch.di

import android.content.Context
import com.quantumman.roomforwatch.util.AndroidResourceProvider
import com.quantumman.roomforwatch.util.ResourceProvider
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun appContext(context: Context): Builder

    fun build(): AppComponent
  }
}

@Module
abstract class AppModule{
  @Binds
  @Singleton
  abstract fun bindsResourceProvider(provider: AndroidResourceProvider): ResourceProvider
}