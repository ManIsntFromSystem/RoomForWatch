package com.quantumman.data.remote.model.movies

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable
import kotlinx.serialization.*
import kotlinx.serialization.json.Json

@Serializable
data class MovieDTO(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("overview") val overview: String?,
    @SerializedName("popularity") val popularity: Double,
//    @SerializedName("genre_ids") val genres: List<Genres>,
    @SerializedName("budget") val budget: Int,
    @SerializedName("revenue") val revenue: Int,
    @SerializedName("runtime") val runtime: Int?,
    @SerializedName("vote_count") val voteCount: Int,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("poster_path") val posterVertical: String?,
    @SerializedName("backdrop_path") val posterBackHorizontal: String?
) {
    companion object {
        @UnstableDefault
        fun toObject(strValue: String): MovieDTO {
            return Json.parse(serializer(), strValue)
        }
    }
}

@UnstableDefault
fun MovieDTO.toJson(): String {
    return Json.stringify(MovieDTO.serializer(), this)
}

data class MovieDetailedDTO(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("overview") val overview: String?,
    @SerializedName("backdrop_path") val posterBackHorizontal: String?
)


