package com.meta.mruksample.surfaceanchoring

import android.os.Bundle
import com.meta.spatial.sdk.AppSystemActivity
import com.meta.spatial.sdk.scene.Scene
import com.meta.spatial.sdk.scene.components.Position
import com.meta.spatial.sdk.scene.components.Visible
import com.meta.spatial.sdk.scene.entities.Model
import com.meta.spatial.sdk.mruk.Mruk
import com.meta.spatial.sdk.mruk.Mruk.Plane

/**
 * This activity demonstrates how to anchor virtual 3D models to physical surfaces.
 *
 * It uses the MRUK APIs to detect horizontal planes in the user's environment and places a virtual cube on each detected plane.
 */
class SurfaceAnchoringActivity : AppSystemActivity() {

    private lateinit var scene: Scene
    private lateinit var mruk: Mruk

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create a new scene
        scene = Scene(this)
        // Create a new MRUK instance
        mruk = Mruk(this)

        // Enable passthrough to see the real world
        scene.enablePassthrough(true)
        // Find the skybox entity and hide it
        val skyboxEntity = scene.query { it.has(com.meta.spatial.sdk.scene.components.Skybox::class.java) }.firstOrNull()
        skyboxEntity?.setComponent(Visible(false))

        // Find all horizontal planes and place a cube on each one
        val planes = mruk.queryPlanes(Plane.Type.HORIZONTAL)
        for (plane in planes) {
            // Create a new cube model
            val cube = Model.fromGltf("models/cube.gltf")
            // Set the position of the cube to the center of the plane
            cube.setComponent(Position(plane.center.x, plane.center.y, plane.center.z))
            // Add the cube to the scene
            scene.add(cube)
        }
    }
}
