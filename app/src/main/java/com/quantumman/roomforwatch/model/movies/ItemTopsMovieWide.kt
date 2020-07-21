package com.quantumman.roomforwatch.model.movies

import com.quantumman.roomforwatch.model.base.ListItem

data class ItemTopsMovieWide (
  val id: Int,
  val title: String,
  val image: String
): ListItem {
  override val itemId = id
}