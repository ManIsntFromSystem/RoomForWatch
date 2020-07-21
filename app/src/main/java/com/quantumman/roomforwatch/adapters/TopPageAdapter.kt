package com.quantumman.roomforwatch.adapters

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.quantumman.roomforwatch.delegates.TopsPageDelegate
import com.quantumman.roomforwatch.helpers.BaseDiffUtilItemCallBack
import com.quantumman.roomforwatch.model.base.ListItem

class TopPageAdapter : AsyncListDifferDelegationAdapter<ListItem>(BaseDiffUtilItemCallBack()) {
  init {
    delegatesManager.addDelegate(TopsPageDelegate.moviesHorizontalDelegate)
  }
}