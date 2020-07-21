package com.quantumman.roomforwatch.model.movies

import com.quantumman.roomforwatch.model.base.ListItem

data class TopsMoviesHorizontalItem(
  val title: String,
  val movies: List<ListItem>
) : ListItem {
  override val itemId: Int = title.hashCode()
}