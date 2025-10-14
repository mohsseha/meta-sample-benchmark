package com.meta.animationsample

import android.os.Bundle
import com.meta.spatial.SpatialActivity
import com.meta.spatial.World

class MainActivity : SpatialActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create the drone controller and set up the scene
        val droneController = DroneController()
        droneController.setup(world)
    }
}