package com.example.basicsandroid.dao

import com.example.basicsandroid.model.Product

class ProductsDao() {

    fun createProduct(product: Product) {
        products.add(product);
    }

    fun searchProuct(): List<Product> {
        return products.toList();
    }

    companion object {
        private val products = mutableListOf<Product>()
    }
}