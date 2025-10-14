package com.meta.physicssample

import com.meta.spatial.Component
import com.meta.spatial.Entity
import com.meta.spatial.System
import com.meta.spatial.World
import com.meta.spatial.physics.Constraint
import com.meta.spatial.physics.PhysicsBody

class TriggerComponent : Component() {
    var isPulled = false
    var initialPosition: Float = 0.0f
}

class TriggerSystem : System() {
    private val triggers = mutableListOf<Entity>()

    override fun onEnter(world: World) {
        world.query(TriggerComponent::class.java).forEach { entity ->
            triggers.add(entity)
            val triggerComponent = entity.getComponent(TriggerComponent::class.java)
            val physicsBody = entity.getComponent(PhysicsBody::class.java)
            if (triggerComponent != null && physicsBody != null) {
                // Assuming the trigger moves along the Z axis
                triggerComponent.initialPosition = physicsBody.transform.translation.z

                // Add a constraint to limit the trigger's movement
                val constraint = Constraint.limitTranslation(
                    physicsBody,
                    floatArrayOf(0f, 0f, -0.1f), // Min translation
                    floatArrayOf(0f, 0f, 0f)      // Max translation
                )
                world.addConstraint(constraint)
            }
        }
    }

    override fun onUpdate(world: World, deltaTime: Float) {
        triggers.forEach { entity ->
            val triggerComponent = entity.getComponent(TriggerComponent::class.java) ?: return@forEach
            val physicsBody = entity.getComponent(PhysicsBody::class.java) ?: return@forEach

            val currentPosition = physicsBody.transform.translation.z
            val isPulled = currentPosition < triggerComponent.initialPosition - 0.09f

            if (isPulled != triggerComponent.isPulled) {
                triggerComponent.isPulled = isPulled
                if (isPulled) {
                    println("Trigger pulled: ${entity.id}")
                } else {
                    println("Trigger released: ${entity.id}")
                }
            }
        }
    }
}
