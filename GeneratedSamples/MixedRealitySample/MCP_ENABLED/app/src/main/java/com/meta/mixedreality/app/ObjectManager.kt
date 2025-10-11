package com.meta.mixedreality.app

import android.content.Context
import android.util.Log
import com.jme3.bullet.objects.PhysicsRigidBody
import com.jme3.math.Vector3f
import kotlin.random.Random

class ObjectManager(
    private val context: Context,
    private val physicsManager: PhysicsManager
) {

    private val TAG = "ObjectManager"
    private val basketballs = mutableMapOf<BasketballObject, PhysicsRigidBody>()
    private val targets = mutableMapOf<TargetObject, PhysicsRigidBody>()

    fun spawnBasketball(): BasketballObject {
        Log.d(TAG, "Spawning a basketball.")
        val basketball = BasketballObject()
        val rigidBody = physicsManager.createDynamicBasketballBody()
        basketballs[basketball] = rigidBody
        return basketball
    }

    fun shootBasketball(basketball: BasketballObject, direction: Vector3f, speed: Float) {
        Log.d(TAG, "Shooting a basketball.")
        val rigidBody = basketballs[basketball]
        rigidBody?.apply {
            setLinearVelocity(direction.mult(speed))
        }
    }

    fun spawnTargetOnWall(wall: Wall) {
        Log.d(TAG, "Spawning a target on a wall.")
        val target = TargetObject()
        val position = calculateTargetPosition(wall)
        val rigidBody = physicsManager.createStaticCollisionBody(AnchorProceduralMesh())
        rigidBody.setPhysicsLocation(position)
        targets[target] = rigidBody
    }

    fun update(deltaTime: Float) {
        for ((basketball, rigidBody) in basketballs) {
            basketball.position.set(rigidBody.getPhysicsLocation())
        }
    }

    private fun calculateTargetPosition(wall: Wall): Vector3f {
        // This is a placeholder. In a real application, you would calculate a random position
        // on the wall's surface.
        val x = Random.nextFloat() * 2.0f - 1.0f
        val y = Random.nextFloat() * 2.0f - 1.0f
        return Vector3f(x, y, 0f)
    }
}

class VirtualObject {
    val position = Vector3f()
}

class TargetObject : VirtualObject()
class BasketballObject : VirtualObject()