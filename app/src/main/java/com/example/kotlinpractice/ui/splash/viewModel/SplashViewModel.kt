package com.example.kotlinpractice.ui.splash.viewModel

import com.example.kotlinpractice.base.BaseViewModel


class SplashViewModel : BaseViewModel() {

    fun loadData() {
        launchWithHandling {
            print("Loading data...")
            kotlinx.coroutines.delay(1000)
            // Perform your data fetch or logic here
        }
    }
}
