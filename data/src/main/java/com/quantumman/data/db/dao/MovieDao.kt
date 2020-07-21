package com.quantumman.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.quantumman.data.db.contracts.MovieSqlContract
import com.quantumman.data.db.models.MovieEntity

@Dao
interface MovieDao {
    @Query(MovieSqlContract.fetch)
    fun fetchMovies(): List<MovieEntity>

    @Insert(entity = MovieEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movieEntity: MovieEntity)
}