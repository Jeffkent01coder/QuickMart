package com.example.quickmart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.databinding.FruitItemBinding
import com.example.quickmart.model.ProductData

class FruitAdapter(
    private val list: ArrayList<ProductData>,
    val clickListener: OnFruitClickListener
) :
    RecyclerView.Adapter<FruitAdapter.FruitViewHolder>() {

    inner class FruitViewHolder(val fruitItemBinding: FruitItemBinding) :
        RecyclerView.ViewHolder(fruitItemBinding.root) {

        fun setData(product: ProductData, action: OnFruitClickListener) {
            fruitItemBinding.apply {
                productTitle.text = product.productTitle
                product.productImage?.let { productImage.setImageResource(it) }
                productQuantity.text = product.productQuantity
                productPrice.text = product.productPrice
            }
            fruitItemBinding.root.setOnClickListener {
                action.onFruitClick(product, adapterPosition)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        return FruitViewHolder(
            FruitItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        val product = list[position]
        holder.setData(product, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnFruitClickListener {
        fun onFruitClick(product: ProductData, position: Int)
    }

}