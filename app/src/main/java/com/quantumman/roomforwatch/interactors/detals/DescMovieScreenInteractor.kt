package com.quantumman.roomforwatch.interactors.detals

import com.quantumman.roomforwatch.model.base.DescriptionItem
import kotlinx.coroutines.flow.Flow

interface DescMovieScreenInteractor {

  fun data(): Flow<DescriptionItem>

  suspend fun getMovieById(movieId: Int)
}