package com.example.quickmart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.databinding.ElectronicItemBinding
import com.example.quickmart.model.ProductData

class ElectronicAdapter(
    private val list: ArrayList<ProductData>,
    val clickListener: OnElectronicClickListener
) :
    RecyclerView.Adapter<ElectronicAdapter.ElectronicViewHolder>() {

    inner class ElectronicViewHolder(val electronicItemBinding: ElectronicItemBinding) :
        RecyclerView.ViewHolder(electronicItemBinding.root) {

        fun setData(product: ProductData, action: OnElectronicClickListener) {
            electronicItemBinding.apply {
                productTitle.text = product.productTitle
                product.productImage?.let { productImage.setImageResource(it) }
                productQuantity.text = product.productQuantity
                productPrice.text = product.productPrice

                root.setOnClickListener {
                    action.onElectronicClick(product, adapterPosition)
                }

                cart.setOnClickListener {
                    action.onAddClick(product, adapterPosition)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElectronicViewHolder {
        return ElectronicViewHolder(
            ElectronicItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ElectronicViewHolder, position: Int) {
        val product = list[position]
        holder.setData(product, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnElectronicClickListener {
        fun onElectronicClick(product: ProductData, position: Int)
        fun onAddClick(product: ProductData, position: Int)
    }
}
