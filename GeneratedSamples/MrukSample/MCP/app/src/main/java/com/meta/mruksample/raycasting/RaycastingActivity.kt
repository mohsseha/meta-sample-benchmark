package com.meta.mruksample.raycasting

import android.os.Bundle
import com.meta.spatial.sdk.AppSystemActivity
import com.meta.spatial.sdk.scene.Scene
import com.meta.spatial.sdk.scene.components.Position
import com.meta.spatial.sdk.scene.components.Visible
import com.meta.spatial.sdk.scene.entities.Model
import com.meta.spatial.sdk.mruk.Mruk

/**
 * This activity demonstrates how to use raycasting to interact with the physical environment.
 *
 * It casts a ray from the center of the screen and places a cube at the intersection point with a physical surface.
 */
class RaycastingActivity : AppSystemActivity() {

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

        // Cast a ray from the center of the screen every frame
        scene.addSystem {
            // Cast a ray from the center of the screen (0.5f, 0.5f)
            val raycastResult = mruk.raycast(0.5f, 0.5f)
            // If the ray intersects with a physical surface, place a cube at the intersection point
            if (raycastResult != null) {
                // Create a new cube model
                val cube = Model.fromGltf("models/cube.gltf")
                // Set the position of the cube to the intersection point
                cube.setComponent(Position(raycastResult.intersectionPoint.x, raycastResult.intersectionPoint.y, raycastResult.intersectionPoint.z))
                // Add the cube to the scene
                scene.add(cube)
            }
        }
    }
}
