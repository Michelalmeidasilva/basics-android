package com.example.basicsandroid.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basicsandroid.R
import com.example.basicsandroid.dao.ProductsDao
import com.example.basicsandroid.ui.recycleviewer.adapter.ProductListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeActivity : AppCompatActivity(R.layout.activity_home) {
    private val productsDao = ProductsDao();
    private val adapter = ProductListAdapter(
        context = this,
        products = productsDao.searchProuct()
    )

    private fun bindRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.listFruits)
        recyclerView.layoutManager = LinearLayoutManager(this);
        recyclerView.adapter = adapter
    }

    private fun bindButton() {
        val buttonAdd = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        buttonAdd.setOnClickListener {
            navigateToProdutFormActivity()
        }
    }


    fun navigateToProdutFormActivity() {
        val intent = Intent(this, ProductFormActivity::class.java)
        startActivity(intent);
    }


    //ciclos de vida
    // 1. onCreate
    // 2. onResume

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindRecyclerView();
        bindButton()
    }

    override fun onResume() {
        super.onResume()
        adapter.onUpdate(productsDao.searchProuct());

    }


}