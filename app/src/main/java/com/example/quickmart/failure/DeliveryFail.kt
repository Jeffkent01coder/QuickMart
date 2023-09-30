package com.example.quickmart.failure

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quickmart.R
import com.example.quickmart.databinding.ActivityCardFailBinding
import com.example.quickmart.databinding.ActivityDeliveryFailBinding
import com.example.quickmart.screens.Home

class DeliveryFail : AppCompatActivity() {
    private lateinit var binding: ActivityDeliveryFailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDeliveryFailBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }
    }
}