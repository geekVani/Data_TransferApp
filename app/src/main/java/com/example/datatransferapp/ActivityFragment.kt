package com.example.datatransferapp

/*
* Fragment to fragment
* ActivityFragment -> DataFragment
* ************************************ */

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class ActivityFragment: Fragment() {

    lateinit var name: EditText
    lateinit var btnSend: Button
    lateinit var btnFragment: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_activity, container, false)

        name = view.findViewById(R.id.editTextEmail)
        btnSend = view.findViewById(R.id.buttonActivity)
        btnFragment = view.findViewById(R.id.buttonFragment)

        // onclick btn listener
        btnSend.setOnClickListener {
            val userName = name.text.toString()

            // object of our activity
            val secondActivity: SecondActivity = activity as SecondActivity
            secondActivity.takeData(userName)

            //OR
//            (activity as SecondActivity).takeData(userName)

        }

        // fragment to fragment
        btnFragment.setOnClickListener {
            val userNameEmail = name.text.toString()

            // using bundle object
            val bundle = Bundle()
            bundle.putString("username", userNameEmail)

            // second(data) fragment object
            val dataFragment = DataFragment()
            dataFragment.arguments = bundle

            // fragment manager cannot directly be accessed hence use requireActivity()
            val fragManager: FragmentManager = requireActivity().supportFragmentManager
            val fragTransaction: FragmentTransaction = fragManager.beginTransaction()
            fragTransaction.replace(R.id.frameLayoutFragment, dataFragment)
            fragTransaction.commit()
        }
        return view
    }
}