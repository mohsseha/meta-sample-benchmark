
package com.meta.spatial.physics.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.meta.spatial.physics.sample.systems.ButtonSystem
import com.meta.spatial.physics.sample.systems.SpinnerSystem
import com.meta.spatial.physics.sample.systems.TriggerSystem
import com.meta.spatial.sdk.MetaSpatial
import com.meta.spatial.sdk.Scene
import com.meta.spatial.sdk.ecs.World
import com.meta.spatial.sdk.physics.PhysicsSystem

class MainActivity : AppCompatActivity() {
    private lateinit var world: World

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the Meta Spatial SDK
        MetaSpatial.initialize(this)

        // Create a new world
        world = World()

        // Add the physics system
        world.addSystem(PhysicsSystem())

        // Add our custom systems
        world.addSystem(ButtonSystem())
        world.addSystem(TriggerSystem())
        world.addSystem(SpinnerSystem())

        // Load the scene
        val scene = Scene.load("scenes/physics_scene.glxf")
        world.addScene(scene)
    }

    override fun onResume() {
        super.onResume()
        world.resume()
    }

    override fun onPause() {
        super.onPause()
        world.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        world.destroy()
    }
}
