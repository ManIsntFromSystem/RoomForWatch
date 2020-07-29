package com.quantumman.data.remote.model.movies

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable
import kotlinx.serialization.*
import kotlinx.serialization.json.Json

@Serializable
data class MovieDTO(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("genre_ids") val genres: List<Int>,
    @SerializedName("popularity") val popularity: String,
    @SerializedName("vote_average") val voteAverage: Float,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("poster_path") val posterVertical: String?,
    @SerializedName("backdrop_path") val posterHorizontal: String?
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