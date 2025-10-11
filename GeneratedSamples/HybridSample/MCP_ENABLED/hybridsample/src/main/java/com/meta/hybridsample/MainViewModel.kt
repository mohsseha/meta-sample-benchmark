package com.meta.hybridsample

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _isImmersiveMode = mutableStateOf(false)
    val isImmersiveMode = _isImmersiveMode

    fun toggleMode() {
        _isImmersiveMode.value = !_isImmersiveMode.value
    }
}
