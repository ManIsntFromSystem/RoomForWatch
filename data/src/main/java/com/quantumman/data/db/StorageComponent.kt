package com.quantumman.data.db

import android.content.Context
import com.quantumman.data.db.dao.MovieDao
import dagger.*
import javax.inject.Singleton

@Component(modules = [RoomModule::class])
@Singleton
interface StorageComponent {

  fun movieDao(): MovieDao

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun appContext(context: Context): Builder

    fun build(): StorageComponent
  }
}

@Module
class RoomModule {
  companion object {
    @Provides
    @Singleton
    fun provideRoomDataSource(context: Context) = RoomAppDatabase.builderDataSource(context)

    @Provides
    @Singleton
    fun provideMovieDao(dataSource: RoomAppDatabase): MovieDao = dataSource.movieDao()
  }
}
