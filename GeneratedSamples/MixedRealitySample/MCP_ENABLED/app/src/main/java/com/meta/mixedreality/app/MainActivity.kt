package com.meta.mixedreality.app

import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.jme3.math.Vector3f

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val PERMISSIONS_REQUEST_CODE = 1001
    private val REQUIRED_PERMISSIONS = arrayOf(
        "com.oculus.permission.USE_SCENE",
        "horizonos.permission.HEADSET_CAMERA"
    )

    private lateinit var mrukManager: MrukManager
    private lateinit var physicsManager: PhysicsManager
    private lateinit var objectManager: ObjectManager

    private val mainThreadHandler = Handler(Looper.getMainLooper())
    private val updateRunnable = object : Runnable {
        override fun run() {
            update()
            mainThreadHandler.postDelayed(this, 16) // ~60 FPS
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (hasAllPermissions()) {
            initializeSpatialSDK()
        } else {
            requestPermissions()
        }
    }

    private fun hasAllPermissions(): Boolean {
        for (permission in REQUIRED_PERMISSIONS) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, PERMISSIONS_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSIONS_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
                Log.d(TAG, "All permissions granted")
                initializeSpatialSDK()
            } else {
                Log.e(TAG, "Permissions denied. The application cannot run without the required permissions.")
                finish()
            }
        }
    }

    private fun initializeSpatialSDK() {
        Log.d(TAG, "Initializing Meta Spatial SDK")
        mrukManager = MrukManager(this)
        physicsManager = PhysicsManager()
        objectManager = ObjectManager(this, physicsManager)

        setupScene()
    }

    private fun setupScene() {
        Log.d(TAG, "Setting up the mixed reality scene")
        mrukManager.loadScene().thenAccept {
            initializePhysics()
            spawnInitialObjects()
            startGameLoop()
        }
    }

    private fun initializePhysics() {
        physicsManager.initialize()
        val collisionMeshes = mrukManager.getCollisionMeshes()
        for (mesh in collisionMeshes) {
            physicsManager.createStaticCollisionBody(mesh)
        }
    }

    private fun spawnInitialObjects() {
        for (wall in mrukManager.getWalls()) {
            objectManager.spawnTargetOnWall(wall)
        }
    }

    private fun startGameLoop() {
        mainThreadHandler.post(updateRunnable)
    }

    private fun update() {
        val deltaTime = 0.016f // a fixed delta time for simplicity
        physicsManager.update(deltaTime)
        objectManager.update(deltaTime)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN) {
            shootBasketball()
        }
        return super.onTouchEvent(event)
    }

    private fun shootBasketball() {
        val basketball = objectManager.spawnBasketball()
        val direction = Vector3f(0f, 0.5f, -1f).normalize() // Shoot forward and slightly up
        val speed = 10f
        objectManager.shootBasketball(basketball, direction, speed)
    }

    override fun onDestroy() {
        super.onDestroy()
        mainThreadHandler.removeCallbacks(updateRunnable)
    }
}