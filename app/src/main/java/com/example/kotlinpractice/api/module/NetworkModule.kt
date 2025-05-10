package com.example.kotlinpractice.api.module

import android.content.Context
import android.util.Log
import com.example.kotlinpractice.R
import com.example.kotlinpractice.api.module.qualifier.HostCoroutineQualifier
import com.example.kotlinpractice.utilss.BuildConfigWrapper
import com.example.kotlinpractice.utilss.Constants
import com.example.kotlinpractice.utilss.Constants.API_APP_NAME
import com.example.kotlinpractice.utilss.NetworkResponseAdapterFactory
import com.example.kotlinpractice.utilss.PARAMS
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal object NetworkModule {

    lateinit var okHttpClient: OkHttpClient
    lateinit var retrofitHostApiService: Retrofit



    @Provides
    @Singleton
    @HostCoroutineQualifier
    fun provideInterceptor(@ApplicationContext context: Context): Interceptor {
        return Interceptor { chain: Interceptor.Chain ->
            val original = chain.request()
            val requestBuilder: Request.Builder = original.newBuilder()

            // Example: Add Authorization Header (Using app-specific tokens instead of Firebase)
            if (original.url.encodedPath.contains("/APIsWrapperGateway/apiv1")) {
                runBlocking {
                    requestBuilder.header(
                        PARAMS.HEADER_AUTHORIZATION,
                        "Bearer ${Utils.getCRMToken(context)}"
                    )
                }
                requestBuilder.header(PARAMS.HEADER_SOAP_ACTION, "https://MatrixAPIs/JSONCommand2")
            } else if (original.url.encodedPath.contains("/app/KeyValue/GetOutletDetails")) {
                requestBuilder.header(
                    PARAMS.HEADER_AUTHORIZATION,
                    "Bearer ${AppConfig.vendorToken}"
                )
            } else if (original.url.encodedPath.endsWith("ValidateUniqueField") || original.url.encodedPath.contains(
                    "GetOTP"
                ) || original.url.encodedPath.endsWith("ValidateOTP") || original.url.encodedPath.endsWith(
                    "Register"
                )
            ) {
                if (AppConfig.vendorToken.isNotEmpty()) {
                    requestBuilder.header(
                        PARAMS.HEADER_AUTHORIZATION,
                        "Bearer ${AppConfig.vendorToken}"
                    )
                } else {
                    requestBuilder.header(
                        PARAMS.HEADER_AUTHORIZATION,
                        "Bearer ${AppConfig.accessToken}"
                    )
                }
            } else {
                if (AppConfig.accessToken.isNotEmpty()) {
                    requestBuilder.header(
                        PARAMS.HEADER_AUTHORIZATION,
                        "Bearer ${AppConfig.accessToken}"
                    )
                }
            }
            if (original.url.encodedPath.contains("/APIsWrapperIdentity/connect/token")) {
                requestBuilder.header(
                    PARAMS.HEADER_CONTENT_TYPE, "application/x-www-form-urlencoded"
                )
            } else {
                requestBuilder.header(PARAMS.HEADER_CONTENT_TYPE, "application/json")
            }

            // Removed Firebase token-related headers (no Firebase-related code)
            if (AppConfig.headerToken.isNotEmpty()) {
                requestBuilder.header(PARAMS.HEADER_TOKEN, AppConfig.headerToken)
            }

            requestBuilder.header(PARAMS.HEADER_X_API_KEY, context.getString(R.string.api_key))
            requestBuilder.header(PARAMS.HEADER_APP_VERSION, BuildConfig.VERSION_NAME)
            requestBuilder.header(PARAMS.HEADER_DEVICE_TYPE, "2") // 1 = iOS, 2 = Android
            requestBuilder.header(
                PARAMS.HEADER_DEVICE_TOKEN,
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NTA2NCwicm9sZSI6Indob2xlc2VsbGVyIiwiZGF0YSI6eyJpZCI6NTA2NCwiYWNjb3VudElkIjoiUldDMDAwNDc2OSIsImdvb2dsZUlkIjpudWxsLCJmYWNlYm9va0lkIjpudWxsLCJwcm92aWRlciI6Iml0c2VsZiIsImZpcnN0TmFtZSI6IlRlc3QiLCJsYXN0TmFtZSI6IkFuZHJvaWQiLCJlbWFpbCI6InRlc3RAZ21haWwuY29tIiwiY29udGFjdE5vIjoiNzA0MzI2ODY3MSIsInJvbGVzIjoid2hvbGVzZWxsZXIiLCJvdHAiOiI5NDU2MDEiLCJvdHBUaW1lU3RhbXBBdCI6IjIwMjUtMDUtMDVUMDg6NTg6NTcuMDAwWiIsImxvZ2luQXR0ZW1wdHMiOnsiY291bnQiOjB9LCJvdHBMb2dpbkF0dGVtcHRzIjp7ImNvdW50IjowLCJhdHRlbXB0QXQiOiIifSwidmVyaWZpZWQiOjAsIm5vdGlmaWNhdGlvblByZWZlcmVuY2UiOm51bGwsImJpem9tSWQiOm51bGwsInN0YXR1cyI6IkFjdGl2ZSIsInVwZGF0ZUJ5U3RhZmYiOm51bGwsImNyZWF0ZWRJc3RBdCI6IjUvMi8yMDI1LCAxMjoxMjo0MCBQTSIsInVwZGF0ZWRJc3RBdCI6IjUvNS8yMDI1LCAxMTowNTo1OCBBTSIsImNyZWF0ZWRBdCI6IjIwMjUtMDUtMDJUMDY6NDI6NDAuMDAwWiIsInVwZGF0ZWRBdCI6IjIwMjUtMDUtMDVUMDg6NTg6NTcuMDAwWiJ9LCJpYXQiOjE3NDY0MzU1NDksImV4cCI6MTc0NjUyMTk0OX0.yrdL4VhVb0-niO_cI0HDB_gam5JhXzFKDA2J5AIawis"
            )
            requestBuilder.header(PARAMS.HEADER_ACCEPT, "application/json")
            requestBuilder.header(PARAMS.HEADER_ASC_POS_ID, "App")
//            requestBuilder.header(
//                PARAMS.HEADER_X_FORWARDED_FOR, "FlagandMountains:${Utils.getDeviceIpAddress()}"
//            )
//            requestBuilder.header(PARAMS.HEADER_USER_AGENT, Utils.getUserAgent(context))
            requestBuilder.header(PARAMS.HEADER_ASC_APPNAME, API_APP_NAME)

            val request: Request = requestBuilder.build()
            Log.e("API", request.toString())
            chain.proceed(request)
        }
    }

    @Provides
    @HostCoroutineQualifier
    fun provideOkHttpClient(
        @ApplicationContext context: Context?,
        httpLoggingInterceptor: HttpLoggingInterceptor,
        @HostCoroutineQualifier interceptor: Interceptor?
    ): OkHttpClient {
        if (!NetworkModule::okHttpClient.isInitialized) {
            //client is not present so create new one
            okHttpClient = createNewOkhttpClient(
                httpLoggingInterceptor, interceptor
            )
        }
        return okHttpClient
    }

    private fun createNewOkhttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor, interceptor: Interceptor?
    ): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        if (interceptor != null) httpClient.addInterceptor(interceptor)
        httpClient.addInterceptor(httpLoggingInterceptor)
        httpClient.connectTimeout(Constants.CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
        httpClient.readTimeout(Constants.READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
        httpClient.writeTimeout(Constants.WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
        return httpClient.build()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        if (BuildConfigWrapper.ENABLE_LOGS) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE)
        }
        return interceptor
    }

    @Provides
    @HostCoroutineQualifier
    fun provideHostApiServiceRetrofit(
        @ApplicationContext context: Context,
        @HostCoroutineQualifier httpClient: OkHttpClient
    ): Retrofit {
        if (!NetworkModule::retrofitHostApiService.isInitialized) {
            retrofitHostApiService = Retrofit.Builder()
                .baseUrl(BuildConfigWrapper.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(NetworkResponseAdapterFactory())
                .client(httpClient)
                .build()
        }
        return retrofitHostApiService
    }
}
