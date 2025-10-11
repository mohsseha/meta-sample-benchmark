package com.meta.hybridsample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.meta.hybridsample.scene.AppScene
import com.meta.hybridsample.ui.HybridAppPanel
import com.meta.xr.vrshell.panel.PanelActivity

class MainActivity : PanelActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setContent {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                HybridAppPanel(
                    isImmersiveMode = viewModel.isImmersiveMode.value,
                    onSwitchMode = {
                        if (viewModel.isImmersiveMode.value) {
                            // Request to switch to panel mode
                            requestPanelMode()
                        } else {
                            // Request to switch to immersive mode
                            requestImmersiveMode()
                        }
                        viewModel.toggleMode()
                    }
                )
            }
        }
    }

    override fun createImmersiveScene() = AppScene(this)
}
