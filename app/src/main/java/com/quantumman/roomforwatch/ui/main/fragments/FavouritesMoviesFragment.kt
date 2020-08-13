package com.quantumman.roomforwatch.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.quantumman.roomforwatch.R
import com.quantumman.roomforwatch.vm.favourites.FavouritesMoviesViewModel

class FavouritesMoviesFragment : Fragment() {
    private val favouritesVM: FavouritesMoviesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_favourites, container, false)
        val textView: TextView = root.findViewById(R.id.text_favourites)
        favouritesVM.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}