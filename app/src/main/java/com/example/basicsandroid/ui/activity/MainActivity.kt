package com.example.basicsandroid.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basicsandroid.R
import com.example.basicsandroid.dao.ProductsDao
import com.example.basicsandroid.model.Product
import com.example.basicsandroid.ui.recycleviewer.adapter.ProductListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class MainActivity : AppCompatActivity(R.layout.activity_main) {


    //ciclos de vida
    // 1. onCreate
    // 2. onResume

    override fun onResume() {
        super.onResume()

        val buttonAdd = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        val recyclerView = findViewById<RecyclerView>(R.id.listFruits)
        val productsDao = ProductsDao();

        recyclerView.adapter = ProductListAdapter(
            this,
            productsDao.searchProuct()
        )
        recyclerView.layoutManager = LinearLayoutManager(this);


        buttonAdd.setOnClickListener {
            val intent = Intent(this, ProductFormActivity::class.java)
            startActivity(intent);
        }

    }


}