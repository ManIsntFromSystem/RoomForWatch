package com.quantumman.roomforwatch.ui.main

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.quantumman.roomforwatch.util.BaseDiffUtilItemCallBack
import com.quantumman.roomforwatch.model.base.ListItem

class TopMoviesHorizontalAdapter(onMakeTryToLoadMore: (Int) -> Unit) :
  AsyncListDifferDelegationAdapter<ListItem>(
    BaseDiffUtilItemCallBack()
  ) {
  init {
    delegatesManager.addDelegate(TopsPageDelegate.wideTopsMovieDelegate(onMakeTryToLoadMore))
      .addDelegate(TopsPageDelegate.thinTopsMovieDelegate(onMakeTryToLoadMore))
      .addDelegate(TopsPageDelegate.wideProgressDelegate())
      .addDelegate(TopsPageDelegate.thinProgressDelegate())
  }
}