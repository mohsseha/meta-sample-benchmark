package com.meta.mixedreality.mruk

import com.meta.spatial.sdk.*
import com.meta.spatial.sdk.physics.Collision
import com.meta.spatial.sdk.physics.PhysicsSystem
import com.meta.spatial.sdk.physics.RigidBody

class GameManager(
    private val scene: Scene,
    private val physicsSystem: PhysicsSystem,
    private val rightController: Entity,
    private val leftController: Entity
) {

    fun setupGame() {
        // Place targets on the walls
        placeTargets()

        // Listen for controller input
        rightController.getComponent(Input::class.java)?.let {
            it.onButtonDown(Input.Button.A, this::shootBasketball)
        }
        leftController.getComponent(Input::class.java)?.let {
            it.onButtonDown(Input.Button.X, this::shootBasketball)
        }
    }

    private fun placeTargets() {
        val walls = MRUK.getSceneData().walls
        for (wall in walls) {
            val target = scene.createEntity()
            target.setComponent(Transform(wall.position, wall.rotation))
            target.setComponent(Model("target.gltf"))
            target.setComponent(Collision(0.5f, 0.5f, 0.1f))
            physicsSystem.addEntity(target)
        }
    }

    private fun shootBasketball() {
        val basketball = scene.createEntity()
        val controllerTransform = rightController.getComponent(Transform::class.java)
        basketball.setComponent(Transform(controllerTransform.position, controllerTransform.rotation))
        basketball.setComponent(Model("basketball.gltf"))
        basketball.setComponent(Collision(0.2f))
        val rigidBody = RigidBody(1.0f)
        rigidBody.velocity = controllerTransform.forward * 10.0f
        basketball.setComponent(rigidBody)
        physicsSystem.addEntity(basketball)
    }
}
