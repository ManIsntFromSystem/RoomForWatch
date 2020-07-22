package com.quantumman.roomforwatch.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.quantumman.roomforwatch.R
import com.quantumman.roomforwatch.adapters.TopPageAdapter
import com.quantumman.roomforwatch.databinding.FragmentTopsBinding
import com.quantumman.roomforwatch.util.viewBinding
import com.quantumman.roomforwatch.vm.main.TopsMoviesViewModel

class TopsMoviesFragment : Fragment(R.layout.fragment_tops) {

  private val binding by viewBinding { FragmentTopsBinding.bind(it) }
  private val viewModel by viewModels<TopsMoviesViewModel>()
  private val adapter = TopPageAdapter()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    with(binding) {
      recyclerTopPage.adapter = adapter
      println("TopsMoviesFragment Binding")
      viewModel.data.observe(viewLifecycleOwner, Observer {
        println("TopsMoviesFragment Observe")
        adapter.items = it
      })
    }
  }
}