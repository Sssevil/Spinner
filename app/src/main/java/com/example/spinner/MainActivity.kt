package com.example.spinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var tvText: TextView?=null
    private var spTowns:Spinner?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        setupListeners()
        setupSpinner()
    }

    private fun initViews(){
        spTowns=findViewById(R.id.spTowns)
        tvText=findViewById(R.id.tvText)

    }
    private fun setupListeners(){
        spTowns?.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position).toString()
               tvText?.text="Добро пожаловать в $selectedItem"
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

    }
    private fun setupSpinner(){
        val adapter =ArrayAdapter.createFromResource(this, R.array.towns, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spTowns?.adapter=adapter


    }
}