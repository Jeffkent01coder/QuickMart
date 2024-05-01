package com.example.quickmart.model

data class UserData(
    val name : String? = "",
    val email: String? = "",
    val phone : String? = "",
    val location : String? = ""
){
    constructor() : this("","","","")
}
