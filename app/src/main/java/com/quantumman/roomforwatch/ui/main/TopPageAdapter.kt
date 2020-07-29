package com.quantumman.roomforwatch.ui.main

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.quantumman.data.remote.model.movies.CategoryType
import com.quantumman.roomforwatch.util.BaseDiffUtilItemCallBack
import com.quantumman.roomforwatch.model.base.ListItem
import com.quantumman.roomforwatch.model.movies.TopsMoviesHorizontalItem

class TopPageAdapter(
  onItemBind: (TopsMoviesHorizontalItem) -> Unit,
  onMakeTryToLoadMore: (CategoryType, Int) -> Unit
) : AsyncListDifferDelegationAdapter<ListItem>(BaseDiffUtilItemCallBack()) {
  init {
    delegatesManager.addDelegate(
      TopsPageDelegate.moviesHorizontalDelegate(
        onItemBind = onItemBind,
        onMakeTryToLoadMore = onMakeTryToLoadMore
      )
    )
  }
}