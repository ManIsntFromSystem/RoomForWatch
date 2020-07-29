package com.quantumman.domain.converters

import com.quantumman.data.db.models.MovieEntity
import com.quantumman.data.remote.model.movies.MovieDTO
import com.quantumman.domain.models.Movie

interface MoviesConverterImpl {
    fun convertFromApiToDomain(movieDTO: MovieDTO, movie:Movie): Movie
    fun convertFromApiToDB(movieDTO: MovieDTO, movieEntity:MovieEntity): MovieEntity
    fun convertFromApiToDomain(movieEntity: MovieEntity): Movie
}