package com.quantumman.roomforwatch.model.movies.topscreen

import com.quantumman.data.remote.model.movies.CategoryType
import com.quantumman.roomforwatch.model.base.ListItem

data class TopsMoviesHorizontalItem(
  val title: String,
  val category: CategoryType,
  val movies: List<ListItem>
) : ListItem {
  override val itemId: Int = title.hashCode()
}