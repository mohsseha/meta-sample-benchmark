package com.meta.spatial.animation_sample

import android.os.Bundle
import com.meta.spatial.core.AppSystemActivity
import com.meta.spatial.core.SystemManager
import com.meta.spatial.ecs.AnimationSystem
import com.meta.spatial.ecs.Scene
import com.meta.spatial.ecs.Visible
import com.meta.spatial.math.Vector3

class MainActivity : AppSystemActivity() {

    private lateinit var scene: Scene

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Register the AnimationSystem
        systemManager.registerSystem(AnimationSystem())
        systemManager.registerSystem(GltfAnimationSystem())
        systemManager.registerSystem(ProceduralAnimationSystem())
        systemManager.registerSystem(UiAnimationSystem())

        // Create a new scene
        scene = Scene()

        // Set up the scene environment
        setupEnvironment()

        // Demonstrate glTF animation playback
        playGltfAnimation()

        // Demonstrate reusable animation drivers
        startReusableAnimation()

        // Demonstrate procedural frame-based animation
        startProceduralAnimation()

        // Set the scene
        setScene(scene)
    }

    private fun setupEnvironment() {
        // Create a skybox and hide it to enable passthrough
        val skyboxEntity = scene.createEntity("skybox")
        // For the purpose of this sample, we will not add a skybox component
        // so we can see the passthrough.
        skyboxEntity.setComponent(Visible(false))


        // Enable passthrough
        scene.enablePassthrough(true)

        // Add a light to the scene
        val lightEntity = scene.createEntity("light")
        lightEntity.setComponent(com.meta.spatial.ecs.Light(
            com.meta.spatial.ecs.Light.Type.DIRECTIONAL,
            Vector3(1.0f, 1.0f, 1.0f),
            1.0f
        ))
        lightEntity.getComponent(com.meta.spatial.ecs.Transform::class.java).translation = Vector3(0.0f, 3.0f, 0.0f)
    }

    private fun playGltfAnimation() {
        // Load the drone glTF model
        val droneEntity = scene.loadModel("scenes/drone.gltf")
        droneEntity.getComponent(com.meta.spatial.ecs.Transform::class.java).translation = Vector3(0.0f, 1.0f, -2.0f)

        // Play the animation
        val animation = droneEntity.getComponent(com.meta.spatial.ecs.Animation::class.java)
        animation.play("drone_animation")
        animation.loop = true
    }

    private fun startReusableAnimation() {
        // Create a reusable animation driver
        val animationDriver = ReusableAnimationDriver(scene)

        // Create a cube and apply the reusable animation
        val cubeEntity = scene.createEntity("cube")
        cubeEntity.setComponent(com.meta.spatial.ecs.Mesh(com.meta.spatial.ecs.Mesh.Primitive.CUBE))
        cubeEntity.getComponent(com.meta.spatial.ecs.Transform::class.java).translation = Vector3(-2.0f, 1.0f, -2.0f)
        animationDriver.addAnimation(cubeEntity)
    }

    private fun startProceduralAnimation() {
        // Create a sphere and apply the procedural animation
        val sphereEntity = scene.createEntity("sphere")
        sphereEntity.setComponent(com.meta.spatial.ecs.Mesh(com.meta.spatial.ecs.Mesh.Primitive.SPHERE))
        sphereEntity.getComponent(com.meta.spatial.ecs.Transform::class.java).translation = Vector3(2.0f, 1.0f, -2.0f)

        // Add the procedural animation component
        sphereEntity.setComponent(ProceduralAnimationComponent())
    }
}