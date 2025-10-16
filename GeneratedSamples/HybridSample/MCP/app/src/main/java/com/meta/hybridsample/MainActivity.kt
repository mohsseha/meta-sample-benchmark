package com.meta.hybridsample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.meta.hybridsample.ui.MainViewModel
import com.meta.hybridsample.ui.composables.HybridSampleApp
import com.meta.hybridsample.ui.theme.HybridSampleTheme
import com.meta.spatial.core.AppSystemActivity
import com.meta.spatial.core.PanelActivity
import com.meta.spatial.core.SpatialActivity
import com.meta.spatial.core.immersive

class MainActivity : AppSystemActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (viewModel.isImmersive.value) {
            startImmersive()
        } else {
            startPanel()
        }
    }

    private fun startPanel() {
        setContent {
            HybridSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HybridSampleApp(viewModel) {
                        viewModel.toggleImmersive()
                        startImmersive()
                    }
                }
            }
        }
    }

    private fun startImmersive() {
        immersive {
            // Placeholder for the immersive scene
            // In a real application, you would render the UI to a texture
            // and display it on a quad in the 3D scene.
            // For now, we will just show the same UI as in panel mode.
            setContent {
                HybridSampleTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        HybridSampleApp(viewModel) {
                            viewModel.toggleImmersive()
                            startPanel()
                        }
                    }
                }
            }
        }
    }
}
