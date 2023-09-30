package com.example.quickmart.subscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quickmart.R
import com.example.quickmart.adapters.ViewPagerAdapter
import com.example.quickmart.chechoutfragments.CardFragment
import com.example.quickmart.chechoutfragments.MpesaFragment
import com.example.quickmart.chechoutfragments.OnDeliveryFragment
import com.example.quickmart.databinding.ActivityCheckoutsBinding

class Checkouts : AppCompatActivity() {
    private lateinit var binding: ActivityCheckoutsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCheckoutsBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUpTabs()

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

    }

    private fun setUpTabs() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(OnDeliveryFragment(), "Pay On Delivery")
        adapter.addFragment(MpesaFragment(), "Mpesa")
        adapter.addFragment(CardFragment(), "Card")
        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}