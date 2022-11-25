package com.example.basicsandroid.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basicsandroid.R
import com.example.basicsandroid.databinding.ActivityLoginBinding
import com.example.basicsandroid.databinding.ActivityProductDetailsBinding

class ProductDetailsActivity : AppCompatActivity(R.layout.activity_product_details) {
    private lateinit var binding: ActivityProductDetailsBinding;

    fun bindingComponents() {
//        binding.productDetailsPrice.text
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        val view = binding.root

        supportActionBar?.hide();
        setContentView(view)
    }
}