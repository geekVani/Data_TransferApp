package com.example.datatransferapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class BmiFragment : Fragment() {

    lateinit var result: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_bmi, container, false)
        result = view.findViewById(R.id.textViewResult)

        // use same arguments keyword and store value in variable
        val weight = arguments?.getInt("weight")!!.toInt()
        val height = arguments?.getInt("height")!!.toInt()

        // calculete using formula
        val bmi: Double = ((weight*10000) / (height*height)).toDouble()

        // assigning to result textview
        result.text = "Your BMI value is: $bmi"


        // Inflate the layout for this fragment
        return view
    }
}