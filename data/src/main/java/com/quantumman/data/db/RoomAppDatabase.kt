package com.quantumman.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.quantumman.data.db.contracts.RoomContract
import com.quantumman.data.db.converters.GenresConverter
import com.quantumman.data.db.dao.MovieDao
import com.quantumman.data.db.models.MovieEntity
import dagger.Provides
import javax.inject.Singleton

@Database(entities = [MovieEntity::class], version = 1)
@TypeConverters(GenresConverter::class)
abstract class RoomAppDatabase : RoomDatabase() {

  abstract fun movieDao(): MovieDao

  companion object {
    fun builderDataSource(context: Context): RoomAppDatabase {
      return Room.databaseBuilder(
        context, RoomAppDatabase::class.java,
        RoomContract.databaseApp
      ).build()
    }
  }
}