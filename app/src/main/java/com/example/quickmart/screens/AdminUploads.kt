package com.example.quickmart.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quickmart.R
import com.example.quickmart.databinding.ActivityAdminUploadsBinding

class AdminUploads : AppCompatActivity() {
    private lateinit var binding : ActivityAdminUploadsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAdminUploadsBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.SHOWALL.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }
}