package com.quantumman.roomforwatch.ui.main.tops

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.quantumman.roomforwatch.R
import com.quantumman.roomforwatch.databinding.FragmentTopsBinding
import com.quantumman.roomforwatch.di.TopsScreenComponent
import com.quantumman.roomforwatch.util.viewBinding
import com.quantumman.roomforwatch.vm.main.TopsMoviesViewModel

class TopMoviesFragment : Fragment(R.layout.fragment_tops) {

  private val component by lazy { TopsScreenComponent.create() }
  private val binding by viewBinding { FragmentTopsBinding.bind(it) }

  private val viewModel by viewModels<TopsMoviesViewModel> { component.viewModelFactory() }

  private val adapter by lazy {
    TopPageAdapter(
      onItemBind = viewModel::initCategory,
      onMovieClickListener = this::intoMovieDescription,
      onMakeTryToLoadMore = viewModel::makeTryToLoadMore
    )
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.recyclerTopPage.adapter = adapter
    adapter.items.forEach { Log.d("MyTag", "Adapter items2 $it") }
    viewModel.data.observe(viewLifecycleOwner, Observer {
      adapter.items = it
    })
  }

  private fun intoMovieDescription(movie: Int) = viewModel.intoMovieDescription(requireView(), movie)
}