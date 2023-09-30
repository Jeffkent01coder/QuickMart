package com.example.quickmart.confim

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quickmart.databinding.ActivityConfirmDeliveryBinding
import com.example.quickmart.failure.DeliveryFail

class ConfirmDelivery : AppCompatActivity() {
    private lateinit var binding: ActivityConfirmDeliveryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityConfirmDeliveryBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnConfirm.setOnClickListener {
            startActivity(Intent(this, DeliverySuccess::class.java))
        }

        binding.failDelivery.setOnClickListener {
            startActivity(Intent(this, DeliveryFail::class.java))
        }
    }
}