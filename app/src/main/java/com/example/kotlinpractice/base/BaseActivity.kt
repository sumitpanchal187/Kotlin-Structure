package com.example.kotlinpractice.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.example.kotlinpractice.R
import kotlin.reflect.KClass

abstract class BaseActivity<VB : ViewBinding, VM : ViewModel>(
    private val bindingClass: Class<VB>,
    private val viewModelClass: KClass<VM>
) : AppCompatActivity() {

    protected lateinit var binding: VB
    protected lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setBackgroundDrawableResource(R.drawable.app_bg)

        binding = inflateBinding()
        setContentView(binding.root)

        viewModel = viewModelProvider(viewModelClass)
        onCreate()
    }

    /**
     * Called after binding and ViewModel are ready.
     * You can override this in child activity to do your setup.
     */
    open fun onCreate() {}

    /**
     * Utility to inflate view binding using reflection
     */
    @Suppress("UNCHECKED_CAST")
    private fun inflateBinding(): VB {
        val method = bindingClass.getMethod("inflate", android.view.LayoutInflater::class.java)
        return method.invoke(null, layoutInflater) as VB
    }

    /**
     * Utility to create ViewModel
     */
    private fun viewModelProvider(viewModelClass: KClass<VM>): VM {
        return androidx.lifecycle.ViewModelProvider(this)[viewModelClass.java]
    }
}
