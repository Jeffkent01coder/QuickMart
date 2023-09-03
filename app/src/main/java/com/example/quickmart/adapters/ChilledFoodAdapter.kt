package com.example.quickmart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.databinding.ChilledItemBinding
import com.example.quickmart.model.ProductData

class ChilledFoodAdapter(
    private val list: ArrayList<ProductData>,
    val clickListener: OnChilledClickListener
) : RecyclerView.Adapter<ChilledFoodAdapter.ChilledViewHolder>() {
    inner class ChilledViewHolder(val chilledItemBinding: ChilledItemBinding) :
        RecyclerView.ViewHolder(chilledItemBinding.root) {
        fun setData(product: ProductData, action: OnChilledClickListener) {
            chilledItemBinding.apply {
                productTitle.text = product.productTitle
                product.productImage?.let { productImage.setImageResource(it) }
                productQuantity.text = product.productQuantity
                productPrice.text = product.productPrice
            }
            chilledItemBinding.root.setOnClickListener {
                action.onChilledClick(product, adapterPosition)
            }
        }

    }

    interface OnChilledClickListener {
        fun onChilledClick(product: ProductData, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChilledViewHolder {
        return ChilledViewHolder(
            ChilledItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ChilledViewHolder, position: Int) {
        val product = list[position]
        holder.setData(product, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}