
package com.meta.animationsample

import android.animation.ValueAnimator
import com.meta.spatial.Entity
import com.meta.spatial.World
import com.meta.spatial.gltf.GltfComponent

/**
 * A controller that creates a drone entity and adds animation components to it.
 */
class DroneController {

    fun setup(world: World) {
        // Create the drone entity
        val drone = Entity()
        drone.addComponent(GltfComponent("models/drone.gltf"))
        drone.addComponent(GltfAnimationComponent("drone_animation"))
        drone.addComponent(ProceduralAnimationComponent(radius = 2.0f, speed = 0.5f))

        // Create a ValueAnimator for the scale animation
        val scaleAnimator = ValueAnimator.ofFloat(1.0f, 1.2f).apply {
            duration = 2000
            repeatMode = ValueAnimator.REVERSE
            repeatCount = ValueAnimator.INFINITE
        }
        drone.addComponent(ScaleAnimationComponent(scaleAnimator))
        world.addEntity(drone)

        // Register the animation systems
        world.addSystem(GltfAnimationSystem())
        world.addSystem(ProceduralAnimationSystem())
        world.addSystem(ScaleAnimationSystem())
    }
}
