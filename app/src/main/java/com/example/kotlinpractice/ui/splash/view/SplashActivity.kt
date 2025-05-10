package com.example.kotlinpractice.ui.splash.view

import android.annotation.SuppressLint
import android.content.Intent
import com.example.kotlinpractice.ui.login.view.LoginActivity
import com.example.kotlinpractice.ui.splash.viewModel.SplashViewModel
import com.example.kotlinpractice.base.BaseActivity
import com.example.kotlinpractice.databinding.SplashScreenBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<SplashScreenBinding, SplashViewModel>(
    SplashScreenBinding::class.java,
    SplashViewModel::class
) {
    @SuppressLint("SetTextI18n")
    override fun onCreate() {
        super.onCreate()
        binding.root.postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 2000)
    }
}