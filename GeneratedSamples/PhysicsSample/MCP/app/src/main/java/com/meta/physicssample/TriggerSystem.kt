package com.meta.physicssample

import com.meta.spatial.core.Query
import com.meta.spatial.core.SystemBase
import com.meta.spatial.physics.Physics
import com.meta.spatial.toolkit.Transform

class TriggerSystem : SystemBase() {
    override fun execute() {
        val query = Query.where { has(TriggerComponent.id, Physics.id, Transform.id) }

        for (entity in query.eval()) {
            val trigger = entity.getComponent<TriggerComponent>()
            val physics = entity.getComponent<Physics>()
            val transform = entity.getComponent<Transform>()

            // Check for collision with the user's hands
            // This is a simplified example. A real implementation would use the Interaction SDK
            // to get the user's hand position and check for collision.
            if (physics.isColliding()) {
                trigger.pulled = true
                // Apply a force to the trigger to simulate it being pulled
                physics.applyForce(0f, 0f, 10f)
            } else {
                trigger.pulled = false
            }

            entity.setComponent(trigger)
        }
    }
}
