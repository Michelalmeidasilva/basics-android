package com.example.basicsandroid.dao

import com.example.basicsandroid.model.Product

class ProductsDao() {
    private val products = mutableListOf<Product>()

    fun createProduct(product: Product) {
        products.add(product);
    }

    fun searchProuct(): List<Product> {
        return products.toList();
    }

}