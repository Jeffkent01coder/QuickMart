package com.example.quickmart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.databinding.VegetableItemBinding
import com.example.quickmart.model.ProductData

class VegetableAdapter(
    private val list: ArrayList<ProductData>,
    val clickListener: OnVegetableClickListener
) :
    RecyclerView.Adapter<VegetableAdapter.VegetableViewHolder>() {

    inner class VegetableViewHolder(val vegetableItemBinding: VegetableItemBinding) :
        RecyclerView.ViewHolder(vegetableItemBinding.root) {

        fun setData(product: ProductData, action: OnVegetableClickListener) {
            vegetableItemBinding.apply {
                productTitle.text = product.productTitle
                product.productImage?.let { productImage.setImageResource(it) }
                productQuantity.text = product.productQuantity
                productPrice.text = product.productPrice

                root.setOnClickListener {
                    action.onVegetableClick(product, adapterPosition)
                }

                cart.setOnClickListener {
                    action.onAddToCartClick(product, adapterPosition)
                }
            }
        }
    }

    interface OnVegetableClickListener {
        fun onVegetableClick(product: ProductData, position: Int)
        fun onAddToCartClick(product: ProductData, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VegetableViewHolder {
        return VegetableViewHolder(
            VegetableItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VegetableViewHolder, position: Int) {
        val product = list[position]
        holder.setData(product, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
