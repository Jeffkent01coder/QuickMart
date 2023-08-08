package com.example.quickmart.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.quickmart.R
import com.example.quickmart.databinding.ActivityHomeBinding
import com.example.quickmart.homeFragments.*

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.icShop -> replaceFragment(HomeFragment())
                R.id.icExplore -> replaceFragment(FindFragment())
                R.id.icDeals -> replaceFragment(DealsFragment())
                R.id.icCart -> replaceFragment(CartFragment())
                R.id.icMore -> replaceFragment(MoreFragment())

                else -> {
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}