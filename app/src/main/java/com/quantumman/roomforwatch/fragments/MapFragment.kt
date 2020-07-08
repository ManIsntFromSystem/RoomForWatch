package com.quantumman.roomforwatch.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.quantumman.roomforwatch.R
import com.quantumman.roomforwatch.vm.MapViewModel

class MapFragment : Fragment() {

    private val mapVM: MapViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_map, container, false)
        val textView: TextView = root.findViewById(R.id.text_map)
        mapVM.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}