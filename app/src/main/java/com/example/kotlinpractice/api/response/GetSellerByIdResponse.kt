package com.example.kotlinpractice.api.response


import com.google.gson.annotations.SerializedName

data class GetSellerByIdResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("message")
    val message: String
)