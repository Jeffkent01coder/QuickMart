package com.example.quickmart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.databinding.FishseaItemBinding
import com.example.quickmart.model.ProductData

class FishAndSeaFoodAdapter(
    private val list: ArrayList<ProductData>,
    val clickListener: OnSeaClickListener
) : RecyclerView.Adapter<FishAndSeaFoodAdapter.SeaViewHolder>() {
    inner class SeaViewHolder(val fishseaItemBinding: FishseaItemBinding) :
        RecyclerView.ViewHolder(fishseaItemBinding.root) {
        fun setData(product: ProductData, action: OnSeaClickListener) {
            fishseaItemBinding.apply {
                productTitle.text = product.productTitle
                product.productImage?.let { productImage.setImageResource(it) }
                productQuantity.text = product.productQuantity
                productPrice.text = product.productPrice

                root.setOnClickListener {
                    action.onSeaClick(product, adapterPosition)
                }

                cart.setOnClickListener {
                    action.onAddToCartClick(product, adapterPosition)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeaViewHolder {
        return SeaViewHolder(
            FishseaItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SeaViewHolder, position: Int) {
        val product = list[position]
        holder.setData(product, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnSeaClickListener {
        fun onSeaClick(product: ProductData, position: Int)
        fun onAddToCartClick(product: ProductData, position: Int)
    }
}
