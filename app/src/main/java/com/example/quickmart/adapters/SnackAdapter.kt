package com.example.quickmart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.databinding.SnackItemBinding
import com.example.quickmart.model.ProductData

class SnackAdapter(
    private val list: ArrayList<ProductData>,
    val clickListener: OnSnackClickListener
) :
    RecyclerView.Adapter<SnackAdapter.SnackViewHolder>() {

    inner class SnackViewHolder(val snackItemBinding: SnackItemBinding) :
        RecyclerView.ViewHolder(snackItemBinding.root) {
        fun setData(product: ProductData, action: OnSnackClickListener) {
            snackItemBinding.apply {
                productTitle.text = product.productTitle
                product.productImage?.let { productImage.setImageResource(it) }
                productQuantity.text = product.productQuantity
                productPrice.text = product.productPrice
            }
            snackItemBinding.root.setOnClickListener {
                action.onSnackClick(product, adapterPosition)
            }

        }

    }

    interface OnSnackClickListener {
        fun onSnackClick(product: ProductData, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SnackViewHolder {
        return SnackViewHolder(
            SnackItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SnackViewHolder, position: Int) {
        val product = list[position]
        holder.setData(product, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}