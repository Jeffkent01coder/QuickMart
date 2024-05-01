package com.example.quickmart.miniscreens

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.R
import com.example.quickmart.adapters.SpiceAdapter
import com.example.quickmart.databinding.ActivitySpicesBinding
import com.example.quickmart.model.ProductData
import com.example.quickmart.subscreen.ProductDetails

class Spices : AppCompatActivity(), SpiceAdapter.OnSpiceClickListener {
    private lateinit var binding: ActivitySpicesBinding
    private lateinit var adapter: SpiceAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var spiceArrayList: ArrayList<ProductData>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySpicesBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        dataInitialize()
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView = binding.spiceRecyclerView
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = SpiceAdapter(spiceArrayList, this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onSpiceClick(product: ProductData, position: Int) {
        val intent = Intent(this, ProductDetails::class.java)
        intent.putExtra("image", product.productImage.toString())
        intent.putExtra("name", product.productTitle)
        intent.putExtra("quantity", product.productQuantity)
        intent.putExtra("price", product.productPrice)
        startActivity(intent)
    }

    override fun onAddToCartClick(product: ProductData, position: Int) {
        Toast.makeText(this,"added to cart", Toast.LENGTH_SHORT).show()
    }

    private fun dataInitialize() {
        spiceArrayList = arrayListOf(
            ProductData("", R.drawable.spice, "spice", "1", "", "$4.6", "", "", ""),
            ProductData("", R.drawable.spice, "spice", "1", "", "$4.6", "", "", ""),
            ProductData("", R.drawable.spice, "spice", "1", "", "$4.6", "", "", ""),
            ProductData("", R.drawable.spice, "spice", "1", "", "$4.6", "", "", ""),
            ProductData("", R.drawable.spice, "spice", "1", "", "$4.6", "", "", ""),
            ProductData("", R.drawable.spice, "spice", "1", "", "$4.6", "", "", ""),
            ProductData("", R.drawable.spice, "spice", "1", "", "$4.6", "", "", ""),
            ProductData("", R.drawable.spice, "spice", "1", "", "$4.6", "", "", ""),
        )
    }
}