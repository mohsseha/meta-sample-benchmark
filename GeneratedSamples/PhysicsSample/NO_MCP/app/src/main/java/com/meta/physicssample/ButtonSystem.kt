package com.meta.physicssample

import com.meta.spatial.Component
import com.meta.spatial.Entity
import com.meta.spatial.System
import com.meta.spatial.World
import com.meta.spatial.physics.CollisionEvent
import com.meta.spatial.physics.PhysicsBody

class ButtonComponent : Component() {
    var isPressed = false
}

class ButtonSystem : System() {
    private val buttons = mutableListOf<Entity>()

    override fun onEnter(world: World) {
        world.query(ButtonComponent::class.java).forEach { entity ->
            buttons.add(entity)
        }
    }

    override fun onUpdate(world: World, deltaTime: Float) {
        world.events(CollisionEvent::class.java).forEach { event ->
            handleCollision(event)
        }
    }

    private fun handleCollision(event: CollisionEvent) {
        val entityA = event.entityA
        val entityB = event.entityB

        val buttonEntity = if (buttons.contains(entityA)) entityA else if (buttons.contains(entityB)) entityB else return
        val otherEntity = if (buttonEntity == entityA) entityB else entityA

        val buttonComponent = buttonEntity.getComponent(ButtonComponent::class.java) ?: return

        if (event.type == CollisionEvent.CollisionType.START) {
            buttonComponent.isPressed = true
            // Add visual feedback for button press, e.g., change color
            println("Button pressed: ${buttonEntity.id}")
        } else if (event.type == CollisionEvent.CollisionType.END) {
            buttonComponent.isPressed = false
            // Remove visual feedback
            println("Button released: ${buttonEntity.id}")
        }
    }
}
