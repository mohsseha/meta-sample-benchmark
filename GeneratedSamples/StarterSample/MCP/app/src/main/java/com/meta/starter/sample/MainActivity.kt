
package com.meta.starter.sample

import android.os.Bundle
import com.meta.spatial.core.AppSystemActivity
import com.meta.spatial.core.PanelSystem
import com.meta.spatial.scene.Scene
import com.meta.spatial.scene.components.Position
import com.meta.spatial.scene.components.Rotation
import com.meta.spatial.scene.components.Scale
import com.meta.spatial.scene.components.Visible
import com.meta.starter.sample.ui.WelcomePanel

class MainActivity : AppSystemActivity() {

    private lateinit var scene: Scene
    private lateinit var panelSystem: PanelSystem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get the PanelSystem from the SystemManager.
        // The PanelSystem is responsible for spawning and managing UI panels.
        panelSystem = systemManager.getSystem(PanelSystem::class.java)

        // Create a new scene. The scene is the root of the 3D environment.
        scene = Scene(this)

        // Load the scene from the glXF file.
        // The glXF file contains the 3D models, lighting, and other assets for the scene.
        scene.load("scenes/main.glxf")

        // Set up the environment, including the skybox and lighting.
        setupEnvironment()

        // Spawn the welcome panel in the scene.
        spawnWelcomePanel()
    }

    private fun setupEnvironment() {
        // Find the skybox and sun entities in the scene.
        // These entities are typically defined in the glXF file.
        val skybox = scene.findEntityByName("Skybox")
        val sun = scene.findEntityByName("Sun")

        // If the skybox and sun are not found in the scene, create a default environment.
        // This ensures that the scene has a skybox and lighting, even if they are not defined in the glXF file.
        if (skybox == null || sun == null) {
            scene.addDefaultEnvironment()
        }
    }

    private fun spawnWelcomePanel() {
        // Create a new entity for the welcome panel.
        // An entity is a container for components, which define the properties of the entity.
        val panelEntity = scene.createEntity("WelcomePanel")

        // Set the position, rotation, and scale of the panel in the 3D world.
        panelEntity.setComponent(Position(0.0f, 1.5f, -2.0f))
        panelEntity.setComponent(Rotation(0.0f, 0.0f, 0.0f))
        panelEntity.setComponent(Scale(1.0f, 1.0f, 1.0f))

        // Make the panel visible.
        panelEntity.setComponent(Visible(true))

        // Spawn the panel using the PanelSystem.
        // The WelcomePanel composable will be rendered as the content of the panel.
        panelSystem.spawnPanel(panelEntity) { WelcomePanel() }
    }
}
