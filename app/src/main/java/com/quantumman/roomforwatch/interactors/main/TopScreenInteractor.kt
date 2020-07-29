package com.quantumman.roomforwatch.interactors.main

import com.quantumman.data.remote.model.movies.CategoryType
import com.quantumman.roomforwatch.model.base.ListItem
import kotlinx.coroutines.flow.Flow

interface TopScreenInteractor {

  fun data(): Flow<List<ListItem>>

  suspend fun initCategory(category: CategoryType)

  suspend fun tryToLoadMore(category: CategoryType, index: Int)
}