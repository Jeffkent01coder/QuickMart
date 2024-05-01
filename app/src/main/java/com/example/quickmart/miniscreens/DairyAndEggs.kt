package com.example.quickmart.miniscreens

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.R
import com.example.quickmart.adapters.DairyEggsAdapter
import com.example.quickmart.databinding.ActivityDairyAndEggsBinding
import com.example.quickmart.model.ProductData
import com.example.quickmart.subscreen.ProductDetails

class DairyAndEggs : AppCompatActivity(), DairyEggsAdapter.OnDairyClickListener {
    private lateinit var binding: ActivityDairyAndEggsBinding
    private lateinit var adapter: DairyEggsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var dairyArrayList: ArrayList<ProductData>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDairyAndEggsBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        dataInitialize()
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView = binding.dairyRecyclerView
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = DairyEggsAdapter(dairyArrayList, this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onDairyClick(product: ProductData, position: Int) {
        val intent = Intent(this, ProductDetails::class.java)
        intent.putExtra("image", product.productImage.toString())
        intent.putExtra("name", product.productTitle)
        intent.putExtra("quantity", product.productQuantity)
        intent.putExtra("price", product.productPrice)
        startActivity(intent)
    }

    override fun onAddToCartClick(product: ProductData, position: Int) {
        Toast.makeText(this, "added to cart", Toast.LENGTH_SHORT).show()
    }

    private fun dataInitialize() {
        dairyArrayList = arrayListOf(
            ProductData(
                "",
                R.drawable.dairyproducts,
                "Dairy Products",
                "1",
                "",
                "$4.6",
                "",
                "",
                "", "", ""
            ),
            ProductData("", R.drawable.eggs, "eggs", "1", "", "$4.6", "", "", "", "", ""),
            ProductData(
                "",
                R.drawable.dairyproducts,
                "Dairy Products",
                "1",
                "",
                "$4.6",
                "",
                "",
                "", "", ""
            ),
            ProductData("", R.drawable.eggs, "eggs", "1", "", "$4.6", "", "", "", "", ""),
            ProductData(
                "",
                R.drawable.dairyproducts,
                "Dairy Products",
                "1",
                "",
                "$4.6",
                "",
                "",
                "", "", ""
            ),
            ProductData("", R.drawable.eggs, "eggs", "1", "", "$4.6", "", "", "", "", "in stock"),
            ProductData(
                "",
                R.drawable.dairyproducts,
                "Dairy Products",
                "1",
                "",
                "$4.6",
                "",
                "",
                "", "", ""
            ),
            ProductData("", R.drawable.eggs, "eggs", "1", "", "$4.6", "", "", "", "", ""),
        )
    }
}