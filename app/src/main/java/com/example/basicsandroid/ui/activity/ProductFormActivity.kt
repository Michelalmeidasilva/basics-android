package com.example.basicsandroid.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.basicsandroid.R
import com.example.basicsandroid.dao.ProductsDao
import com.example.basicsandroid.model.Product
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity(R.layout.activity_product_form) {
    private val productsDao = ProductsDao()

    private fun createProduct(): Product {
        val nameEditText = findViewById<EditText>(R.id.name);
        val description = findViewById<EditText>(R.id.description);
        val price = findViewById<EditText>(R.id.price)
        val nameValue = nameEditText.text.toString();
        val descriptionValue = description.text.toString();
        val priceValue = if (price.text.toString().isBlank()
        ) BigDecimal(price.text.toString()) else BigDecimal.ZERO

        return Product(nameValue, priceValue, descriptionValue)
    }

    private fun bindComponents() {
        val buttonSaveForm = findViewById<Button>(R.id.save_button)

        buttonSaveForm.setOnClickListener {
            val newProduct = createProduct()
            productsDao.createProduct(newProduct)
            finish();
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindComponents();

    }

}