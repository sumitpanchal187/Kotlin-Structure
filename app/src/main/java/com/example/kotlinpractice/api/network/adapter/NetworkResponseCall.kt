package com.example.kotlinpractice.api.network.adapter

import android.util.Log
import com.google.gson.Gson
import okhttp3.Request
import okhttp3.ResponseBody
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Response
import java.net.UnknownHostException

internal class NetworkResponseCall<S : Any, E : Any>(
    private val delegate: Call<S>,
    private val errorConverter: Converter<ResponseBody, E>
) : Call<NetworkResponse<S, E>> {

    override fun enqueue(callback: Callback<NetworkResponse<S, E>>) {
        return delegate.enqueue(object : Callback<S> {
            override fun onResponse(call: Call<S>, response: Response<S>) {
                val body = response.body()
                val code = response.code()
                val error = response.errorBody()
                Log.e("API Response", "Result Code -> $code Result ->  $body")

                if (response.isSuccessful) {
                    if (body != null) {
                        try {
                            val baseRes =
                                Gson().fromJson(Gson().toJson(body), BaseResponse::class.java)
                            val errorObj = Error()
                            errorObj.customErrorMessage = baseRes.error?.customErrorMessage
                            errorObj.customFieldValidationMessages =
                                baseRes.error?.customFieldValidationMessages
                            errorObj.url = call.request().url.toString()
                            if (code.equals(Constants.RESPONSE_CODE_200)) {
                                if (baseRes.error == null) {
                                    // Success case
                                    callback.onResponse(
                                        this@NetworkResponseCall,
                                        Response.success(NetworkResponse.Success(body, code))
                                    )
                                } else {
                                    callback.onResponse(
                                        this@NetworkResponseCall,
                                        Response.success(
                                            NetworkResponse.ApiError(
                                                errorObj,
                                                code
                                            )
                                        )
                                    )
                                }

                            } else {
                                callback.onResponse(
                                    this@NetworkResponseCall,
                                    Response.success(NetworkResponse.ApiError(errorObj, code))
                                )
                            }
                        } catch (e: Exception) {
                            val errorObj = Error(
                                customErrorMessage = CustomErrorMessage(
                                    title = Constants.UNKNOWN_API_ERROR_MSG,
                                    description = "$code : $body"
                                ),
                                url = call.request().url.toString()
                            )
                            callback.onResponse(
                                this@NetworkResponseCall,
                                Response.success(NetworkResponse.ApiError(errorObj, code))
                            )
                        }
                    } else {
                        // Response is successful but the body is null
                        callback.onResponse(
                            this@NetworkResponseCall,
                            Response.success(
                                NetworkResponse.UnknownError(
                                    Error(
                                        customErrorMessage = CustomErrorMessage(
                                            title = Constants.UNKNOWN_API_ERROR_MSG
                                        ),
                                        url = call.request().url.toString()
                                    )
                                )
                            )
                        )
                    }
                } else {
                    val errorBody = when {
                        error == null -> null
                        error.contentLength() == 0L -> null
                        else -> try {
                            errorConverter.convert(error)
                        } catch (ex: Exception) {
                            null
                        }
                    }
                    if (errorBody != null) {
                        val errorObj = Error()
                        try {
                            val baseRes =
                                Gson().fromJson(Gson().toJson(errorBody), BaseResponse::class.java)
                            errorObj.customErrorMessage = baseRes.error?.customErrorMessage
                            errorObj.customFieldValidationMessages =
                                baseRes.error?.customFieldValidationMessages
                            errorObj.sourceResponse = baseRes.error?.sourceResponse
                            errorObj.url = call.request().url.toString()
                        } catch (ex: Exception) {
                            errorObj.customErrorMessage = CustomErrorMessage(
                                title = Constants.UNKNOWN_API_ERROR_MSG,
                                description = errorBody.toString()
                            )
                            errorObj.url = call.request().url.toString()
                        }

                        callback.onResponse(
                            this@NetworkResponseCall,
                            Response.success(NetworkResponse.ApiError(errorObj, code))
                        )
                    } else {
                        callback.onResponse(
                            this@NetworkResponseCall,
                            Response.success(
                                NetworkResponse.UnknownError(
                                    Error(
                                        customErrorMessage = CustomErrorMessage(
                                            title = Constants.UNKNOWN_API_ERROR_MSG
                                        ),
                                        url = call.request().url.toString()
                                    )
                                )
                            )
                        )
                    }
                }
            }

            override fun onFailure(call: Call<S>, throwable: Throwable) {
                Log.e("Retrofit Failure:=>", throwable.toString())
                throwable.printStackTrace()
                val networkResponse = when (throwable) {
                    is UnknownHostException -> NetworkResponse.NetworkError(
                        Error(
                            customErrorMessage = CustomErrorMessage(
                                title = Constants.ERROR_TITLE_OOPS,
                                description = Constants.NETWORK_ERROR_MSG,
                            ),
                            url = call.request().url.toString()
                        )
                    )

                    else -> NetworkResponse.UnknownError(
                        Error(
                            customErrorMessage = CustomErrorMessage(
                                title = Constants.UNKNOWN_API_ERROR_MSG
                            ),
                            url = call.request().url.toString()
                        )
                    )
                }
                callback.onResponse(this@NetworkResponseCall, Response.success(networkResponse))
            }
        })
    }

    override fun isExecuted() = delegate.isExecuted

    override fun clone() = NetworkResponseCall(delegate.clone(), errorConverter)

    override fun isCanceled() = delegate.isCanceled

    override fun cancel() = delegate.cancel()

    override fun execute(): Response<NetworkResponse<S, E>> {
        throw UnsupportedOperationException("NetworkResponseCall doesn't support execute")
    }

    override fun request(): Request = delegate.request()

    override fun timeout(): Timeout = delegate.timeout()
}