package com.quantumman.roomforwatch.ui.main.tops

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.quantumman.data.remote.model.movies.CategoryType
import com.quantumman.roomforwatch.model.base.ListItem
import com.quantumman.roomforwatch.model.movies.topscreen.TopsMoviesHorizontalItem
import com.quantumman.roomforwatch.util.BaseDiffUtilItemCallBack

class TopPageAdapter(
  onItemBind: (TopsMoviesHorizontalItem) -> Unit,
  onMovieClickListener: (Int) -> Unit,
  onMakeTryToLoadMore: (CategoryType, Int) -> Unit
) : AsyncListDifferDelegationAdapter<ListItem>(BaseDiffUtilItemCallBack()) {
  init {
    delegatesManager.addDelegate(
      TopPageDelegate.moviesHorizontalDelegate(
        onItemBind = onItemBind,
        onMovieClickListener = onMovieClickListener,
        onMakeTryToLoadMore = onMakeTryToLoadMore
      )
    )
  }
}