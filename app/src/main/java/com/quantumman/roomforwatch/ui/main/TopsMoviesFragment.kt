package com.quantumman.roomforwatch.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.quantumman.roomforwatch.R
import com.quantumman.roomforwatch.databinding.FragmentTopsBinding
import com.quantumman.roomforwatch.di.TopsScreenComponent
import com.quantumman.roomforwatch.util.viewBinding
import com.quantumman.roomforwatch.vm.main.TopsMoviesViewModel

class TopsMoviesFragment : Fragment(R.layout.fragment_tops) {

  private val component by lazy { TopsScreenComponent.create() }
  private val binding by viewBinding { FragmentTopsBinding.bind(it) }
  private val viewModel by viewModels<TopsMoviesViewModel> { component.viewModelFactory() }

  private val adapter by lazy {
    TopPageAdapter(
      onItemBind = viewModel::initCategory,
      onMovieClickListener = this::goToMovieDescription,
      onMakeTryToLoadMore = viewModel::makeTryToLoadMore
    )
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    Log.d("MyTag","OnViewCreateTopPage")
    with(binding) {
      recyclerTopPage.adapter = adapter
      viewModel.data.observe(viewLifecycleOwner, Observer {
        adapter.items = it
      })
    }
  }

  private fun goToMovieDescription(movie: Int) {
    val action = TopsMoviesFragmentDirections.navigateToMovieDescFragment(movie)
    Navigation.findNavController(this.requireView()).navigate(action)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Log.d("MyTag","OnCreateTopPage")
  }

  override fun onDestroyView() {
    super.onDestroyView()
    adapter.items = null
  }
}