package com.example.datatransferapp

/*
* Activity to activity
* mainAct --> secondAct
* Activity to Fragment
* mainAct -> bmi fragment
* ************************* */

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    lateinit var etWeight: EditText
    lateinit var etHeight: EditText
    lateinit var btnCalculate: Button
    lateinit var btnSkip: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etWeight = findViewById(R.id.editTextWeight)
        etHeight = findViewById(R.id.editTextHeight)
        btnCalculate = findViewById(R.id.buttonCalculate)
        btnSkip = findViewById(R.id.buttonFragment)

        // for fragment
        val bmiManager: FragmentManager = supportFragmentManager
        val bmiTransaction: FragmentTransaction = bmiManager.beginTransaction()
        val bmiFragment = BmiFragment()

        // activity to fragment
        btnCalculate.setOnClickListener {

            val weight = etWeight.text.toString().toInt()
            val height = etHeight.text.toString().toInt()

            val bundle = Bundle()
            bundle.putInt("weight", weight)
            bundle.putInt("height", height)

            bmiFragment.arguments = bundle

            bmiTransaction.add(R.id.frame, bmiFragment)
            bmiTransaction.commit()
        }

        // activity to activity
        btnSkip.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }
}