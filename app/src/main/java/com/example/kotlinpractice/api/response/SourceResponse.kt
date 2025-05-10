package com.example.kotlinpractice.api.response

import com.google.gson.annotations.SerializedName

data class SourceResponse(

    @field:SerializedName("result")
    val result: Any? = null,

    @field:SerializedName("success")
    val success: Boolean? = null,

    @field:SerializedName("__abp")
    val abp: Boolean? = null,

    @field:SerializedName("error")
    val error: Error? = null,

    @field:SerializedName("targetUrl")
    val targetUrl: Any? = null,

    @field:SerializedName("unAuthorizedRequest")
    val unAuthorizedRequest: Boolean? = null
)

data class ValidationErrorsItem(

    @field:SerializedName("members")
    val members: ArrayList<String?>? = null,

    @field:SerializedName("message")
    val message: String? = null
)
