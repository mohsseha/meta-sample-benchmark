package com.meta.mixedreality.mruk

import android.os.Bundle
import com.meta.spatial.sdk.AppSystemActivity
import com.meta.spatial.sdk.Visible

import com.meta.spatial.sdk.physics.PhysicsSystem

class MainActivity : AppSystemActivity() {

    private lateinit var physicsSystem: PhysicsSystem
    private lateinit var roomManager: RoomManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable passthrough and hide the skybox
        scene.enablePassthrough(true)
        val skyboxEntity = scene.query().firstOrNull { it.hasComponent(com.meta.spatial.sdk.Skybox::class.java) }
        skyboxEntity?.setComponent(Visible(false))

        // Setup physics and room
        physicsSystem = PhysicsSystem()
        systemManager.registerSystem(physicsSystem)
        roomManager = RoomManager(scene, physicsSystem)
        roomManager.setupRoom()

        // Setup game
        val rightController = scene.query().first { it.hasComponent(Input::class.java) && it.getComponent(Input::class.java).isRightHand }
        val leftController = scene.query().first { it.hasComponent(Input::class.java) && !it.getComponent(Input.class.java).isRightHand }
        val gameManager = GameManager(scene, physicsSystem, rightController, leftController)
        gameManager.setupGame()
    }
}
