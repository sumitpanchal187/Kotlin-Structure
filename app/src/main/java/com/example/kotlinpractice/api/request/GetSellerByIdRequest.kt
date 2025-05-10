package com.example.kotlinpractice.api.request


import com.google.gson.annotations.SerializedName

data class GetSellerByIdRequest(
    @SerializedName("sellerId")
    val sellerId: Int
)