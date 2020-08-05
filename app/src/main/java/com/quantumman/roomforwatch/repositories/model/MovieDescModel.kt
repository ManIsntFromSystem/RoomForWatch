package com.quantumman.roomforwatch.repositories.model

import com.quantumman.data.remote.api.MovieState
import com.quantumman.data.remote.model.movies.MovieDetailedDTO

data class MovieDescModel(val title: String, val dataState: MovieState<MovieDetailedDTO>)