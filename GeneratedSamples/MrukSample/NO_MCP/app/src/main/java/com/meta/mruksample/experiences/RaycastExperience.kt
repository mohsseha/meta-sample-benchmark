package com.meta.mruksample.experiences

import android.content.Context
import com.meta.spatial.sdk.base.raycast.Raycast
import com.meta.spatial.sdk.base.raycast.RaycastHit
import com.meta.spatial.sdk.scene.entities.SpatialEntity

class RaycastExperience(private val context: Context) : Experience {

    override fun start() {
        // In a real app, you would get the ray from a controller or head pose
        val origin = floatArrayOf(0f, 0f, 0f)
        val direction = floatArrayOf(0f, 0f, -1f)
        val ray = Raycast(origin, direction)

        val hit: RaycastHit? = ray.cast()
        hit?.let {
            val entity = SpatialEntity()
            // entity.model = "models/cube.gltf"
            entity.position = it.point
            // Add the entity to the scene
        }
    }

    override fun stop() {
        // Clean up resources
    }
}
