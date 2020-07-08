package com.quantumman.domain.models

data class Movie(private val id: Int,
                 private val title: String,
                 private val year: String,
                 private val runtime: String,
                 private val genre: List<String>,
                 private val writer: String,
                 private val actors: List<String>,
                 private val plot: String,
                 private val poster: String,
                 private val imdbID: Int,
                 private val imdbRating: String,
                 private val type: String) {}