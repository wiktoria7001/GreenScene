package com.dsw.pam.greenscene.model


data class Restaurant(
    val id: String = "",
    val name: String = "",
    val address: String = "",
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val openingHours: String = "",
    val priceRange: String = ""
)
