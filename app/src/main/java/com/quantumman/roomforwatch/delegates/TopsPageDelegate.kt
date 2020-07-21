package com.quantumman.roomforwatch.delegates

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
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
        val radius = binding.root.resources.getDimensionPixelOffset(R.dimen.card_movie_radius)
        Glide.with(binding.root)
          .load(item.image)
          .transform(RoundedCorners(radius))
          .into(binding.imgViewPosterHor)
        binding.title = item.title
        binding.executePendingBindings() //for bags
      }
    }

  fun thinTopsMovieDelegate() =
    adapterDelegateViewBinding<ItemTopsMovieThin, ListItem, ItemForHorizontalTopHideBinding>(
      { layoutInflater, parent ->
        ItemForHorizontalTopHideBinding.inflate(layoutInflater, parent, false)
      }
    ) {
      bind {
        println("Bind TopThinBinding")
        val radius = binding.root.resources.getDimensionPixelOffset(R.dimen.card_movie_radius)
        Glide.with(binding.root)
          .load(item.image)
          .transform(RoundedCorners(radius))
          .into(binding.imgViewPosterHor)
        binding.title = item.title
        binding.executePendingBindings() //for bags
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