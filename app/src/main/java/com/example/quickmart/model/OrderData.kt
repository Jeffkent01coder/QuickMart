package com.example.quickmart.model

data class OrderData(
    val uid : String,
    val productId : String,
    val approved: Boolean = false
    )
