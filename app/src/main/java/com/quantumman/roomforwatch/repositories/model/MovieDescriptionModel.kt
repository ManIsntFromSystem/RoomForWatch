package com.quantumman.roomforwatch.repositories.model

import com.quantumman.data.remote.api.MovieState
import com.quantumman.data.remote.model.movies.MovieDetailedDTO

data class MovieDescriptionModel(val title: String, val dataState: MovieState<MovieDetailedDTO>)