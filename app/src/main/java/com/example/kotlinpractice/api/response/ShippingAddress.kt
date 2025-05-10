package com.example.kotlinpractice.api.response


import com.google.gson.annotations.SerializedName

data class ShippingAddress(
    @SerializedName("addressLine1")
    val addressLine1: String,
    @SerializedName("addressLine2")
    val addressLine2: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("pinCode")
    val pinCode: String,
    @SerializedName("state")
    val state: String
)