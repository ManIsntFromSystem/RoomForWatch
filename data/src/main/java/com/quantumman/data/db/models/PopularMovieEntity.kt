package com.quantumman.data.db.models

import android.content.Context
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.quantumman.data.db.contracts.RoomContract
import com.quantumman.data.remote.helpers.SharedPrefsHelper
import com.quantumman.data.remote.model.Genres


@Entity(tableName = RoomContract.tablePopularMovies)
data class PopularMovieEntity(@PrimaryKey val page: Int,
                              val totalResults: Int,
                              val totalPages: Int,
                              val listMovies: List<MovieForPopular>) {

    inner class MovieForPopular(val id: Int,
                               val title: String,
                               val originalTitle: String,
                               val releaseDate: String,
                               val popularity: Float,
                               val poster: String,
                               val genresIds: List<Int>,
                               val overview: String,
                               val voteAverage: Float,
                               val voteCount: Int)

}


//    fun getGenres(context: Context?): String? {
//        val sharedPrefs: List<Genres.Genre> =
//            SharedPrefsHelper.getListOfGenres(context)
//        var genres = ""
//        if (genre_ids.isNotEmpty()) {
//            for (i in sharedPrefs.indices) {
//                for (j in genre_ids.indices) {
//                    if (genre_ids[j] == sharedPrefs[i].getId()) {
//                        genres += sharedPrefs[i].getName().toString() + ", "
//                    }
//                }
//            }
//        } else {
//            return this.genres
//        }
//        return if (genres.length > 2) genres.substring(0, genres.length - 2) else genres
//    }
