package com.example.quickmart.miniscreens

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.R
import com.example.quickmart.adapters.VegetableAdapter
import com.example.quickmart.databinding.ActivityVegatablesBinding
import com.example.quickmart.model.ProductData
import com.example.quickmart.subscreen.ProductDetails

class Vegetables : AppCompatActivity(), VegetableAdapter.OnVegetableClickListener {
    private lateinit var binding: ActivityVegatablesBinding
    private lateinit var adapter: VegetableAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var vegetableArrayList: ArrayList<ProductData>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityVegatablesBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        dataInitialize()
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView = binding.vegetableRecyclerView
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = VegetableAdapter(vegetableArrayList, this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun dataInitialize() {
        vegetableArrayList = arrayListOf(
            ProductData("", R.drawable.vegetables, "vegetables", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.vegetables, "vegetables", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.vegetables, "vegetables", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.vegetables, "vegetables", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.vegetables, "vegetables", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.vegetables, "vegetables", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.vegetables, "vegetables", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.vegetables, "vegetables", "1", "", "$4.6", "", "", "", ""),
        )
    }

    override fun onVegetableClick(product: ProductData, position: Int) {
        val intent = Intent(this, ProductDetails::class.java)
        intent.putExtra("image", product.productImage.toString())
        intent.putExtra("name", product.productTitle)
        intent.putExtra("quantity", product.productQuantity)
        intent.putExtra("price", product.productPrice)
        startActivity(intent)
    }
}