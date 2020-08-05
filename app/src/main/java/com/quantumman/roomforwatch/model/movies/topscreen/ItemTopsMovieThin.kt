package com.quantumman.roomforwatch.model.movies.topscreen

import com.quantumman.roomforwatch.model.base.ListItem

data class ItemTopsMovieThin(
  val id: Int,
  val title: String,
  val image: String?
) : ListItem {
  override val itemId = id
}