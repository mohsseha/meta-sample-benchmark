package com.meta.physicssample

import com.meta.spatial.core.Query
import com.meta.spatial.core.SystemBase
import com.meta.spatial.physics.Physics
import com.meta.spatial.toolkit.Transform

class ButtonSystem : SystemBase() {
    override fun execute() {
        val query = Query.where { has(ButtonComponent.id, Physics.id, Transform.id) }

        for (entity in query.eval()) {
            val button = entity.getComponent<ButtonComponent>()
            val physics = entity.getComponent<Physics>()
            val transform = entity.getComponent<Transform>()

            // Check for collision with the user's hands
            // This is a simplified example. A real implementation would use the Interaction SDK
            // to get the user's hand position and check for collision.
            if (physics.isColliding()) {
                button.pressed = true
                // Apply a force to the button to simulate it being pressed
                physics.applyForce(0f, -10f, 0f)
            } else {
                button.pressed = false
            }

            entity.setComponent(button)
        }
    }
}
