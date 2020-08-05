package com.quantumman.roomforwatch.ui.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.quantumman.roomforwatch.R

object UIUtil {
  @JvmStatic
  @BindingAdapter(value = ["imageUrl"], requireAll = false)
  fun loadPosterUrl(view: ImageView, imageUrl: String?) {
    if(!imageUrl.isNullOrEmpty())
    Glide.with(view.context)
      .load(imageUrl)
      .centerCrop()
      .error(R.drawable.ic_poster_tmdb)
      .into(view)
  }
}

//import com.bumptech.glide.request.RequestOptions - rounds whole image to Circle