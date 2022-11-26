package com.example.basicsandroid.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basicsandroid.R
import com.example.basicsandroid.dao.ProductsDao
import com.example.basicsandroid.databinding.ActivityProductsListBinding
import com.example.basicsandroid.ui.recycleviewer.adapter.ProductListAdapter

class ProductsListActivity : AppCompatActivity(R.layout.activity_products_list) {
    private lateinit var binding: ActivityProductsListBinding;
    private val productsDao = ProductsDao();
    private val adapter = ProductListAdapter(
        context = this,
        products = productsDao.searchProuct()
    )

    private fun bindRecyclerView() {
        binding.listFruits.layoutManager = LinearLayoutManager(this);
        binding.listFruits.adapter = adapter
    }

    private fun bindButton() {
        binding.floatingActionButton.setOnClickListener {
            navigateToProdutFormActivity()
        }
    }

    private fun navigateToProdutFormActivity() {
        val intent = Intent(this, ProductFormActivity::class.java)
        startActivity(intent);
    }

    // Ciclos de vida
    // 1. onCreate
    // 2. onResume
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsListBinding.inflate(layoutInflater)
        val view = binding.root
        bindRecyclerView()
        bindButton()
        setContentView(view)
    }

    override fun onResume() {
        super.onResume()
        adapter.onUpdate(productsDao.searchProuct());
    }
}