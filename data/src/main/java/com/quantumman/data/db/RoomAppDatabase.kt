package com.quantumman.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.quantumman.data.db.contracts.RoomContract
import com.quantumman.data.db.dao.MovieDao
import com.quantumman.data.db.models.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class RoomAppDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        fun builderDataSource(context: Context): RoomAppDatabase {
            return Room.databaseBuilder(context, RoomAppDatabase::class.java,
                RoomContract.databaseApp).build()
        }
    }
}