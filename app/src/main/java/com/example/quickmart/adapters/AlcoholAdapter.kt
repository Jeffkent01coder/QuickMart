package com.example.quickmart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.databinding.AlcoholItemBinding
import com.example.quickmart.model.ProductData

class AlcoholAdapter(
    private val list: ArrayList<ProductData>,
    val clickListener: OnAlcoholClickListener
) :
    RecyclerView.Adapter<AlcoholAdapter.AlcoholViewHolder>() {
    inner class AlcoholViewHolder(val alcoholItemBinding: AlcoholItemBinding) :
        RecyclerView.ViewHolder(alcoholItemBinding.root) {
        fun setData(product: ProductData, action: OnAlcoholClickListener) {
            alcoholItemBinding.apply {
                productTitle.text = product.productTitle
                product.productImage?.let { productImage.setImageResource(it) }
                productQuantity.text = product.productQuantity
                productPrice.text = product.productPrice
            }
            alcoholItemBinding.root.setOnClickListener {
                action.onAlcoholClick(product, adapterPosition)
            }

        }
    }


    interface OnAlcoholClickListener {
        fun onAlcoholClick(product: ProductData, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlcoholViewHolder {
        return AlcoholViewHolder(
            AlcoholItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AlcoholViewHolder, position: Int) {
        val product = list[position]
        holder.setData(product, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}