package com.meta.spatial.sdk.sample.customcomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.meta.spatial.sdk.Scene
import com.meta.spatial.sdk.math.Vec3
import com.meta.spatial.sdk.scene.Appearance
import com.meta.spatial.sdk.scene.Transform
import com.meta.spatial.sdk.scene.createEntity
import com.meta.spatial.sdk.sample.customcomponent.components.RotatableComponent
import com.meta.spatial.sdk.sample.customcomponent.systems.RotationSystem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create the scene
        val scene = Scene(this)

        // Add the rotation system to the scene
        scene.addSystem(RotationSystem())

        // Create a cube entity with a RotatableComponent
        createEntity(scene) {
            add(Transform(position = Vec3(-1.0f, 1.0f, -3.0f)))
            add(Appearance.DEFAULT_CUBE)
            add(RotatableComponent(rotationSpeed = 0.5f))
        }

        // Create another cube entity with a different rotation speed
        createEntity(scene) {
            add(Transform(position = Vec3(1.0f, 1.0f, -3.0f)))
            add(Appearance.DEFAULT_CUBE)
            add(RotatableComponent(rotationSpeed = 1.5f))
        }

        setContentView(scene.renderView)
    }
}
