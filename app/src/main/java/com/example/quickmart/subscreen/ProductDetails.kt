package com.example.quickmart.subscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quickmart.databinding.ActivityProductDettailsBinding

class ProductDetails : AppCompatActivity() {
    private lateinit var binding : ActivityProductDettailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProductDettailsBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            intent

            productImage.setImageResource(intent.getStringExtra("image")!!.toInt())
            productTitle.text = intent.getStringExtra("name")
            productQuantity.text = intent.getStringExtra("quantity")
            productPrice.text = intent.getStringExtra("price")

            var quantity = 1
            productAmount.text = quantity.toString()

            binding.btnAdd.setOnClickListener {
                quantity += 1
                productAmount.text = quantity.toString()
            }

            binding.btnSubtract.setOnClickListener {
                if (quantity > 1) { // Ensure quantity is greater than 1
                    quantity -= 1
                    productAmount.text = quantity.toString()
                }
            }
        }

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }
}
