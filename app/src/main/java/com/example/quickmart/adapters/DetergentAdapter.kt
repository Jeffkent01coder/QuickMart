package com.example.quickmart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.databinding.DetergentItemBinding
import com.example.quickmart.model.ProductData

class DetergentAdapter(
    private val list: ArrayList<ProductData>,
    val clickListener: OnDetergentClickListener
) :
    RecyclerView.Adapter<DetergentAdapter.DetergentViewHolder>() {

    inner class DetergentViewHolder(val detergentItemBinding: DetergentItemBinding) :
        RecyclerView.ViewHolder(detergentItemBinding.root) {

        fun setData(product: ProductData, action: OnDetergentClickListener) {
            detergentItemBinding.apply {
                productTitle.text = product.productTitle
                product.productImage?.let { productImage.setImageResource(it) }
                productQuantity.text = product.productQuantity
                productPrice.text = product.productPrice

                root.setOnClickListener {
                    action.onDetergentClick(product, adapterPosition)
                }

                cart.setOnClickListener {
                    action.onAddClick(product, adapterPosition)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetergentViewHolder {
        return DetergentViewHolder(
            DetergentItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: DetergentViewHolder, position: Int) {
        val product = list[position]
        holder.setData(product, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnDetergentClickListener {
        fun onDetergentClick(product: ProductData, position: Int)
        fun onAddClick(product: ProductData, position: Int)
    }
}
