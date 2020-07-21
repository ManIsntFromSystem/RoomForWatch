package com.quantumman.domain.models


import android.os.Build
import android.os.Parcel
import android.os.Parcelable

data class Movie(
    val id: Int,
    val title: String,
    val releaseDate: String,
    val popularity: Float,
    val poster: String,
    val genres: List<Genres>,
    val budget: Int,
    val revenue: Int,
    val overview: String,
    val voteAverage: Float,
    val voteCount: Int,
    val runtime: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readFloat(),
        parcel.readString()!!,
        arrayListOf<Genres>().apply {
            parcel.readList(mutableListOf<Any?>(), Genres::class.java.classLoader)
        },
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readFloat(),
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        if (dest != null) {
            dest.readInt()
            dest.readString()
            dest.readString()
            dest.readFloat()
            dest.readString()
            arrayListOf<Genres>().apply {
                dest.readList(mutableListOf<Any?>(), Genres::class.java.classLoader)
            }
            dest.readInt()
            dest.readInt()
            dest.readString()
            dest.readFloat()
            dest.readInt()
            dest.readInt()
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}

//    companion object {
//        @JvmField
//        val CREATOR: Parcelable.Creator<Genres> = object : Parcelable.Creator<Genres> {
//            override fun createFromParcel(source: Parcel): Genres =
//                Genres(source.readInt(), source.readString()!!)
//
//            override fun newArray(size: Int): Array<Genres?> = arrayOfNulls(size)
//        }
//    }

//val HASH_MAP_GENRES = hashMapOf<Int, String>(
//    12 to "приключения",
//    14 to "фэнтези",
//    16 to "мультфильм",
//    18 to "драма",
//    27 to "ужасы",
//    28 to "боевик",
//    35 to "комедия",
//    36 to "история",
//    37 to "вестерн",
//    53 to "триллер",
//    80 to "криминал",
//    99 to "документальный",
//    878 to "фантастика",
//    9648 to "детектив",
//    10402 to "музыка",
//    10749 to "мелодрама",
//    10751 to "семейный",
//    10752 to "военный",
//    10770 to "телевизионный фильм"
//)