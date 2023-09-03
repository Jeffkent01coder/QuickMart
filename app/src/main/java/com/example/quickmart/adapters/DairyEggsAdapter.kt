package com.example.quickmart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.databinding.DairyeggsItemBinding
import com.example.quickmart.model.ProductData

class DairyEggsAdapter(
    private val list: ArrayList<ProductData>,
    val clickListener: OnDairyClickListener
) : RecyclerView.Adapter<DairyEggsAdapter.DairyEggsViewHolder>() {
    inner class DairyEggsViewHolder(val dairyeggsItemBinding: DairyeggsItemBinding) :
        RecyclerView.ViewHolder(dairyeggsItemBinding.root) {
        fun setData(product: ProductData, action: OnDairyClickListener) {
            dairyeggsItemBinding.apply {
                productTitle.text = product.productTitle
                product.productImage?.let { productImage.setImageResource(it) }
                productQuantity.text = product.productQuantity
                productPrice.text = product.productPrice
            }
            dairyeggsItemBinding.root.setOnClickListener {
                action.onDairyClick(product, adapterPosition)
            }
        }

    }

    interface OnDairyClickListener {
        fun onDairyClick(product: ProductData, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DairyEggsViewHolder {
        return DairyEggsViewHolder(
            DairyeggsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DairyEggsViewHolder, position: Int) {
        val product = list[position]
        holder.setData(product, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}