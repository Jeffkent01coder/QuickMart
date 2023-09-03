package com.example.quickmart.subscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quickmart.databinding.ActivityFreshFoodBinding
import com.example.quickmart.miniscreens.ChilledFood
import com.example.quickmart.miniscreens.DairyAndEggs
import com.example.quickmart.miniscreens.FishAndSeaFood
import com.example.quickmart.miniscreens.MeatAndPoultry

class FreshFood : AppCompatActivity() {
    private lateinit var binding : ActivityFreshFoodBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFreshFoodBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
        binding.dairy.setOnClickListener {
            startActivity(Intent(this, DairyAndEggs::class.java))
        }

        binding.meatandPoultry.setOnClickListener {
            startActivity(Intent(this, MeatAndPoultry::class.java))
        }

        binding.chilledFood.setOnClickListener {
            startActivity(Intent(this, ChilledFood::class.java))
        }

        binding.fishSea.setOnClickListener {
            startActivity(Intent(this, FishAndSeaFood::class.java))
        }


    }
}