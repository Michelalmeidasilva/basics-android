package com.example.basicsandroid.ui.recycleviewer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basicsandroid.R
import com.example.basicsandroid.model.Product

class ProductListAdapter(private val context: Context, val products: List<Product>) :
    RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(product: Product) {
            val nameTextView = itemView.findViewById<TextView>(R.id.name_product)
            val descriptionProduct = itemView.findViewById<TextView>(R.id.description_product)
            val priceProduct = itemView.findViewById<TextView>(R.id.price_product)

            //binding de views
            nameTextView.text = product.name
            descriptionProduct.text = product.description
            priceProduct.text = product.price.toPlainString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.activity_product_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position];
        holder.bind(product);
    }

    override fun getItemCount(): Int = products.size

}
