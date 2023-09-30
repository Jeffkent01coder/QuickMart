package com.example.quickmart.confim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quickmart.R
import com.example.quickmart.databinding.ActivityConfirmCardBinding
import com.example.quickmart.screens.Home

class ConfirmCard : AppCompatActivity() {
    private lateinit var binding : ActivityConfirmCardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityConfirmCardBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnConfirm.setOnClickListener {
            startActivity(Intent(this, CardSuccess::class.java))
        }

        binding.fail.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }


    }
}