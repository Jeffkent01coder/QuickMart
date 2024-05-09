package com.example.quickmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.quickmart.screens.Home
import com.example.quickmart.screens.Login

class MainActivity : AppCompatActivity() {

    // Constant for delay in milliseconds
    private val DELAY_MILLIS = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        // Hide action bar and launch Home activity after a delay
        Handler().postDelayed({
            launchHomeActivity()
        }, DELAY_MILLIS)
    }

    // Function to launch Home activity
    private fun launchHomeActivity() {
        try {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
            finish()
        } catch (e: Exception) {
            // Handle any exceptions that may occur when starting activity
            e.printStackTrace()
        }
    }
}
