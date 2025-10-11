// This code requires the Meta Spatial SDK.
// Please ensure you have the SDK installed and configured in your environment.

package com.meta.animationsample

import com.meta.animationsample.animation.GltfAnimationSystem
import com.meta.animationsample.animation.ProceduralAnimationSystem
import com.meta.animationsample.component.AnimatedObject
import com.meta.spatial.scene.Scene
import com.meta.spatial.scene.SingleEntity
import com.meta.spatial.scene.Transform

class MainScene : Scene() {

    override fun init() {
        // Register the animation systems
        registerSystem(GltfAnimationSystem())
        registerSystem(ProceduralAnimationSystem())

        // Create a drone entity with a glTF animation
        val drone = SingleEntity()
        drone.addComponent(AnimatedObject("scenes/drone.gltf"))
        addEntity(drone)

        // Create a procedurally animated cube
        val cube1 = SingleEntity()
        cube1.addComponent(AnimatedObject(isProcedural = true))
        val transform1 = Transform()
        transform1.position.x = -1f
        cube1.addComponent(transform1)
        addEntity(cube1)

        // Create another procedurally animated cube to demonstrate reusability
        val cube2 = SingleEntity()
        cube2.addComponent(AnimatedObject(isProcedural = true))
        val transform2 = Transform()
        transform2.position.x = 1f
        cube2.addComponent(transform2)
        addEntity(cube2)
    }
}
