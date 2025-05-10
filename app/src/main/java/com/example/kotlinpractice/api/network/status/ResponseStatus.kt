package com.example.kotlinpractice.api.network.status


data class ResponseStatus<out T>(
    val status: Status,
    val code: Int,
    val error: Error? = null,
    val body: T? = null
) {

    enum class Status {
        SUCCESS,
        ERROR
    }

    companion object {
        fun <T> success(code: Int): ResponseStatus<T> {
            return ResponseStatus(Status.SUCCESS, code)
        }

        fun <T> error(error: Error, code: Int): ResponseStatus<T> {
            return ResponseStatus(Status.ERROR, code, error)
        }
    }
}