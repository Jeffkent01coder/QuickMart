package com.example.quickmart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.databinding.CookingoilItemBinding
import com.example.quickmart.model.ProductData

class CookingOilAdapter(
    private val list: ArrayList<ProductData>,
    val clickListener: OnCookingClickListener
) :
    RecyclerView.Adapter<CookingOilAdapter.CookingViewHolder>() {

    inner class CookingViewHolder(val cookingoilItemBinding: CookingoilItemBinding) :
        RecyclerView.ViewHolder(cookingoilItemBinding.root) {
        fun setData(product: ProductData, action: OnCookingClickListener) {
            cookingoilItemBinding.apply {
                productTitle.text = product.productTitle
                product.productImage?.let { productImage.setImageResource(it) }
                productQuantity.text = product.productQuantity
                productPrice.text = product.productPrice
            }
            cookingoilItemBinding.root.setOnClickListener {
                action.onOilClick(product, adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CookingViewHolder {
        return CookingViewHolder(
            CookingoilItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CookingViewHolder, position: Int) {
        val product = list[position]
        holder.setData(product, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnCookingClickListener {
        fun onOilClick(product: ProductData, position: Int)
    }
}