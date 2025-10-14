
package com.meta.mixedrealitysample

import com.meta.spatial.sdk.mruk.scene.MRUKScene
import com.meta.spatial.sdk.mruk.scene.RoomLayout
import com.meta.spatial.sdk.physics.components.CollisionComponent
import com.meta.spatial.sdk.physics.components.GravityComponent
import com.meta.spatial.sdk.physics.components.RigidBodyComponent
import com.meta.spatial.sdk.physics.shapes.BoxShape
import com.meta.spatial.sdk.physics.shapes.SphereShape
import com.meta.spatial.sdk.scene.components.AssetComponent
import com.meta.spatial.sdk.scene.components.PositionComponent
import com.meta.spatial.sdk.scene.components.RotationComponent
import com.meta.spatial.sdk.scene.components.ScaleComponent
import com.meta.spatial.sdk.scene.entities.EntityManager

class Basketball(private val entityManager: EntityManager) {

    fun shoot() {
        val basketball = entityManager.createEntity()
        basketball.addComponent(PositionComponent(0.0f, 1.5f, -1.0f))
        basketball.addComponent(ScaleComponent(0.1f, 0.1f, 0.1f))
        basketball.addComponent(AssetComponent("models/basketball.gltf"))
        basketball.addComponent(CollisionComponent(SphereShape(0.1f)))
        basketball.addComponent(RigidBodyComponent(mass = 0.6f, velocity = floatArrayOf(0.0f, 2.0f, -5.0f)))
        basketball.addComponent(GravityComponent())
    }
}

class Scene(private val entityManager: EntityManager) {

    fun createBounds(scene: MRUKScene) {
        val roomLayout = scene.getRoomLayout()
        createWalls(roomLayout)
        createFloor(roomLayout)
        createCeiling(roomLayout)
    }

    private fun createWalls(roomLayout: RoomLayout) {
        roomLayout.walls.forEach { wall ->
            val entity = entityManager.createEntity()
            entity.addComponent(PositionComponent(wall.position))
            entity.addComponent(RotationComponent(wall.rotation))
            entity.addComponent(ScaleComponent(wall.scale))
            entity.addComponent(CollisionComponent(BoxShape(wall.scale)))
            entity.addComponent(RigidBodyComponent(isStatic = true))
        }
    }

    private fun createFloor(roomLayout: RoomLayout) {
        val floor = roomLayout.floor
        val entity = entityManager.createEntity()
        entity.addComponent(PositionComponent(floor.position))
        entity.addComponent(RotationComponent(floor.rotation))
        entity.addComponent(ScaleComponent(floor.scale))
        entity.addComponent(CollisionComponent(BoxShape(floor.scale)))
        entity.addComponent(RigidBodyComponent(isStatic = true))
    }

    private fun createCeiling(roomLayout: RoomLayout) {
        val ceiling = roomLayout.ceiling
        val entity = entityManager.createEntity()
        entity.addComponent(PositionComponent(ceiling.position))
        entity.addComponent(RotationComponent(ceiling.rotation))
        entity.addComponent(ScaleComponent(ceiling.scale))
        entity.addComponent(CollisionComponent(BoxShape(ceiling.scale)))
        entity.addComponent(RigidBodyComponent(isStatic = true))
    }
}

class Target(private val entityManager: EntityManager) {

    fun place(scene: MRUKScene) {
        val roomLayout = scene.getRoomLayout()
        roomLayout.walls.forEach { wall ->
            val targetEntity = entityManager.createEntity()
            targetEntity.addComponent(PositionComponent(wall.position.x, wall.position.y + 1.0f, wall.position.z))
            targetEntity.addComponent(RotationComponent(wall.rotation))
            targetEntity.addComponent(ScaleComponent(0.5f, 0.5f, 0.1f))
            targetEntity.addComponent(AssetComponent("models/target.gltf"))
            targetEntity.addComponent(CollisionComponent(BoxShape(0.5f, 0.5f, 0.1f)))
            targetEntity.addComponent(RigidBodyComponent(isStatic = true))
        }
    }
}
