package com.meta.spatial.animation_sample

import com.meta.spatial.sdk.SystemBase
import com.meta.spatial.sdk.core.Entity
import com.meta.spatial.sdk.core.Transform
import com.meta.spatial.sdk.core.scene
import com.meta.spatial.sdk.math.Vector3
import kotlin.math.sin

class ProceduralAnimationSystem : SystemBase() {

    private lateinit var animatedEntity: Entity
    private var elapsedTime = 0.0f

    override fun onEnter() {
        // Create an entity to animate.
        animatedEntity = scene.createEntity()

        // Add a transform to the entity and position it.
        val transform = Transform()
        transform.position = Vector3(0.0f, 1.0f, -2.0f)
        animatedEntity.setComponent(transform)

        // Add a mesh to the entity to make it visible.
        // It's assumed that a utility function like `createCube` exists.
        animatedEntity.setComponent(scene.createCube())
    }

    override fun onUpdate(deltaTime: Float) {
        elapsedTime += deltaTime

        // Animate the entity's position.
        animatedEntity.getComponent(Transform::class.java)?.let {
            it.position.y = 1.0f + sin(elapsedTime)
            animatedEntity.setComponent(it)
        }
    }
}
