package com.quantumman.roomforwatch.delegates

import android.app.Activity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.quantumman.roomforwatch.R
import com.quantumman.roomforwatch.adapters.TopMoviesHorizontalAdapter
import com.quantumman.roomforwatch.databinding.*
import com.quantumman.roomforwatch.model.base.ListItem
import com.quantumman.roomforwatch.model.movies.*

object TopsPageDelegate {

  val moviesHorizontalDelegate =
    adapterDelegateViewBinding<TopsMoviesHorizontalItem, ListItem, ItemForTopRecyclerBinding>(
      { layoutInflater, parent ->
        ItemForTopRecyclerBinding.inflate(layoutInflater, parent, false)
      }
    ) {
      //OnCreateViewHolder
      println("OnCreateViewHolder")
      val adapter = TopMoviesHorizontalAdapter()
      binding.recyclerItemTopPage.adapter = adapter
      //OnBindViewHolder
      bind {
        println("Bind moviesHorizontalDelegate")
        binding.tvTitleCategory.text = item.title
        adapter.items = item.movies
      }
      //onViewRecycled | here, we can write some code to free up some resources
      onViewRecycled {
        println("OnViewRecycled")
      }
    }

  fun wideTopsMovieDelegate() =
    adapterDelegateViewBinding<ItemTopsMovieWide, ListItem, ItemForHorizontalTopWideBinding>(
      { layoutInflater, parent ->
        ItemForHorizontalTopWideBinding.inflate(layoutInflater, parent, false)
      }
    ) {

      bind {
        println("Bind TopWideBinding")
        val resources = binding.root.resources
        Glide.with(binding.root)
          .load(item.image)
          .override(resources.getDimensionPixelOffset(R.dimen.card_wide_movie_width),
                    resources.getDimensionPixelOffset(R.dimen.card_wide_movie_height))
          .transform(CenterCrop(), RoundedCorners(resources.getDimensionPixelOffset(R.dimen.card_movie_radius)))
          .transition(withCrossFade())
          .into(binding.imgViewPosterHor)
        binding.title = item.title
        binding.executePendingBindings() //for bags
      }
      onViewRecycled {
        if ((binding.root.context as? Activity)?.isDestroyed?.not() == null)
          Glide.with(binding.root).clear(binding.imgViewPosterHor)
      }
    }

  fun thinTopsMovieDelegate() =
    adapterDelegateViewBinding<ItemTopsMovieThin, ListItem, ItemForHorizontalTopThinBinding>(
      { layoutInflater, parent ->
        ItemForHorizontalTopThinBinding.inflate(layoutInflater, parent, false)
      }
    ) {
      bind {
        println("Bind TopThinBinding")
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
      }

      onViewRecycled {
        if ((binding.root.context as? Activity)?.isDestroyed?.not() == null)
          Glide.with(binding.root).clear(binding.imgViewPosterHor)
      }
    }

  fun wideProgressDelegate() =
    adapterDelegateViewBinding<ProgressWideItem, ListItem, ItemWideProgressBinding>(
      { layoutInflater, parent ->
        ItemWideProgressBinding.inflate(layoutInflater, parent, false)
      }) {}

  fun thinProgressDelegate() =
    adapterDelegateViewBinding<ProgressThinItem, ListItem, ItemThinProgressBinding>(
      { layoutInflater, parent ->
        ItemThinProgressBinding.inflate(layoutInflater, parent, false)
      }) {}
}