package com.meta.spatial.sdk.sample.customcomponent.components

import com.meta.spatial.sdk.ecs.component.Component
import com.meta.spatial.sdk.ecs.component.ComponentDefinition
import com.meta.spatial.sdk.ecs.component.IComponent

// Define the custom component data structure
data class RotatableComponent(var rotationSpeed: Float = 1.0f) : IComponent {
    companion object : ComponentDefinition() {
        // Register the component with the ECS
        init {
            register(RotatableComponent::class.java)
        }
    }
}
