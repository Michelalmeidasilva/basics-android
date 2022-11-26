package com.example.basicsandroid.ui.activity

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.basicsandroid.R
import com.example.basicsandroid.databinding.ActivityProductDetailsBinding
import com.example.basicsandroid.model.Product

class ProductDetailsActivity : AppCompatActivity(R.layout.activity_product_details) {
    private lateinit var binding: ActivityProductDetailsBinding;

    fun bindingComponents(product: Product) {
        binding.productDetailsDescription.text = (product.description)
        binding.productDetailsTitle.text = (product.name)
        binding.productDetailsPrice.text = (product.price.toString())

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        val view = binding.root

        var myProg = intent.getSerializableExtra("DetailsProduct") as Product


        bindingComponents(myProg)
        supportActionBar?.hide();
        setContentView(view)
    }
}