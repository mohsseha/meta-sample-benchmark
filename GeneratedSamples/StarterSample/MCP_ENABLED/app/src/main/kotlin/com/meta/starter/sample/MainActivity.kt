package com.meta.starter.sample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.meta.starter.sample.ui.theme.StarterSampleTheme
import com.meta.spatial.SpatialActivity
import com.meta.spatial.scene.*
import com.meta.spatial.toolkit.ToolkitFeature

class MainActivity : SpatialActivity() {
    private lateinit var toolkit: ToolkitFeature
    private lateinit var scene: Scene

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the ToolkitFeature. This is the main entry point for the Spatial SDK.
        toolkit = ToolkitFeature(this)
        // Get the main scene from the toolkit.
        scene = toolkit.scene

        // Set up the scene environment with lighting and a skybox.
        setupScene(this, scene)

        // Create the welcome panel and add it to the scene.
        createWelcomePanel()

        // Set the content to be an empty composable, as the UI is rendered in the 3D scene.
        setContent {}
    }

    private fun createWelcomePanel() {
        // Define the configuration for the panel.
        val panelConfig = PanelConfigOptions(
            shapeConfig = PanelShapeConfig(
                width = 2.0f, // meters
                height = 1.0f, // meters
                cornerRadius = 0.1f
            ),
        )

        // Create the panel scene object.
        val welcomePanel = PanelSceneObject(
            scene = scene,
            spatialContext = this,
            config = panelConfig
        )

        // Set the composable content for the panel.
        welcomePanel.setComposePanel {
            StarterSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WelcomePanel()
                }
            }
        }

        // Position the panel in front of the user.
        welcomePanel.transform.position = Vector3(0.0f, 1.5f, -2.0f)

        // Add the panel to the scene.
        scene.addObject(welcomePanel)
    }
}

@Composable
fun WelcomePanel(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Starter Sample",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "This is a basic VR application built with the Meta Spatial SDK.",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomePanelPreview() {
    StarterSampleTheme {
        WelcomePanel()
    }
}
