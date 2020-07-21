package com.quantumman.data.remote.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

@Serializable
data class MovieApi(
    private val id: Int,
    private val title: String,
    private val releaseDate: String,
    private val popularity: Float,
    private val poster: String,
    private val genres: List<Genres>,
    private val budget: Int,
    private val revenue: Int,
    private val overview: String,
    private val voteAverage: Float,
    private val voteCount: Int,
    private val runtime: Int
) {
    companion object {
        @UnstableDefault
        fun toObject(strValue: String): MovieApi {
            return Json.parse(serializer(), strValue)
        }
    }
}

@UnstableDefault
fun MovieApi.toJson(): String {
    return Json.stringify(MovieApi.serializer(), this)
}