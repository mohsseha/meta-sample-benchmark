
package com.meta.spatial.sdk.sample.hybrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.meta.spatial.sdk.sample.hybrid.ui.SharedUI
import com.meta.spatial.sdk.sample.hybrid.ui.theme.HybridSampleTheme

class MainActivity : ComponentActivity() {

    private val isImmersiveMode = mutableStateOf(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HybridSampleTheme {
                App(
                    isImmersiveMode = isImmersiveMode.value,
                    onToggleMode = {
                        isImmersiveMode.value = !isImmersiveMode.value
                    }
                )
            }
        }
    }
}

@Composable
fun App(isImmersiveMode: Boolean, onToggleMode: () -> Unit) {
    if (isImmersiveMode) {
        VrScene(onToggleMode)
    } else {
        SharedUI(onToggleMode)
    }
}
