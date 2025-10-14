package com.meta.mruksample.experiences

import android.content.Context
import com.meta.spatial.sdk.base.Singleton
import com.meta.spatial.sdk.mruk.MRUK
import com.meta.spatial.sdk.mruk.Scene
import com.meta.spatial.sdk.mruk.Surface
import com.meta.spatial.sdk.scene.entities.SpatialEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SurfaceAnchorExperience(private val context: Context) : Experience {

    private val mruk = MRUK.create(context)
    private var scene: Scene? = null

    override fun start() {
        CoroutineScope(Dispatchers.Main).launch {
            scene = mruk.getCurrentScene()
            scene?.let {
                val surfaces = it.getSurfaces()
                placeObjectsOnSurfaces(surfaces)
            }
        }
    }

    private fun placeObjectsOnSurfaces(surfaces: List<Surface>) {
        for (surface in surfaces) {
            val entity = SpatialEntity()
            // In a real app, you would load a model from the assets
            // entity.model = "models/cube.gltf"
            entity.position = surface.getCenter()
            // Add the entity to the scene
        }
    }

    override fun stop() {
        // Clean up resources
    }
}
