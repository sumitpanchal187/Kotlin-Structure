package com.example.kotlinpractice.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    // Loading state observable
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    // Error message observable
    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    // Common coroutine exception handler
    protected val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _isLoading.value = false
        _errorMessage.value = throwable.localizedMessage ?: "Unknown error occurred"
    }

    /**
     * Launch a coroutine with built-in loading and error handling
     */
    protected fun launchWithHandling(
        showLoading: Boolean = true,
        block: suspend () -> Unit
    ) {
        viewModelScope.launch(exceptionHandler) {
            try {
                if (showLoading) _isLoading.value = true
                block()
            } finally {
                if (showLoading) _isLoading.value = false
            }
        }
    }

    /**
     * Clear error message after shown to user
     */
    fun clearError() {
        _errorMessage.value = null
    }
}
