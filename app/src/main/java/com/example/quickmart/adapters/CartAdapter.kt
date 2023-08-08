package com.example.quickmart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.databinding.CartItemBinding
import com.example.quickmart.model.ProductData

class CartAdapter(
    private val list: ArrayList<ProductData>,
    val clickListener: OnCartClickListener
) :
    RecyclerView.Adapter<CartAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val cartItemBinding: CartItemBinding) :
        RecyclerView.ViewHolder(cartItemBinding.root) {
        fun setData(product: ProductData, action: OnCartClickListener) {
            cartItemBinding.apply {
                productTitle.text = product.productTitle
                product.productImage?.let { productImage.setImageResource(it) }
                productQuantity.text = product.productQuantity
                productPrice.text = product.productPrice
            }
            cartItemBinding.root.setOnClickListener {
                action.onCartClick(product, adapterPosition)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            CartItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = list[position]
        holder.setData(product, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnCartClickListener {
        fun onCartClick(product: ProductData, position: Int)
    }
}