package com.example.quickmart.subscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quickmart.databinding.ActivityFruitsVegetablesBinding
import com.example.quickmart.miniscreens.Fruits
import com.example.quickmart.miniscreens.Vegetables

class FruitsVegetables : AppCompatActivity() {
    private lateinit var binding: ActivityFruitsVegetablesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFruitsVegetablesBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.fruits.setOnClickListener {
            startActivity(Intent(this, Fruits::class.java))
        }

        binding.vegetables.setOnClickListener {
            startActivity(Intent(this, Vegetables::class.java))
        }

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }
}