package com.quantumman.roomforwatch.ui.main.tops

import android.app.Activity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.quantumman.data.remote.model.movies.CategoryType
import com.quantumman.roomforwatch.R
import com.quantumman.roomforwatch.databinding.ItemForHorizontalMovieBinding
import com.quantumman.roomforwatch.databinding.ItemForTopPageRecyclerBinding
import com.quantumman.roomforwatch.databinding.ItemMovieProgressBinding
import com.quantumman.roomforwatch.model.base.ListItem
import com.quantumman.roomforwatch.model.movies.topscreen.ItemTopsMovieThin
import com.quantumman.roomforwatch.model.movies.topscreen.ProgressThinItem
import com.quantumman.roomforwatch.model.movies.topscreen.TopsMoviesHorizontalItem

object TopPageDelegate {

  fun moviesHorizontalDelegate(onItemBind: (TopsMoviesHorizontalItem) -> Unit,
                               onMovieClickListener: (Int) -> Unit,
                               onMakeTryToLoadMore: (CategoryType, Int) -> Unit) =
    adapterDelegateViewBinding<TopsMoviesHorizontalItem, ListItem, ItemForTopPageRecyclerBinding>(
      { layoutInflater, parent ->
        ItemForTopPageRecyclerBinding.inflate(layoutInflater, parent, false)
      }
    ) {
      //OnCreateViewHolder
      val adapter =
        TopMoviesHorizontalAdapter(
          { movie -> onMovieClickListener.invoke(movie) },
          { pos -> onMakeTryToLoadMore.invoke(item.category, pos) }
        )

      binding.recyclerItemTopPage.adapter = adapter
      //OnBindViewHolder
      bind {
        onItemBind.invoke(item)
        binding.tvTitleCategory.text = item.title
        adapter.items = item.movies
      }
    }

  fun thinTopsMovieDelegate(onMovieClickListener: (Int) -> Unit, onMakeTryToLoadMore: (Int) -> Unit) =
    adapterDelegateViewBinding<ItemTopsMovieThin, ListItem, ItemForHorizontalMovieBinding>(
      { layoutInflater, parent ->
        ItemForHorizontalMovieBinding.inflate(layoutInflater, parent, false)
      }
    ) {
      binding.imgViewPosterHor.setOnClickListener { onMovieClickListener.invoke(item.id) }
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