package com.meta.spatial.sdk.sample.customcomponent.systems

import com.meta.spatial.sdk.ecs.system.System
import com.meta.spatial.sdk.ecs.system.each
import com.meta.spatial.sdk.sample.customcomponent.components.RotatableComponent
import com.meta.spatial.sdk.math.Quat
import com.meta.spatial.sdk.math.Vec3
import com.meta.spatial.sdk.platform.Time
import com.meta.spatial.sdk.scene.Transform

class RotationSystem : System() {
    // Query for entities with both a Transform and a RotatableComponent
    private val query = createQuery(Transform::class.java, RotatableComponent::class.java)

    override fun onUpdate() {
        // Iterate over the entities that match the query
        query.each { entity ->
            val transform = entity.get(Transform::class.java)
            val rotatable = entity.get(RotatableComponent::class.java)

            // Calculate the rotation for this frame
            val rotationAmount = rotatable.rotationSpeed * Time.deltaTime
            val rotation = Quat.fromAngleAxis(rotationAmount, Vec3.UP)

            // Apply the rotation to the entity's transform
            transform.rotation = transform.rotation * rotation
        }
    }
}
