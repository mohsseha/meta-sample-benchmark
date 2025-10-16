package com.meta.physicssample.systems

import com.meta.spatial.sdk.ecs.System
import com.meta.spatial.sdk.ecs.Filter
import com.meta.spatial.sdk.ecs.Entity
import com.meta.spatial.sdk.physics.components.Collidable

class SpinnerSystem : System(
    Filter.All(
        Collidable::class.java,
    )
) {
    override fun onUpdate(entities: List<Entity>, a: Float) {
        for (entity in entities) {
            // Handle spinner logic here
        }
    }
}
