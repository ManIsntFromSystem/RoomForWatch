package com.quantumman.roomforwatch.adapters

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.quantumman.roomforwatch.delegates.TopsPageDelegate
import com.quantumman.roomforwatch.util.BaseDiffUtilItemCallBack
import com.quantumman.roomforwatch.model.base.ListItem

class TopMoviesHorizontalAdapter : AsyncListDifferDelegationAdapter<ListItem>(BaseDiffUtilItemCallBack()) {

  init {
    delegatesManager.addDelegate(TopsPageDelegate.wideTopsMovieDelegate())
      .addDelegate(TopsPageDelegate.thinTopsMovieDelegate())
      .addDelegate(TopsPageDelegate.wideProgressDelegate())
      .addDelegate(TopsPageDelegate.thinProgressDelegate())
  }
}