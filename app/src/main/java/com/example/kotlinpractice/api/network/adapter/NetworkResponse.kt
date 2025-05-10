package com.example.kotlinpractice.api.network.adapter


sealed class NetworkResponse<out T : Any?, out U : Any> {
    /**
     * Success response with body
     */
    data class Success<T : Any>(val body: T, val code: Int) : NetworkResponse<T, Nothing>()

    /**
     * Failure response with body
     */
    data class ApiError<U : Any>(val body: Error?, val code: Int) : NetworkResponse<Nothing, U>()

    /**
     * Network error
     */
    data class NetworkError(val error: Error) : NetworkResponse<Nothing, Nothing>()

    /**
     * For example, json parsing error
     */
    data class UnknownError(val error: Error?) : NetworkResponse<Nothing, Nothing>()
}