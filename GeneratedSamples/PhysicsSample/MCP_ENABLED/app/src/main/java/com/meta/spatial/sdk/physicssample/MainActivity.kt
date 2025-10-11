
package com.meta.spatial.sdk.physicssample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.meta.spatial.sdk.core.common.Init
import com.meta.spatial.sdk.core.common.Shutdown
import com.meta.spatial.sdk.core.common.Update
import com.meta.spatial.sdk.core.world.World
import com.meta.spatial.sdk.core.world.createWorld
import com.meta.spatial.sdk.physics.PhysicsSystem
import com.meta.spatial.sdk.physicssample.systems.ButtonSystem
import com.meta.spatial.sdk.physicssample.systems.SpinnerSystem
import com.meta.spatial.sdk.physicssample.systems.TriggerSystem
import com.meta.spatial.sdk.scene.SceneSystem
import com.meta.spatial.sdk.scene.loadScene

class MainActivity : AppCompatActivity() {

    private lateinit var world: World

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create the world
        world = createWorld()

        // Add the necessary systems
        world.addSystem(SceneSystem(this))
        world.addSystem(PhysicsSystem())
        world.addSystem(ButtonSystem())
        world.addSystem(TriggerSystem())
        world.addSystem(SpinnerSystem())

        // Initialize the world
        world.send(Init)

        // Load the scene
        world.send(loadScene("scenes/physics_sample.glxf"))
    }

    override fun onResume() {
        super.onResume()
        // The simulation will start updating once the activity is resumed
    }

    override fun onPause() {
        super.onPause()
        // The simulation will stop updating when the activity is paused
    }

    override fun onDestroy() {
        super.onDestroy()
        world.send(Shutdown)
    }

    private fun gameLoop() {
        while (true) {
            world.send(Update)
        }
    }
}
