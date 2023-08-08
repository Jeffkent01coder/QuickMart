package com.example.quickmart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.databinding.CategoryItemBinding
import com.example.quickmart.model.ProductData

class CategoryAdapter(
    private val list: ArrayList<ProductData>,
    val clickListener: OnCategoryClickListener
) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(val categoryItemBinding: CategoryItemBinding) :
        RecyclerView.ViewHolder(categoryItemBinding.root) {

        fun setData(category: ProductData, action: OnCategoryClickListener) {
            categoryItemBinding.apply {
                category.categoryImage?.let { categoryImage.setImageResource(it) }
                categoryTitle.text = category.mainCategory
            }
            categoryItemBinding.root.setOnClickListener {
                action.onCategoryClick(category, adapterPosition)
            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            CategoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = list[position]
        holder.setData(category, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnCategoryClickListener {
        fun onCategoryClick(category: ProductData, position: Int)
    }

}