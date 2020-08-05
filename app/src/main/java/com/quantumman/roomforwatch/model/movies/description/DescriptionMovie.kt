package com.quantumman.roomforwatch.model.movies.description

import com.quantumman.roomforwatch.model.base.DescriptionItem

class DescriptionMovie(
  val id: Int,
  val title: String,
  val overview: String,
  val image: String?
) : DescriptionItem {
  override val itemId = id
}