package com.example.kotlinpractice.api

import com.example.kotlinpractice.api.network.adapter.NetworkResponse
import com.example.kotlinpractice.api.request.GetSellerByIdRequest
import com.example.kotlinpractice.api.response.ApiError
import com.example.kotlinpractice.api.response.GetSellerByIdResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {


    //    @GET("1/mobile_api/web/v1/config")
//    suspend fun getConfigData(): NetworkResponse<ConfigResponse, ApiError>
//
    @POST("1/mobile_api/web/v1/store-list")
    suspend fun getSellerById(@Body getSellerByIdRequest: GetSellerByIdRequest): NetworkResponse<GetSellerByIdResponse, ApiError>

}