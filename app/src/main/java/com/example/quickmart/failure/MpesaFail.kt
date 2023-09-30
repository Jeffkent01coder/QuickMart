package com.example.quickmart.failure

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quickmart.R
import com.example.quickmart.databinding.ActivityMpesaFailBinding
import com.example.quickmart.screens.Home

class MpesaFail : AppCompatActivity() {
    private  lateinit var binding: ActivityMpesaFailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMpesaFailBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }


    }
}