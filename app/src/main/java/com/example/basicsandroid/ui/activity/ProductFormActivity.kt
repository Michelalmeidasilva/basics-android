package com.example.basicsandroid.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.basicsandroid.R
import com.example.basicsandroid.dao.ProductsDao
import com.example.basicsandroid.model.Product
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity(R.layout.activity_product_form) {


    fun bindComponents() {

        val buttonSaveForm = findViewById<Button>(R.id.save_button)


        buttonSaveForm.setOnClickListener {
            val nameEditText = findViewById<EditText>(R.id.name);
            val description = findViewById<EditText>(R.id.description);
            val price = findViewById<EditText>(R.id.price)
            val nameValue = nameEditText.text.toString();
            val descriptionValue = description.text.toString();
            val priceValue = if (price.text.toString().isBlank()
            ) BigDecimal(price.text.toString()) else BigDecimal.ZERO

            val newProduct = Product(nameValue, priceValue, descriptionValue)

            val productsDao = ProductsDao()

            productsDao.createProduct(newProduct)

            finish();
            Log.i("ProductForm/i", "OnClickButton ${newProduct.toString()}")
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindComponents();

    }

}