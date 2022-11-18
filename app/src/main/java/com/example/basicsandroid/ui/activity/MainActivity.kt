package com.example.basicsandroid.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basicsandroid.R
import com.example.basicsandroid.model.Product
import com.example.basicsandroid.ui.recycleviewer.adapter.ProductListAdapter
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {


    //ciclos de vida
    // 1. onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.listFruits)
        recyclerView.adapter = ProductListAdapter(
            this,
            listOf(
                Product(
                    name = "teste 2",
                    description = "este e um produto",
                    price = BigDecimal("21.0")
                ),
                Product(
                    name = "teste",
                    description = "este e um produto 2",
                    price = BigDecimal("20.0")
                )
            )
        )
        recyclerView.layoutManager = LinearLayoutManager(this);

    }

}