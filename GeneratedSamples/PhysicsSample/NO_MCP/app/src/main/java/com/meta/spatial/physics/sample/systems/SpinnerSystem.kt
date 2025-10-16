
package com.meta.spatial.physics.sample.systems

import com.meta.spatial.physics.sample.components.SpinnerComponent
import com.meta.spatial.sdk.ecs.system.System
import com.meta.spatial.sdk.ecs.system.UpdateContext
import com.meta.spatial.sdk.physics.PhysicsComponent
import com.meta.spatial.sdk.query.Query
import com.meta.spatial.sdk.query.QueryBuilder

class SpinnerSystem : System() {
    private lateinit var query: Query

    override fun onStart() {
        query = QueryBuilder()
            .require(SpinnerComponent::class.java)
            .require(PhysicsComponent::class.java)
            .build()
    }

    override fun onUpdate(context: UpdateContext) {
        query.forEach { entity ->
            val physicsComponent = entity.getComponent(PhysicsComponent::class.java)
            // In a real application, you would check for controller input here.
            // For this sample, we'll just apply a torque to simulate a spin.
            physicsComponent.applyTorque(0f, 10f, 0f)
        }
    }
}
