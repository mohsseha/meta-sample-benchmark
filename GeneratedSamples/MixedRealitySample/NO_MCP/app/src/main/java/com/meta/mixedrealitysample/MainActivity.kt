package com.meta.mixedrealitysample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.meta.xr.sdk.component.Model
import com.meta.xr.sdk.component.physics.Collider
import com.meta.xr.sdk.component.physics.CollisionShape
import com.meta.xr.sdk.component.physics.PhysicsBody
import com.meta.xr.sdk.component.physics.PhysicsMaterial
import com.meta.xr.sdk.core.Renderer
import com.meta.xr.sdk.core.Scene
import com.meta.xr.sdk.core.vector3
import com.meta.xr.sdk.scene.PermissionState
import com.meta.xr.sdk.scene.ScenePermissionManager
import com.meta.xr.sdk.scene.SpaceType
import com.meta.xr.sdk.scene.room.Room
import com.meta.xr.sdk.scene.room.element.Plane
import com.meta.xr.sdk.scene.room.element.Volume
import java.util.Timer
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    private lateinit var scene: Scene
    private lateinit var renderer: Renderer
    private val TAG = "MixedRealitySample"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        renderer = findViewById(R.id.renderer)
        scene = Scene(this)
        renderer.scene = scene

        checkScenePermission()
    }

    private fun checkScenePermission() {
        when (ScenePermissionManager.checkPermission(this)) {
            PermissionState.GRANTED -> {
                setupScene()
            }
            PermissionState.DENIED -> {
                Log.e(TAG, "Scene permission denied")
                // Handle permission denial gracefully
            }
            PermissionState.NOT_REQUESTED -> {
                ScenePermissionManager.requestPermission(this)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (ScenePermissionManager.isScenePermissionRequest(requestCode)) {
            if (ScenePermissionManager.isPermissionGranted(grantResults)) {
                setupScene()
            } else {
                Log.e(TAG, "Scene permission denied")
                // Handle permission denial gracefully
            }
        }
    }

    private fun setupScene() {
        scene.use {
            // Enable physics
            it.physics.enabled = true
            it.physics.gravity = vector3(0.0f, -9.8f, 0.0f)

            // Load room model
            val room = Room(it)
            room.load()

            // Create physics materials
            val wallMaterial = PhysicsMaterial(it)
            wallMaterial.restitution = 0.8f // Bouncy

            val basketballMaterial = PhysicsMaterial(it)
            basketballMaterial.restitution = 0.9f

            // Process room geometry
            room.walls.forEach { wall ->
                createColliderForPlane(wall, wallMaterial)
            }
            createColliderForPlane(room.floor, wallMaterial)
            createColliderForPlane(room.ceiling, wallMaterial)

            // Place targets
            placeTargetsOnWalls(room.walls)

            // Spawn basketballs periodically
            Timer().schedule(0, 5000) {
                spawnBasketball(basketballMaterial)
            }
        }
    }

    private fun createColliderForPlane(plane: Plane, material: PhysicsMaterial) {
        val entity = scene.createEntity()
        entity.transform.position = plane.position
        entity.transform.rotation = plane.rotation
        val collider = Collider(scene)
        collider.shape = CollisionShape.createBox(scene, plane.width, plane.height, 0.1f)
        collider.material = material
        entity.addComponent(collider)
    }

    private fun placeTargetsOnWalls(walls: List<Plane>) {
        walls.forEach { wall ->
            val target = scene.createEntity()
            target.transform.position = wall.position
            target.transform.rotation = wall.rotation
            val model = Model(scene, "target.gltf")
            target.addComponent(model)
        }
    }

    private fun spawnBasketball(material: PhysicsMaterial) {
        val basketball = scene.createEntity()
        basketball.transform.position = vector3(0.0f, 1.5f, -1.0f) // Spawn in front of user
        val model = Model(scene, "basketball.gltf")
        basketball.addComponent(model)

        val physicsBody = PhysicsBody(scene)
        physicsBody.mass = 0.6f // kg
        physicsBody.isGravityEnabled = true
        basketball.addComponent(physicsBody)

        val collider = Collider(scene)
        collider.shape = CollisionShape.createSphere(scene, 0.12f) // Basketball radius
        collider.material = material
        basketball.addComponent(collider)

        // Apply initial velocity to "shoot" the ball
        physicsBody.linearVelocity = vector3(0.0f, 2.0f, -5.0f)
    }

    override fun onResume() {
        super.onResume()
        renderer.onResume()
    }

    override fun onPause() {
        super.onPause()
        renderer.onPause()
    }
}