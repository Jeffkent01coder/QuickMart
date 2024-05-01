package com.example.quickmart.model

data class ProductData(
    val productId : String,
    val productImage : Int? = 0,
    val productTitle : String? = "",
    val productQuantity : String? = "",
    val productDetails : String? = "",
    val productPrice : String? = "",
    val mainCategory : String? = "",
    val subCategory : String? = "",
    val promotionTitle : String? = "",

)
