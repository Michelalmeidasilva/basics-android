package com.example.basicsandroid.ui.recycleviewer.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basicsandroid.R
import com.example.basicsandroid.databinding.ActivityProductItemBinding
import com.example.basicsandroid.model.Product

class ProductListAdapter(private val context: Context, products: List<Product>) :
    RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {
    private lateinit var binding: ActivityProductItemBinding;

    private val mutableProducts = products.toMutableList();

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(product: Product) {
            val nameTextView = itemView.findViewById<TextView>(R.id.product_item_name_value)
            val descriptionProduct =
                itemView.findViewById<TextView>(R.id.product_item_description_value)
            val priceProduct = itemView.findViewById<TextView>(R.id.product_item_price_value)

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
        val product = this.mutableProducts[position];
        Log.i("tag onbindiewholder", "entrou aqui ${product}")

        holder.bind(product);
    }

    override fun getItemCount(): Int = mutableProducts.size

    @SuppressLint("NotifyDataSetChanged")
    fun onUpdate(products: List<Product>) {
        Log.i("mutableProducts", "$mutableProducts")
        Log.i("products", "$products")

        this.mutableProducts.clear();
        this.mutableProducts.addAll(products);
        this.notifyDataSetChanged()
    }

}
