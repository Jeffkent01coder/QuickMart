package com.example.quickmart.confim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quickmart.R
import com.example.quickmart.databinding.ActivityCardSuccessBinding
import com.example.quickmart.screens.Home

class CardSuccess : AppCompatActivity() {
    private lateinit var binding: ActivityCardSuccessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCardSuccessBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }
    }
}