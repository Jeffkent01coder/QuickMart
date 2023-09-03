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

            var quantity = 0
            productAmount.text = quantity.toString()

            binding.btnAdd.setOnClickListener {
                quantity += 1
                productAmount.text = quantity.toString()
            }

            binding.btnSubtract.setOnClickListener {
                if (quantity < 1){
                    quantity = 0
                }else{
                    quantity -= 1

                }
                productAmount.text = quantity.toString()

            }

        }
//        binding.btnAddToCart.setOnClickListener {
//            val navController = findNavController(R.id.nav_host_fragment)
//            navController.navigate(R.id.action_start_to_myFragment)
//        }

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }
}