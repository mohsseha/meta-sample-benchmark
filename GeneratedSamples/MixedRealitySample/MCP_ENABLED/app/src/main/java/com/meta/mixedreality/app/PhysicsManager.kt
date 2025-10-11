package com.meta.mixedreality.app

import android.util.Log
import com.jme3.bullet.PhysicsSpace
import com.jme3.bullet.collision.shapes.CollisionShape
import com.jme3.bullet.collision.shapes.SphereCollisionShape
import com.jme3.bullet.objects.PhysicsRigidBody
import com.jme3.math.Vector3f

class PhysicsManager {

    private val TAG = "PhysicsManager"
    private lateinit var physicsSpace: PhysicsSpace
    private val rigidBodies = mutableListOf<PhysicsRigidBody>()

    fun initialize() {
        Log.d(TAG, "Initializing physics world.")
        physicsSpace = PhysicsSpace(PhysicsSpace.BroadphaseType.DBVT)
        physicsSpace.gravity = Vector3f(0f, -9.81f, 0f)
    }

    fun createStaticCollisionBody(mesh: AnchorProceduralMesh): PhysicsRigidBody {
        Log.d(TAG, "Creating static collision body for a room surface.")
        val collisionShape = createCollisionShapeFromMesh(mesh)
        val rigidBody = PhysicsRigidBody(collisionShape, 0f) // 0 mass for static objects
        physicsSpace.add(rigidBody)
        rigidBodies.add(rigidBody)
        return rigidBody
    }

    fun createDynamicBasketballBody(): PhysicsRigidBody {
        Log.d(TAG, "Creating dynamic rigid body for a basketball.")
        val basketballShape = SphereCollisionShape(0.12f) // 24cm diameter
        val rigidBody = PhysicsRigidBody(basketballShape, 0.62f) // 0.62kg mass
        rigidBody.restitution = 0.7f // Bounciness
        physicsSpace.add(rigidBody)
        rigidBodies.add(rigidBody)
        return rigidBody
    }

    fun update(deltaTime: Float) {
        physicsSpace.update(deltaTime)
    }

    private fun createCollisionShapeFromMesh(mesh: AnchorProceduralMesh): CollisionShape {
        // This is a placeholder. In a real application, you would convert the
        // AnchorProceduralMesh to a Bullet-compatible mesh collision shape.
        // For this sample, we'll just return a dummy shape.
        return SphereCollisionShape(1.0f)
    }
}