package com.quantumman.data.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.quantumman.data.db.contracts.RoomContract
import com.quantumman.data.remote.model.Genres

@Entity(tableName = RoomContract.tableMovie)
data class MovieEntity(@PrimaryKey val id: Int,
                       val title: String,
                       val originalTitle: String,
                       val releaseDate: String,
                       val popularity: Float,
                       val poster: String,
                       val genres: String,
                       val budget: Int,
                       val revenue: Int,
                       val overview: String,
                       val voteAverage: Float,
                       val voteCount: Int,
                       val runtime: Int) {

}