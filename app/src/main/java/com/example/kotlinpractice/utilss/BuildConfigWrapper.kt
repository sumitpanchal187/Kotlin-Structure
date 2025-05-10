package com.example.kotlinpractice.utilss

object BuildConfigWrapper {
    val BASE_URL: String = BuildConfig.BASE_URL
    val API_KEY: String = BuildConfig.API_KEY
    val ENABLE_LOGS: Boolean = BuildConfig.ENABLE_LOGS
    val DEBUG: Boolean = BuildConfig.DEBUG
    val VERSION_NAME: String = BuildConfig.VERSION_NAME
    val VERSION_CODE: Int = BuildConfig.VERSION_CODE
    val APPLICATION_ID: String = BuildConfig.APPLICATION_ID
}