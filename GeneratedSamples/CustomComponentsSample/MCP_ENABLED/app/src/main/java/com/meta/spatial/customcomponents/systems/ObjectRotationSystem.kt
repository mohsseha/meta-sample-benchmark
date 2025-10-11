package com.meta.spatial.customcomponents.systems

import com.meta.spatial.customcomponents.components.RotatableComponent
import com.meta.spatial.customcomponents.components.SharedSettingsComponent
import com.meta.spatial.sdk.Query
import com.meta.spatial.sdk.System
import com.meta.spatial.sdk.Transform

/**
 * A system that rotates objects that have a RotatableComponent.
 * This system demonstrates how to query for entities with a specific set of components
 * and how to use shared data from another entity to update them.
 */
class ObjectRotationSystem : System() {
    // Create a query that finds the entity with the shared settings
    private val settingsQuery = Query(allOf = setOf(SharedSettingsComponent::class))

    // Create a query that finds all entities that should be rotated
    private val rotatableQuery = Query(allOf = setOf(Transform::class, RotatableComponent::class))

    /**
     * This method is called on every frame update.
     *
     * @param deltaTime The time in seconds since the last frame.
     */
    override fun onUpdate(deltaTime: Float) {
        // Get the shared rotation speed from the settings entity
        val settingsEntity = settingsQuery.firstOrNull() ?: return
        val sharedSettings = settingsEntity.getComponent(SharedSettingsComponent::class)
        val rotationSpeed = sharedSettings.rotationSpeed

        // For each entity that matches the rotatable query, update its rotation
        rotatableQuery.forEach { entity ->
            val transform = entity.getComponent(Transform::class)

            // Rotate the entity around the Y-axis
            transform.rotation.y += rotationSpeed * deltaTime
        }
    }
}