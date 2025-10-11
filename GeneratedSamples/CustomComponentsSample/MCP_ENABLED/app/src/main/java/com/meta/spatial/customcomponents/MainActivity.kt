package com.meta.spatial.customcomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.meta.spatial.customcomponents.components.RotatableComponent
import com.meta.spatial.customcomponents.components.SharedSettingsComponent
import com.meta.spatial.customcomponents.systems.ObjectRotationSystem
import com.meta.spatial.sdk.Entity
import com.meta.spatial.sdk.Scene
import com.meta.spatial.sdk.Transform
import com.meta.spatial.sdk.Vector3
import com.meta.spatial.ui.theme.SpatialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpatialTheme {
                // The main scene for our application
                val scene = Scene()

                // Create a single entity to hold the shared settings
                val settingsEntity = Entity()
                settingsEntity.addComponent(SharedSettingsComponent(rotationSpeed = 0.5f))
                scene.addEntity(settingsEntity)

                // Create multiple entities that will be rotated
                createRotatingObject(scene, Vector3(-2.0f, 0.0f, -5.0f))
                createRotatingObject(scene, Vector3(2.0f, 0.0f, -5.0f))
                createRotatingObject(scene, Vector3(0.0f, 2.0f, -5.0f))

                // Add the rotation system to the scene
                scene.addSystem(ObjectRotationSystem())
            }
        }
    }

    private fun createRotatingObject(scene: Scene, position: Vector3) {
        val entity = Entity()
        entity.addComponent(Transform(position = position))
        entity.addComponent(RotatableComponent())
        scene.addEntity(entity)
    }
}