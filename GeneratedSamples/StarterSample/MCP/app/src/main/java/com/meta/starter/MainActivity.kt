package com.meta.starter

import android.os.Bundle
import com.meta.spatial.core.SpatialActivity
import com.meta.spatial.scene.PanelConfigOptions
import com.meta.spatial.scene.PanelSceneObject
import com.meta.spatial.math.Vector3

class MainActivity : SpatialActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // The immersive VR experience is enabled by default in SpatialActivity.
        // No specific code is needed here to enable it.

        // Load the main scene
        loadMainScene()

        // Create and show the welcome panel
        showWelcomePanel()
    }

    private fun loadMainScene() {
        // This is where you would load your main 3D scene.
        // The scene would typically be created in the Meta Spatial Editor and exported as a glXF file.
        // For this sample, we will create a simple environment programmatically.
        setupSimpleEnvironment()
    }

    private fun showWelcomePanel() {
        // Create a PanelConfigOptions object to configure the panel
        val config = PanelConfigOptions().apply {
            width = 1.5f // meters
            height = 0.8f // meters
        }

        // Create the PanelSceneObject
        val panel = PanelSceneObject(
            this,
            this,
            PanelActivity::class.java,
            null,
            config
        )

        // Position the panel in front of the user
        panel.transform.position = Vector3(0f, 1.6f, -2f)
    }

    private fun setupSimpleEnvironment() {
        // Create a simple lighting environment
        scene.setLightingEnvironment(
            sunColor = Vector3(1f, 1f, 1f),
            sunDirection = Vector3(0f, -1f, 0f)
        )
    }
}
