
package com.meta.spatial.hybridsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.meta.spatial.sdk.Mode
import com.meta.spatial.sdk.SpatialActivity

class MainActivity : SpatialActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = MainViewModel()

        setContent {
            HybridSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val currentMode = mainViewModel.currentMode.collectAsState()
                    SharedUI(
                        currentMode = currentMode.value,
                        onSwitchMode = {
                            if (currentMode.value == Mode.PANEL) {
                                switchToMode(Mode.IMMERSIVE)
                            } else {
                                switchToMode(Mode.PANEL)
                            }
                        }
                    )
                }
            }
        }
    }

    override fun onModeSwitched(newMode: Mode) {
        mainViewModel.onModeSwitched(newMode)
    }
}

@Composable
fun SharedUI(currentMode: Mode, onSwitchMode: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Current Mode: ${currentMode.name}")
        Button(onClick = onSwitchMode) {
            Text(text = "Switch to ${if (currentMode == Mode.PANEL) Mode.IMMERSIVE.name else Mode.PANEL.name}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HybridSampleTheme {
        SharedUI(currentMode = Mode.PANEL, onSwitchMode = {})
    }
}

object HybridSampleTheme {
    @Composable
    operator fun invoke(content: @Composable () -> Unit) {
        MaterialTheme(
            content = content
        )
    }
}
