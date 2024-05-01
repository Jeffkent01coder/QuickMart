package com.example.quickmart.miniscreens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.R
import com.example.quickmart.adapters.ChilledFoodAdapter
import com.example.quickmart.adapters.CookingOilAdapter
import com.example.quickmart.databinding.ActivityChilledFoodBinding
import com.example.quickmart.databinding.ActivityFruitsBinding
import com.example.quickmart.model.ProductData
import com.example.quickmart.subscreen.ProductDetails

class ChilledFood : AppCompatActivity(), ChilledFoodAdapter.OnChilledClickListener {
    private lateinit var binding : ActivityChilledFoodBinding

    private lateinit var adapter: ChilledFoodAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var chilledArrayList: ArrayList<ProductData>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityChilledFoodBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        dataInitialize()
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView = binding.chilledFoodRecyclerView
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = ChilledFoodAdapter(chilledArrayList, this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onChilledClick(product: ProductData, position: Int) {
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
        chilledArrayList = arrayListOf(
            ProductData("", R.drawable.chill, "chill", "1", "", "$4.6", "", "", "","",""),
            ProductData("", R.drawable.chill, "chill", "1", "", "$4.6", "", "", "","",""),
            ProductData("", R.drawable.chill, "chill", "1", "", "$4.6", "", "", "","",""),
            ProductData("", R.drawable.chill, "chill", "1", "", "$4.6", "", "", "","",""),
            ProductData("", R.drawable.chill, "chill", "1", "", "$4.6", "", "", "","",""),
            ProductData("", R.drawable.chill, "chill", "1", "", "$4.6", "", "", "","",""),
            ProductData("", R.drawable.chill, "chill", "1", "", "$4.6", "", "", "","",""),
            ProductData("", R.drawable.chill, "chill", "1", "", "$4.6", "", "", "","",""),
        )
    }
}