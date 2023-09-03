package com.example.quickmart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.databinding.MeatandpoultryItemBinding
import com.example.quickmart.model.ProductData

class MeatAndPoultryAdapter(
    private val list: ArrayList<ProductData>,
    val clickListener: OnMeatPoultryClickListener
) : RecyclerView.Adapter<MeatAndPoultryAdapter.MeatViewHolder>() {
    inner class MeatViewHolder(val meatandpoultryItemBinding: MeatandpoultryItemBinding) :
        RecyclerView.ViewHolder(meatandpoultryItemBinding.root) {
        fun setData(product: ProductData, action: OnMeatPoultryClickListener) {
            meatandpoultryItemBinding.apply {
                productTitle.text = product.productTitle
                product.productImage?.let { productImage.setImageResource(it) }
                productQuantity.text = product.productQuantity
                productPrice.text = product.productPrice
            }
            meatandpoultryItemBinding.root.setOnClickListener {
                action.onMeatPoultryClick(product, adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeatViewHolder {
        return MeatViewHolder(
            MeatandpoultryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MeatViewHolder, position: Int) {
        val product = list[position]
        holder.setData(product, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnMeatPoultryClickListener {
        fun onMeatPoultryClick(product: ProductData, position: Int)
    }
}