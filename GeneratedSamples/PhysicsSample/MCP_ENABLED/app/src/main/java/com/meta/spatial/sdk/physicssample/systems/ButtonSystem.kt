
package com.meta.spatial.sdk.physicssample.systems

import com.meta.spatial.sdk.core.world.System
import com.meta.spatial.sdk.core.world.World
import com.meta.spatial.sdk.core.world.query
import com.meta.spatial.sdk.physics.CollisionBegan
import com.meta.spatial.sdk.physics.CollisionEnded
import com.meta.spatial.sdk.physics.PhysicsBody
import com.meta.spatial.sdk.core.common.Update
import com.meta.spatial.sdk.core.entity.Entity

data class Button(var isPressed: Boolean = false)

class ButtonSystem : System() {
    private val buttons = query(Button::class, PhysicsBody::class)

    override fun onReceive(world: World, event: Any) {
        when (event) {
            is Update -> {
                buttons.forEach { (button, physicsBody), entity ->
                    // Button logic goes here
                }
            }
            is CollisionBegan -> {
                buttons.forEach { (button, physicsBody), entity ->
                    if (event.entityA == entity || event.entityB == entity) {
                        button.isPressed = true
                        println("Button pressed")
                    }
                }
            }
            is CollisionEnded -> {
                buttons.forEach { (button, physicsBody), entity ->
                    if (event.entityA == entity || event.entityB == entity) {
                        button.isPressed = false
                        println("Button released")
                    }
                }
            }
        }
    }
}
