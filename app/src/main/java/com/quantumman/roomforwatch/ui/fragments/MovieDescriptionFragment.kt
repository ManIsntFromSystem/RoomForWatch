package com.quantumman.roomforwatch.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.quantumman.roomforwatch.R
import com.quantumman.roomforwatch.databinding.FragmentMovieDescriptionBinding
import com.quantumman.roomforwatch.di.TopsScreenComponent
import com.quantumman.roomforwatch.model.movies.description.DescriptionMovie
import com.quantumman.roomforwatch.util.viewBinding
import com.quantumman.roomforwatch.vm.main.MovieDescriptionViewModel

class MovieDescriptionFragment : Fragment(R.layout.fragment_movie_description) {

  private val component by lazy { TopsScreenComponent.create() }
  private val binding by viewBinding { FragmentMovieDescriptionBinding.bind(it) }
  private val viewModel by viewModels<MovieDescriptionViewModel> { component.viewModelFactory() }
  private val args: MovieDescriptionFragmentArgs by navArgs()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    (viewModel::getMovieById)(args.movieId)

    with(binding) {
      viewModel.data.observe(viewLifecycleOwner, Observer {
        if (it is DescriptionMovie) {
          movie = it
        }
      })
    }
  }
}

