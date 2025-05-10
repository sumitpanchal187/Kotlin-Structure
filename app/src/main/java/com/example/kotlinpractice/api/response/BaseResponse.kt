package com.example.kotlinpractice.api.response

import com.google.gson.annotations.SerializedName

open class BaseResponse(

    @field:SerializedName("success")
    val success: Boolean? = null,

    @field:SerializedName("error")
    val error: Error? = null,

    @field:SerializedName("per_page_records")
    val perPageRecords: Int? = null,
)

data class Error(

    @field:SerializedName("customFieldValidationMessages")
    var customFieldValidationMessages: ArrayList<CustomFieldValidationMessagesItem?>? = null,

    @field:SerializedName("customErrorMessage")
    var customErrorMessage: CustomErrorMessage? = null,

    @field:SerializedName("sourceResponse")
    var sourceResponse: SourceResponse? = null,

    var url: String? = null
)

data class CustomErrorMessage(

    @field:SerializedName("identifierCodeDisplay")
    val identifierCodeDisplay: String? = null,

    @field:SerializedName("identifierCode")
    val identifierCode: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("details")
    val details: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("x-amzn-RequestId")
    val xAmznRequestId: String? = null
)

data class CustomFieldValidationMessagesItem(

    @field:SerializedName("identifierFieldID")
    val identifierFieldID: String? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("identifierFieldValidationMessage")
    val identifierFieldValidationMessage: String? = null
)
