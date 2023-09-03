package com.example.quickmart.miniscreens

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.R
import com.example.quickmart.adapters.CookingOilAdapter
import com.example.quickmart.databinding.ActivityCookingOilBinding
import com.example.quickmart.model.ProductData
import com.example.quickmart.subscreen.ProductDetails

class CookingOil : AppCompatActivity(), CookingOilAdapter.OnCookingClickListener {
    private lateinit var adapter: CookingOilAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var oilArrayList: ArrayList<ProductData>
    private lateinit var binding: ActivityCookingOilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCookingOilBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        dataInitialize()
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView = binding.oilRecyclerView
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = CookingOilAdapter(oilArrayList, this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    override fun onOilClick(product: ProductData, position: Int) {
        val intent = Intent(this, ProductDetails::class.java)
        intent.putExtra("image", product.productImage.toString())
        intent.putExtra("name", product.productTitle)
        intent.putExtra("quantity", product.productQuantity)
        intent.putExtra("price", product.productPrice)
        startActivity(intent)
    }

    private fun dataInitialize() {
        oilArrayList = arrayListOf(
            ProductData("", R.drawable.oils, "Cooking Oil", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.oils, "Cooking Oil", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.oils, "Cooking Oil", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.oils, "Cooking Oil", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.oils, "Cooking Oil", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.oils, "Cooking Oil", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.oils, "Cooking Oil", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.oils, "Cooking Oil", "1", "", "$4.6", "", "", "", ""),
        )
    }
}