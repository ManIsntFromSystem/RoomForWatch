package com.quantumman.data.remote.api.params

import com.quantumman.data.remote.api.Api

data class MoviesApiParams(
  val id: Int? = null,
  val apiKey: String? = Api.API_KEY,
  val region: String? = "ru-Ru",
  val language: String? = "ru",
  val dates: String? = null
) {

  fun toMap(): Map<String, String> = mutableMapOf<String, String>().apply {
    id?.let { put("id", it.toString()) }
    language?.let { put("language", it) }
    apiKey?.let { put("api_key", it) }
    region?.let { put("region", it) }
    dates?.let { put("dates", it) }
  }
}