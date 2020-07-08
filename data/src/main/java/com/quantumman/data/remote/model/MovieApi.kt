package com.quantumman.data.remote.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.*
import kotlinx.serialization.json.Json

@Serializable
data class MovieApi(
    val id: Int,
    val title: String,
    val year: String,
    val type: String,
    val poster: String
) {
    companion object {
        @UnstableDefault
        fun toObject(strValue: String): MovieApi {
            return Json.nonstrict.parse(serializer(), strValue)
        }
    }
}

@UnstableDefault
fun MovieApi.toJson(): String {
    return Json.stringify(MovieApi.serializer(), this)
}