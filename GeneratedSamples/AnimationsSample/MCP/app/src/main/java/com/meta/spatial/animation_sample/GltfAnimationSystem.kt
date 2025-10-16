package com.meta.spatial.animation_sample

import com.meta.spatial.sdk.SystemBase
import com.meta.spatial.sdk.animation.Animated
import com.meta.spatial.sdk.core.Entity
import com.meta.spatial.sdk.core.Transform
import com.meta.spatial.sdk.core.scene
import com.meta.spatial.sdk.mesh.Mesh

class GltfAnimationSystem : SystemBase() {

    private lateinit var animatedEntity: Entity

    override fun onEnter() {
        // It's assumed that a utility function like `loadGltf` exists.
        // This function would load the glTF file and return the root entity.
        animatedEntity = scene.loadGltf("models/animated_cube.gltf")

        // Position the entity in front of the user.
        animatedEntity.getComponent(Transform::class.java)?.let {
            it.position.z = -2.0f
            animatedEntity.setComponent(it)
        }

        // Play the animation.
        animatedEntity.getComponent(Mesh::class.java)?.let {
            animatedEntity.setComponent(Animated(System.currentTimeMillis()))
        }
    }
}
