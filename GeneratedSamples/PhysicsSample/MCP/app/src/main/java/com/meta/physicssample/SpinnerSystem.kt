package com.meta.physicssample

import com.meta.spatial.core.Query
import com.meta.spatial.core.SystemBase
import com.meta.spatial.physics.Physics
import com.meta.spatial.toolkit.Transform

class SpinnerSystem : SystemBase() {
    override fun execute() {
        val query = Query.where { has(SpinnerComponent.id, Physics.id, Transform.id) }

        for (entity in query.eval()) {
            val spinner = entity.getComponent<SpinnerComponent>()
            val physics = entity.getComponent<Physics>()
            val transform = entity.getComponent<Transform>()

            // Check for collision with the user's hands
            // This is a simplified example. A real implementation would use the Interaction SDK
            // to get the user's hand position and check for collision.
            if (physics.isColliding()) {
                spinner.spinning = true
                // Apply a torque to the spinner to make it spin
                physics.applyTorque(0f, 10f, 0f)
            } else {
                spinner.spinning = false
            }

            entity.setComponent(spinner)
        }
    }
}
