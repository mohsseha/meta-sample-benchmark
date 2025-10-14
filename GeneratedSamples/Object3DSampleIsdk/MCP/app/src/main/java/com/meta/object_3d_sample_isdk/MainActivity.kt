
package com.meta.object_3d_sample_isdk

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.meta.object_3d_sample_isdk.ui.Object3DSampleIsdkTheme
import com.meta.object_3d_sample_isdk.ObjectSelectionUI

import com.meta.spatial.sdk.Scene
import com.meta.spatial.sdk.compose.Compositor
import com.meta.spatial.sdk.compose.SpatialUI

class MainActivity : ComponentActivity() {
    private lateinit var compositor: Compositor
    private lateinit var spatialUI: SpatialUI
    lateinit var scene: Scene

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compositor = Compositor.create(this)
        spatialUI = SpatialUI(this, compositor)
        scene = Scene.create(this, "scenes/scene.glxf")
        compositor.scene = scene

        // Add a skybox to the scene
        scene.skybox = "scenes/skybox.png"

        // Add a light to the scene
        val light = scene.createEntity("Light")
        light.getOrCreateComponent(com.meta.spatial.sdk.components.Light::class.java)
        light.transform.position = floatArrayOf(0.0f, 5.0f, 0.0f)

        // Create the UI panel
        val uiEntity = scene.createEntity("ObjectSelectionUI")
        val panel = uiEntity.getOrCreateComponent(com.meta.spatial.sdk.components.Panel::class.java)
        panel.width = 1.2f
        panel.height = 0.8f
        uiEntity.transform.position = floatArrayOf(0.0f, 1.5f, -2.0f)

        spatialUI.registerPanel("ObjectSelectionUI") {
            Object3DSampleIsdkTheme {
                ObjectSelectionUI(spatialUI)
            }
        }
    }
}
