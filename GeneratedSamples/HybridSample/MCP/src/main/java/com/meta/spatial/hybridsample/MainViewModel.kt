
package com.meta.spatial.hybridsample

import androidx.lifecycle.ViewModel
import com.meta.spatial.sdk.Mode
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {

    private val _currentMode = MutableStateFlow(Mode.PANEL)
    val currentMode: StateFlow<Mode> = _currentMode

    fun onModeSwitched(newMode: Mode) {
        _currentMode.value = newMode
    }
}
