package com.meta.physicssample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.meta.spatial.SpatialActivity
import com.meta.spatial.physics.PhysicsSystem

class MainActivity : SpatialActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable physics simulation
        registerSystem(PhysicsSystem())

        // Register custom interaction systems
        registerSystem(ButtonSystem())
        registerSystem(TriggerSystem())
        registerSystem(SpinnerSystem())

        // Load the scene
        loadScene("scenes/physics_scene.glxf")
    }
}
