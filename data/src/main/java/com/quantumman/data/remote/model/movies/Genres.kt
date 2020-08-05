package com.quantumman.data.remote.model.movies

import androidx.room.Embedded
import kotlinx.serialization.Serializable

@Serializable
data class Genres(val id: Int, val name: String = "Unknown")