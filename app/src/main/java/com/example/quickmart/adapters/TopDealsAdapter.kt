package com.example.quickmart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.databinding.DealItemBinding
import com.example.quickmart.model.ProductData

class TopDealsAdapter(
    private val list: ArrayList<ProductData>,
    val clickListener: OnDealClickListener
) :
    RecyclerView.Adapter<TopDealsAdapter.DealViewHolder>() {

    inner class DealViewHolder(val dealItemBinding: DealItemBinding) :
        RecyclerView.ViewHolder(dealItemBinding.root) {
        fun setData(product: ProductData, action: OnDealClickListener) {
            dealItemBinding.apply {
                productTitle.text = product.productTitle
                product.productImage?.let { productImage.setImageResource(it) }
                productQuantity.text = product.productQuantity
                productPrice.text = product.productPrice
            }
            dealItemBinding.root.setOnClickListener {
                action.onDealClick(product, adapterPosition)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealViewHolder {
        return DealViewHolder(
            DealItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DealViewHolder, position: Int) {
        val product = list[position]
        holder.setData(product, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnDealClickListener {
        fun onDealClick(product: ProductData, position: Int)
    }


}