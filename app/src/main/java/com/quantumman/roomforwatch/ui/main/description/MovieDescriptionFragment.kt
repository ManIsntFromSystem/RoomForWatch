package com.quantumman.roomforwatch.ui.main.description

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.quantumman.roomforwatch.R
import com.quantumman.roomforwatch.databinding.FragmentMovieDescriptionBinding
import com.quantumman.roomforwatch.di.TopsScreenComponent
import com.quantumman.roomforwatch.model.movies.description.DescriptionMovie
import com.quantumman.roomforwatch.util.viewBinding
import com.quantumman.roomforwatch.vm.description.MovieDescriptionViewModel

class MovieDescriptionFragment : Fragment(R.layout.fragment_movie_description) {

  private val component by lazy { TopsScreenComponent.create() }
  private val binding by viewBinding { FragmentMovieDescriptionBinding.bind(it) }
  private val viewModel by viewModels<MovieDescriptionViewModel> { component.viewModelFactory() }
  private val args: MovieDescriptionFragmentArgs by navArgs()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    (viewModel::getMovieById)(args.movieId)

    with(binding) {
      viewModel.data.observe(viewLifecycleOwner, Observer { if (it is DescriptionMovie) movie = it })
    }

    requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
      object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() { findNavController().popBackStack() }
      })

    binding.ivBtnBackToTopPage.setOnClickListener { findNavController().popBackStack() }
  }
}
