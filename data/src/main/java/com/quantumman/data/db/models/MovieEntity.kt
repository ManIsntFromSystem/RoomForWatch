package com.quantumman.data.db.models

import androidx.room.*
import com.quantumman.data.db.contracts.RoomContract
import com.quantumman.data.db.converters.GenresConverter
import com.quantumman.data.remote.model.movies.Genres

@Entity(tableName = RoomContract.tableMovie)
data class MovieEntity(@PrimaryKey val id: Int,
                       val title: String,
                       val posterVertical: String,
                       val posterBackHorizontal: String,
                       val genres: List<Int>,
                       val overview: String,
                       val popularity: Double,
                       val budget: Int,
                       val revenue: Int,
                       val runtime: Int,
                       val voteCount: Int,
                       val voteAverage: Double,
                       val releaseDate: String)