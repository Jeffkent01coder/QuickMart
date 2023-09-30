package com.example.quickmart.failure

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quickmart.databinding.ActivityCardFailBinding
import com.example.quickmart.screens.Home

class CardFail : AppCompatActivity() {
    private lateinit var binding: ActivityCardFailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCardFailBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }
    }
}