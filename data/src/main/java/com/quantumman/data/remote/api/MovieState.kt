package com.quantumman.data.remote.api

sealed class MovieState<out T> {
    object Initial : MovieState<Nothing>()
    data class Content<T>(val data: T) : MovieState<T>()
}