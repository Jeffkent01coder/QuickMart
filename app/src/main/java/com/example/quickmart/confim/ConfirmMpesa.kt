package com.example.quickmart.confim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quickmart.R
import com.example.quickmart.databinding.ActivityConfirmMpesaBinding
import com.example.quickmart.screens.Home

class ConfirmMpesa : AppCompatActivity() {
    private lateinit var binding: ActivityConfirmMpesaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityConfirmMpesaBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }
    }
}