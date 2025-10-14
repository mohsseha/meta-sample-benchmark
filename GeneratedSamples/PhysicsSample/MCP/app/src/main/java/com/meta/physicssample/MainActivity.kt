package com.meta.physicssample

import android.os.Bundle
import com.meta.spatial.core.AppSystemActivity
import com.meta.spatial.physics.PhysicsFeature

class MainActivity : AppSystemActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Register custom components
        componentManager.registerComponent<ButtonComponent>(ButtonComponent.Companion)
        componentManager.registerComponent<TriggerComponent>(TriggerComponent.Companion)
        componentManager.registerComponent<SpinnerComponent>(SpinnerComponent.Companion)

        // Register custom systems
        systemManager.registerSystem(ButtonSystem())
        systemManager.registerSystem(TriggerSystem())
        systemManager.registerSystem(SpinnerSystem())

        // Add the physics feature
        addFeature(PhysicsFeature())

        // Load the scene
        glXFManager.load("scenes/scene.glxf")
    }
}
