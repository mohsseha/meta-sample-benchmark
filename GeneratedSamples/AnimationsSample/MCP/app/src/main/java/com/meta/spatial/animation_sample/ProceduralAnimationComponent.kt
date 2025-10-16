package com.meta.spatial.animation_sample

import com.meta.spatial.ecs.Component
import com.meta.spatial.ecs.Transform
import com.meta.spatial.math.Vector3

class ProceduralAnimationComponent : Component() {

    private var time = 0.0f

    override fun onUpdate(deltaTime: Float) {
        time += deltaTime
        val transform = entity.getComponent(Transform::class.java)
        transform.translation = Vector3(
            transform.translation.x,
            1.0f + Math.sin(time.toDouble()).toFloat() * 0.5f,
            transform.translation.z
        )
    }
}
