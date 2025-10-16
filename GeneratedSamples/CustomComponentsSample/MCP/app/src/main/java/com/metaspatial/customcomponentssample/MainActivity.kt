package com.metaspatial.customcomponentssample

import android.os.Bundle
import com.meta.spatialsdk.AppSystemActivity
import com.meta.spatialsdk.ecs.Entity
import com.meta.spatialsdk.scenes.Scene

class MainActivity : AppSystemActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Register the custom component
        SharedColorComponent.register()

        // Register the system
        systemManager.registerSystem(ColorSystem())

        // Create a scene
        val scene = Scene()

        // Create entities with the SharedColorComponent
        val entity1 = scene.createEntity()
        entity1.setComponent(SharedColorComponent(color = 0xFF0000)) // Red

        val entity2 = scene.createEntity()
        entity2.setComponent(SharedColorComponent(color = 0x00FF00)) // Green

        val entity3 = scene.createEntity()
        entity3.setComponent(SharedColorComponent(color = 0x0000FF)) // Blue
    }
}
