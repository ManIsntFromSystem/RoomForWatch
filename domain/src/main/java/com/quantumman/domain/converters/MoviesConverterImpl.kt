package com.quantumman.domain.converters

import com.quantumman.data.db.models.MovieEntity
import com.quantumman.data.remote.model.PopularMovieApi
import com.quantumman.domain.models.Movie

interface MoviesConverterImpl {
    fun convertFromApiToDomain(popularMovie: PopularMovieApi, movie:Movie): Movie
    fun convertFromApiToDB(popularMovie: PopularMovieApi, movieEntity:MovieEntity): MovieEntity
    fun convertFromApiToDomain(movieEntity: MovieEntity): Movie
}