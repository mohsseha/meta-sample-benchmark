package com.meta.physicssample

import com.meta.spatial.Component
import com.meta.spatial.Entity
import com.meta.spatial.System
import com.meta.spatial.World
import com.meta.spatial.physics.Constraint
import com.meta.spatial.physics.PhysicsBody

class SpinnerComponent : Component() {
    var currentSpeed: Float = 0.0f
}

class SpinnerSystem : System() {
    private val spinners = mutableListOf<Entity>()

    override fun onEnter(world: World) {
        world.query(SpinnerComponent::class.java).forEach { entity ->
            spinners.add(entity)
            val physicsBody = entity.getComponent(PhysicsBody::class.java)
            if (physicsBody != null) {
                // Add a constraint to allow rotation only around the Y axis
                val constraint = Constraint.limitRotation(
                    physicsBody,
                    floatArrayOf(0f, -Float.MAX_VALUE, 0f), // Min rotation
                    floatArrayOf(0f, Float.MAX_VALUE, 0f)   // Max rotation
                )
                world.addConstraint(constraint)
            }
        }
    }

    override fun onUpdate(world: World, deltaTime: Float) {
        spinners.forEach { entity ->
            val spinnerComponent = entity.getComponent(SpinnerComponent::class.java) ?: return@forEach
            val physicsBody = entity.getComponent(PhysicsBody::class.java) ?: return@forEach

            val angularVelocity = physicsBody.angularVelocity
            spinnerComponent.currentSpeed = angularVelocity.y

            // You can add logic here to react to the spinner's speed
        }
    }
}
