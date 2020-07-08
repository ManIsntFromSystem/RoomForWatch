package com.quantumman.roomforwatch.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.quantumman.roomforwatch.R
import com.quantumman.roomforwatch.vm.TopsMoviesViewModel

class TopsMoviesFragment : Fragment() {

    private val topsVM: TopsMoviesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_tops, container, false)
        val textView: TextView = root.findViewById(R.id.text_top)
        topsVM.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}