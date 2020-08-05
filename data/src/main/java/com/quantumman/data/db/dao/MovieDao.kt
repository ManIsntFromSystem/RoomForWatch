package com.quantumman.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.quantumman.data.db.contracts.MovieSqlContract
import com.quantumman.data.db.models.MovieEntity

@Dao
interface MovieDao {
//    @Query(MovieSqlContract.fetchAll)
//    fun fetchMovies(): List<MovieEntity>
//
//    @Query(MovieSqlContract.fetchById)
//    fun fetchMovieById(id: Int): List<MovieEntity>
//
//    @Insert(entity = MovieEntity::class, onConflict = OnConflictStrategy.REPLACE)
//    fun insertMovie(movieEntity: MovieEntity)
//
//    @Insert(entity = MovieEntity::class, onConflict = OnConflictStrategy.REPLACE)
//    fun insertAllMovies(movieEntity: List<MovieEntity>)
}