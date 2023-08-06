package com.example.datatransferapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

//
class DataFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_data, container, false)
        val nameEmail: TextView = view.findViewById(R.id.textViewFragmentEmail)

        nameEmail.text = arguments?.getString("username")
        // Inflate the layout for this fragment
        return view
    }
}