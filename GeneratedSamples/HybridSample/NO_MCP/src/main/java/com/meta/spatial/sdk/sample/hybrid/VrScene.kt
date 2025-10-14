
package com.meta.spatial.sdk.sample.hybrid

import androidx.compose.runtime.Composable
import com.meta.spatial.sdk.View
import com.meta.spatial.sdk.compose.SpatialApp
import com.meta.spatial.sdk.sample.hybrid.ui.SharedUI

@Composable
fun VrScene(onToggleMode: () -> Unit) {
    SpatialApp {
        View(
            // This is a placeholder for the 3D model of the panel.
            // In a real application, you would load a 3D model here.
            // For this sample, we are just rendering the shared UI.
        ) {
            SharedUI(onToggleMode)
        }
    }
}
