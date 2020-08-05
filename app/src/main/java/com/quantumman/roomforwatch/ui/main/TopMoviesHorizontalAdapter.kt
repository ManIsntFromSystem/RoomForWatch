package com.quantumman.roomforwatch.ui.main

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.quantumman.roomforwatch.util.BaseDiffUtilItemCallBack
import com.quantumman.roomforwatch.model.base.ListItem

class TopMoviesHorizontalAdapter(onMakeTryToLoadMore: (Int) -> Unit) :
  AsyncListDifferDelegationAdapter<ListItem>(
    BaseDiffUtilItemCallBack()
  ) {
  init {
    setHasStableIds(true)
    delegatesManager.addDelegate(TopsPageDelegate.thinTopsMovieDelegate(onMakeTryToLoadMore))
      .addDelegate(TopsPageDelegate.thinProgressDelegate())
  }

  override fun getItemId(position: Int): Long {
    return items[position].itemId.toLong()
  }
}