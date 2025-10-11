
package com.meta.spatial.sdk.physicssample.systems

import com.meta.spatial.sdk.core.world.System
import com.meta.spatial.sdk.core.world.World
import com.meta.spatial.sdk.core.world.query
import com.meta.spatial.sdk.physics.PhysicsBody
import com.meta.spatial.sdk.core.common.Update
import com.meta.spatial.sdk.physics.Constraint

data class Trigger(var isPulled: Boolean = false, val maxDistance: Float)

class TriggerSystem : System() {
    private val triggers = query(Trigger::class, PhysicsBody::class, Constraint::class)

    override fun onReceive(world: World, event: Any) {
        when (event) {
            is Update -> {
                triggers.forEach { (trigger, physicsBody, constraint), entity ->
                    // Trigger logic goes here
                }
            }
        }
    }
}
