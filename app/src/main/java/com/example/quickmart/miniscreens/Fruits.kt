package com.example.quickmart.miniscreens

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.R
import com.example.quickmart.adapters.FruitAdapter
import com.example.quickmart.databinding.ActivityFruitsBinding
import com.example.quickmart.model.ProductData
import com.example.quickmart.subscreen.ProductDetails

class Fruits : AppCompatActivity(), FruitAdapter.OnFruitClickListener {
    private lateinit var binding: ActivityFruitsBinding
    private lateinit var adapter: FruitAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var fruitArrayList: ArrayList<ProductData>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFruitsBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        dataInitialize()
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView = binding.fruitRecyclerView
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = FruitAdapter(fruitArrayList, this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onFruitClick(product: ProductData, position: Int) {
        val intent = Intent(this, ProductDetails::class.java)
        intent.putExtra("image", product.productImage.toString())
        intent.putExtra("name", product.productTitle)
        intent.putExtra("quantity", product.productQuantity)
        intent.putExtra("price", product.productPrice)
        startActivity(intent)
    }

    private fun dataInitialize() {
        fruitArrayList = arrayListOf(
            ProductData("", R.drawable.bana, "bana", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.bana, "bana", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.bana, "bana", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.bana, "bana", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.bana, "bana", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.bana, "bana", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.bana, "bana", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.bana, "bana", "1", "", "$4.6", "", "", "", ""),
        )
    }
}