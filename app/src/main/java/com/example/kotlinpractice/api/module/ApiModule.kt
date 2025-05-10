package com.example.kotlinpractice.api.module

import com.example.kotlinpractice.api.ApiService
import com.example.kotlinpractice.api.module.qualifier.HostCoroutineQualifier
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApiModule {
    @Provides
    @Singleton
    @HostCoroutineQualifier
    fun provideHostApiService(@HostCoroutineQualifier retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}