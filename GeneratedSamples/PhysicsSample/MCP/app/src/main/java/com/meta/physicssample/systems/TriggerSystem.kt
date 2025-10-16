package com.meta.physicssample.systems

import com.meta.spatial.sdk.ecs.System
import com.meta.spatial.sdk.ecs.Filter
import com.meta.spatial.sdk.ecs.Entity
import com.meta.spatial.sdk.physics.components.Collidable

class TriggerSystem : System(
    Filter.All(
        Collidable::class.java,
    )
) {
    override fun onUpdate(entities: List<Entity>, a: Float) {
        for (entity in entities) {
            // Handle trigger logic here
        }
    }
}
