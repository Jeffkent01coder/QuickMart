package com.example.quickmart.miniscreens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.R
import com.example.quickmart.adapters.MeatAndPoultryAdapter
import com.example.quickmart.adapters.SpiceAdapter
import com.example.quickmart.databinding.ActivityMeatAndPoultryBinding
import com.example.quickmart.model.ProductData
import com.example.quickmart.subscreen.ProductDetails

class MeatAndPoultry : AppCompatActivity(), MeatAndPoultryAdapter.OnMeatPoultryClickListener {
    private lateinit var binding : ActivityMeatAndPoultryBinding
    private lateinit var adapter: MeatAndPoultryAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var meatpoultryArrayList: ArrayList<ProductData>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMeatAndPoultryBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        dataInitialize()
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView = binding.meatPoultryRecyclerView
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MeatAndPoultryAdapter(meatpoultryArrayList, this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onMeatPoultryClick(product: ProductData, position: Int) {
        val intent = Intent(this, ProductDetails::class.java)
        intent.putExtra("image", product.productImage.toString())
        intent.putExtra("name", product.productTitle)
        intent.putExtra("quantity", product.productQuantity)
        intent.putExtra("price", product.productPrice)
        startActivity(intent)
    }

    private fun dataInitialize() {
        meatpoultryArrayList = arrayListOf(
            ProductData("", R.drawable.chicken, "chicken", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.meats, "meats", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.chicken, "chicken", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.meats, "meats", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.chicken, "chicken", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.meats, "meats", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.chicken, "chicken", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.meats, "meats", "1", "", "$4.6", "", "", "", ""),
        )
    }
}