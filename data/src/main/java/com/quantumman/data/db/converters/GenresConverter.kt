package com.quantumman.data.db.converters

import androidx.room.TypeConverter
import com.quantumman.data.remote.model.movies.Genres

class GenresConverter {
    @TypeConverter
    fun fromListToString(genresList: List<Int>): String = genresList.joinToString { "," }

    @TypeConverter
    fun fromStringToList(genresStr: String): List<Int> = genresStr.split(",").map { it.toInt() }
}