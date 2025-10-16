package com.meta.spatial.animation_sample

import com.meta.spatial.ecs.Entity
import com.meta.spatial.ecs.Scene
import com.meta.spatial.ecs.System
import com.meta.spatial.ecs.Transform
import com.meta.spatial.math.Quaternion
import com.meta.spatial.math.Vector3

class ReusableAnimationDriver(private val scene: Scene) : System() {

    private val animatedEntities = mutableListOf<Entity>()

    fun addAnimation(entity: Entity) {
        animatedEntities.add(entity)
    }

    override fun onUpdate(deltaTime: Float) {
        for (entity in animatedEntities) {
            val transform = entity.getComponent(Transform::class.java)
            val rotation = Quaternion.fromAxisAngle(Vector3.UP, 45.0f * deltaTime)
            transform.rotation = rotation * transform.rotation
        }
    }
}
