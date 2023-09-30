package com.example.quickmart.confim

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quickmart.databinding.ActivityDeliverySuccessBinding
import com.example.quickmart.screens.Home

class DeliverySuccess : AppCompatActivity() {
    private lateinit var binding: ActivityDeliverySuccessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDeliverySuccessBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }
    }
}