package com.example.quickmart.model

data class CartData(
    val uid : String,
    val productId : String,
    val productImage : Int? = 0,
    val productTitle : String? = "",
    val productQuantity : String? = "",
    val productDetails : String? = "",
    val productPrice : String? = "",
    val mainCategory : String? = "",
    val subCategory : String? = "",
    val promotionTitle : String? = "",
    val productDiscount : String? = "",
    val stock : String? = "",
    val quantity : String? = ""
)
