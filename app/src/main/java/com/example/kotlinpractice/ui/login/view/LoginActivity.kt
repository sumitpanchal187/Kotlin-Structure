package com.example.kotlinpractice.ui.login.view

import android.os.Bundle
import com.example.kotlinpractice.ui.login.viewModel.LoginViewModel
import com.example.kotlinpractice.base.BaseActivity
import com.example.kotlinpractice.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(
    ActivityLoginBinding::class.java,
    LoginViewModel::class
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}