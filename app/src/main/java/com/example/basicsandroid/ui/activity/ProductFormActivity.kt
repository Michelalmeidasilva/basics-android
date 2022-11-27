package com.example.basicsandroid.ui.activity

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basicsandroid.R
import com.example.basicsandroid.dao.ProductsDao
import com.example.basicsandroid.databinding.ActivityProductFormBinding
import com.example.basicsandroid.model.Product
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity(R.layout.activity_product_form) {
    private lateinit var binding: ActivityProductFormBinding;
    private val productsDao = ProductsDao()

    val REQUEST_IMAGE_GET = 1

    fun selectImage() {
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            type = "image/*"
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_GET)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_GET && resultCode == Activity.RESULT_OK) {
            val thumbnail: Bitmap? = data?.getParcelableExtra("data")
            val fullPhotoUri: Uri? = data?.data

        }
    }


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
        binding.cameraAddedButton.setOnClickListener {

            selectImage()
        }

        binding.photoAddedButton.setOnClickListener {

            selectImage()
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

