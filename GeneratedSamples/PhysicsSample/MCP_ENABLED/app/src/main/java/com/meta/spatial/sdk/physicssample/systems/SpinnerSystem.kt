
package com.meta.spatial.sdk.physicssample.systems

import com.meta.spatial.sdk.core.world.System
import com.meta.spatial.sdk.core.world.World
import com.meta.spatial.sdk.core.world.query
import com.meta.spatial.sdk.physics.PhysicsBody
import com.meta.spatial.sdk.core.common.Update
import com.meta.spatial.sdk.physics.AngularVelocity

data class Spinner(var speed: Float)

class SpinnerSystem : System() {
    private val spinners = query(Spinner::class, PhysicsBody::class)

    override fun onReceive(world: World, event: Any) {
        when (event) {
            is Update -> {
                spinners.forEach { (spinner, physicsBody), entity ->
                    physicsBody.angularVelocity = AngularVelocity(0f, spinner.speed, 0f)
                }
            }
        }
    }
}
