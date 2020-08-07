package com.quantumman.roomforwatch.ui.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.quantumman.roomforwatch.R

object UIUtil {
  @JvmStatic
  @BindingAdapter(value = ["imageUrl"], requireAll = false)
  fun loadPosterUrl(view: ImageView, imageUrl: String?) {
    Glide.with(view.context)
      .load(imageUrl)
      .error(R.drawable.ic_poster_tmdb)
      .centerCrop()
      .into(view)
  }
}

//import com.bumptech.glide.request.RequestOptions - rounds whole image to Circle