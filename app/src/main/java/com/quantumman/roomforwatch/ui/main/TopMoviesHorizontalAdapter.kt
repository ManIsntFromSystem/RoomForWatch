package com.quantumman.roomforwatch.ui.main

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.quantumman.roomforwatch.model.base.ListItem
import com.quantumman.roomforwatch.util.BaseDiffUtilItemCallBack

class TopMoviesHorizontalAdapter(onMovieClickListener: (Int) -> Unit, onMakeTryToLoadMore: (Int) -> Unit) :
  AsyncListDifferDelegationAdapter<ListItem>(BaseDiffUtilItemCallBack()) {
  init {
    notifyDataSetChanged()
    setHasStableIds(true)
    delegatesManager.addDelegate(TopsPageDelegate.thinTopsMovieDelegate(onMovieClickListener, onMakeTryToLoadMore))
      .addDelegate(TopsPageDelegate.thinProgressDelegate())
  }

  override fun getItemId(position: Int): Long {
    return items[position].itemId.toLong()
  }
}