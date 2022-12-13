package com.example.basicsandroid.ui.activity

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.basicsandroid.R
import com.example.basicsandroid.dao.ProductsDao
import com.example.basicsandroid.databinding.ActivityProductFormBinding
import com.example.basicsandroid.model.Product
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity(R.layout.activity_product_form) {
    private lateinit var binding: ActivityProductFormBinding;
    private val productsDao = ProductsDao()

    private fun createProduct(): Product {
        val nameValue = binding.productFormName.text.toString()
        val descriptionValue = binding.productFormDescription.text.toString();
        val priceValue = if (binding.productFormPrice.text.toString().isBlank()
        ) BigDecimal.ZERO else BigDecimal(binding.productFormPrice.text.toString())

        return Product(nameValue, priceValue, descriptionValue)
    }

    private fun bindButton() {
        binding.productFormSaveButton.setOnClickListener {
            val newProduct = createProduct()
            productsDao.createProduct(newProduct)
            finish();
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductFormBinding.inflate(layoutInflater)
        val view = binding.root;
        
        bindButton();
        setContentView(view)
    }

}