package com.quantumman.roomforwatch.ui.main

import android.app.Activity
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.quantumman.data.remote.model.movies.CategoryType
import com.quantumman.roomforwatch.R
import com.quantumman.roomforwatch.databinding.*
import com.quantumman.roomforwatch.model.base.ListItem
import com.quantumman.roomforwatch.model.movies.topscreen.ItemTopsMovieThin
import com.quantumman.roomforwatch.model.movies.topscreen.ProgressThinItem
import com.quantumman.roomforwatch.model.movies.topscreen.TopsMoviesHorizontalItem

object TopsPageDelegate {

  fun moviesHorizontalDelegate(onItemBind: (TopsMoviesHorizontalItem) -> Unit,
                               onMakeTryToLoadMore: (CategoryType, Int) -> Unit) =
    adapterDelegateViewBinding<TopsMoviesHorizontalItem, ListItem, ItemForTopPageRecyclerBinding>(
      { layoutInflater, parent ->
        ItemForTopPageRecyclerBinding.inflate(layoutInflater, parent, false)
      }
    ) {
      //OnCreateViewHolder
      val adapter = TopMoviesHorizontalAdapter { onMakeTryToLoadMore.invoke(item.category, adapterPosition) }
      binding.recyclerItemTopPage.adapter = adapter
      //OnBindViewHolder
      bind {
        onItemBind.invoke(item)
        binding.tvTitleCategory.text = item.title
        adapter.items = item.movies
      }
    }

  fun thinTopsMovieDelegate(onMakeTryToLoadMore: (Int) -> Unit) =
    adapterDelegateViewBinding<ItemTopsMovieThin, ListItem, ItemForHorizontalMovieBinding>(
      { layoutInflater, parent ->
        ItemForHorizontalMovieBinding.inflate(layoutInflater, parent, false)
      }
    ) {
      binding.imgViewPosterHor.setOnClickListener {
        val action = TopsMoviesFragmentDirections.navigateToMovieDescFragment(item.id)
        Navigation.findNavController(binding.root).navigate(action)
      }
      bind {
        val resources = binding.root.resources
        Glide.with(binding.root)
          .load(item.image)
          .override(resources.getDimensionPixelOffset(R.dimen.card_thin_movie_width),
                    resources.getDimensionPixelOffset(R.dimen.card_thin_movie_height))
          .transform(CenterCrop(), RoundedCorners(resources.getDimensionPixelOffset(R.dimen.card_movie_radius)))
          .error(R.drawable.ic_poster_tmdb)
          .transition(withCrossFade())
          .into(binding.imgViewPosterHor)
        binding.title = item.title
        binding.executePendingBindings() //for bags
        onMakeTryToLoadMore.invoke(adapterPosition)
      }

      onViewRecycled {
        if ((binding.root.context as? Activity)?.isDestroyed?.not() == null)
          Glide.with(binding.root).clear(binding.imgViewPosterHor)
      }
    }

  fun thinProgressDelegate() =
    adapterDelegateViewBinding<ProgressThinItem, ListItem, ItemMovieProgressBinding>(
      { layoutInflater, parent ->
        ItemMovieProgressBinding.inflate(layoutInflater, parent, false)
      }) {}
}