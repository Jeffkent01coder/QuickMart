package com.example.quickmart.subscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quickmart.databinding.ActivityCookingIngredientsBinding
import com.example.quickmart.miniscreens.CookingOil
import com.example.quickmart.miniscreens.Spices

class CookingIngredients : AppCompatActivity() {
    private lateinit var binding: ActivityCookingIngredientsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCookingIngredientsBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        binding.cookingOil.setOnClickListener {
            startActivity(Intent(this, CookingOil::class.java))
        }

        binding.spices.setOnClickListener {
            startActivity(Intent(this, Spices::class.java))
        }
    }
}