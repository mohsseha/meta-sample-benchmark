package com.meta.mixedreality.mruk

import com.meta.spatial.sdk.*
import com.meta.spatial.sdk.mruk.MRUK
import com.meta.spatial.sdk.physics.Collision
import com.meta.spatial.sdk.physics.PhysicsSystem

class RoomManager(private val scene: Scene, private val physicsSystem: PhysicsSystem) {

    fun setupRoom() {
        // Request permission to use scene data
        MRUK.requestScenePermission(this::onPermissionResult)
    }

    private fun onPermissionResult(granted: Boolean) {
        if (granted) {
            // Get the scene data
            val sceneData = MRUK.getSceneData()

            // Create collision meshes for the walls
            for (wall in sceneData.walls) {
                createCollisionMesh(wall)
            }
        }
    }

    private fun createCollisionMesh(wall: MRUK.Wall) {
        val entity = scene.createEntity()
        entity.setComponent(Transform(wall.position, wall.rotation))
        entity.setComponent(Collision(wall.width, wall.height, 0.1f))
        physicsSystem.addEntity(entity)
    }
}
