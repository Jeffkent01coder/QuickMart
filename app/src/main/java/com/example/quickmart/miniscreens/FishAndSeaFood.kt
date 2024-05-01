package com.example.quickmart.miniscreens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.R
import com.example.quickmart.adapters.FishAndSeaFoodAdapter
import com.example.quickmart.adapters.FruitAdapter
import com.example.quickmart.databinding.ActivityFishAndSeaFoodBinding
import com.example.quickmart.model.ProductData
import com.example.quickmart.subscreen.ProductDetails

class FishAndSeaFood : AppCompatActivity(), FishAndSeaFoodAdapter.OnSeaClickListener {
    private lateinit var binding : ActivityFishAndSeaFoodBinding
    private lateinit var adapter: FishAndSeaFoodAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var fishseaArrayList: ArrayList<ProductData>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding =  ActivityFishAndSeaFoodBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        dataInitialize()
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView = binding.fishSeaRecyclerView
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = FishAndSeaFoodAdapter(fishseaArrayList, this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onSeaClick(product: ProductData, position: Int) {
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
        fishseaArrayList = arrayListOf(
            ProductData("", R.drawable.fish, "fish", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.fish, "fish", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.fish, "fish", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.fish, "fish", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.fish, "fish", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.fish, "fish", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.fish, "fish", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.fish, "fish", "1", "", "$4.6", "", "", "", ""),
        )
    }
}