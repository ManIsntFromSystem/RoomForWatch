package com.quantumman.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class MoviePreview(val id: Int,
                      val title: String,
                      val year: String,
                      val type: String,
                      val poster: String) {
}