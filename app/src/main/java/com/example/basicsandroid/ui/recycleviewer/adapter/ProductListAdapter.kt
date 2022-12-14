package com.example.basicsandroid.ui.recycleviewer.adapter

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_DIAL
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basicsandroid.R
import com.example.basicsandroid.databinding.ActivityProductItemBinding
import com.example.basicsandroid.model.Product
import com.example.basicsandroid.ui.activity.ProductDetailsActivity
import com.google.android.material.card.MaterialCardView
import java.text.NumberFormat
import java.util.*


class ProductListAdapter(private val context: Context, products: List<Product>) :
    RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {
    private lateinit var binding: ActivityProductItemBinding;

    private val mutableProducts = products.toMutableList();

    class ViewHolder(view: View, private val context: Context) : RecyclerView.ViewHolder(view) {
        fun bind(product: Product) {
            val card = itemView.findViewById<MaterialCardView>(R.id.product_item_card)

            card.setOnClickListener {
                val intent = Intent(context, ProductDetailsActivity::class.java)

                intent.putExtra("DetailsProduct", product)
                context.startActivity(intent);
            }

            val nameTextView = itemView.findViewById<TextView>(R.id.product_item_name_value)
            val descriptionProduct =
                itemView.findViewById<TextView>(R.id.product_item_description_value)
            val priceProduct = itemView.findViewById<TextView>(R.id.product_item_price_value)

            //binding de views
            nameTextView.text = product.name
            descriptionProduct.text = product.description
            val locale = NumberFormat.getCurrencyInstance(Locale("pt", "br"))

            val valueBRL = locale.format(product.price)
            priceProduct.text = valueBRL;

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(context)

        val view = inflater.inflate(R.layout.activity_product_item, parent, false)
        return ViewHolder(view, context)
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
