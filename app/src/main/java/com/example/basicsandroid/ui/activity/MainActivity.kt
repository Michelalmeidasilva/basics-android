package com.example.basicsandroid.ui.activity

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basicsandroid.R
import com.example.basicsandroid.ui.recycleviewer.adapter.FruitsListAdapter

class MainActivity : Activity() {


    fun bindingTextViews() {
        val nameTextView = findViewById<TextView>(R.id.name)
        val mangaTV = findViewById<TextView>(R.id.manga)
        val priceMangaTV = findViewById<TextView>(R.id.price_manga)
        val laranjaTV = findViewById<TextView>(R.id.laranja)
        val priceLaranjaTV = findViewById<TextView>(R.id.price_laranja)

        //binding de views
        nameTextView.text = "Cesta de Frutas"
        laranjaTV.text = "Laranja"
        priceLaranjaTV.text = "22.00"
        mangaTV.text = "Mangass"
        priceMangaTV.text = "21.00"


        val recyclerView = findViewById<RecyclerView>(R.id.listFruits)
        recyclerView.adapter = FruitsListAdapter()

    }


    //ciclos de vida
    // 1. onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        bindingTextViews()

    }

}