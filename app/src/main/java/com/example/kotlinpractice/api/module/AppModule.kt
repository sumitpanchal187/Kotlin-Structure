package com.example.kotlinpractice.api.module

import android.content.Context
import android.net.ConnectivityManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal abstract class AppModule {

    companion object {

        @Singleton
        @Provides
        fun providesConnectivityManager(@ApplicationContext context: Context): ConnectivityManager {
            return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        }
    }
}