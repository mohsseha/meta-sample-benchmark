package com.meta.physicssample.systems

import com.meta.spatial.sdk.ecs.System
import com.meta.spatial.sdk.ecs.Filter
import com.meta.spatial.sdk.ecs.Entity
import com.meta.spatial.sdk.physics.components.Collidable
import com.meta.spatial.sdk.physics.components.CollisionEvent

class ButtonSystem : System(
    Filter.All(
        Collidable::class.java,
    )
) {
    override fun onUpdate(entities: List<Entity>, a: Float) {
        for (entity in entities) {
            val collisionEvent = entity.getComponent(CollisionEvent::class.java)
            if (collisionEvent != null) {
                // Handle button press logic here
            }
        }
    }
}
