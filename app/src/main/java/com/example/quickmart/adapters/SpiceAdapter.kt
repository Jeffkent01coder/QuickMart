package com.example.quickmart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.databinding.SpiceItemBinding
import com.example.quickmart.model.ProductData

class SpiceAdapter(
    private val list: ArrayList<ProductData>,
    val clickListener: OnSpiceClickListener
) :
    RecyclerView.Adapter<SpiceAdapter.SpiceViewHolder>() {
    inner class SpiceViewHolder(val spiceItemBinding: SpiceItemBinding) :
        RecyclerView.ViewHolder(spiceItemBinding.root) {
        fun setData(product: ProductData, action: OnSpiceClickListener) {
            spiceItemBinding.apply {
                productTitle.text = product.productTitle
                product.productImage?.let { productImage.setImageResource(it) }
                productQuantity.text = product.productQuantity
                productPrice.text = product.productPrice
            }
            spiceItemBinding.root.setOnClickListener {
                action.onSpiceClick(product, adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpiceViewHolder {
        return SpiceViewHolder(
            SpiceItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SpiceViewHolder, position: Int) {
        val product = list[position]
        holder.setData(product, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnSpiceClickListener {
        fun onSpiceClick(product: ProductData, position: Int)
    }
}