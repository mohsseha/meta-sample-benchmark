package com.meta.mixedrealitysample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.meta.spatial.sdk.base.PermissionsHelper
import com.meta.spatial.sdk.base.SdkManager
import com.meta.spatial.sdk.mruk.MRUKFeature
import com.meta.spatial.sdk.physics.PhysicsFeature
import com.meta.spatial.sdk.scene.entities.EntityManager
import com.meta.spatial.sdk.systems.SystemBase
import com.meta.spatial.sdk.systems.UpdateContext

class MainActivity : AppCompatActivity() {

    private lateinit var sdkManager: SdkManager
    private val entityManager = EntityManager()
    private val TAG = "MixedRealitySample"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sdkManager = SdkManager(this, entityManager)

        if (!PermissionsHelper.isPermissionGranted(this, "com.meta.permission.ACCESS_SCENE_DATA")) {
            PermissionsHelper.requestPermission(this, "com.meta.permission.ACCESS_SCENE_DATA")
        } else {
            initializeSdk()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (PermissionsHelper.isPermissionGranted(this, "com.meta.permission.ACCESS_SCENE_DATA")) {
            initializeSdk()
        } else {
            Log.e(TAG, "ACCESS_SCENE_DATA permission denied")
            finish()
        }
    }

    private fun initializeSdk() {
        sdkManager.initialize(listOf(MRUKFeature::class.java, PhysicsFeature::class.java))
        sdkManager.start()

        val mrukFeature = sdkManager.getFeature(MRUKFeature::class.java)
        mrukFeature.loadSceneFromDevice().thenAccept { scene ->
            val sceneManager = Scene(entityManager)
            sceneManager.createBounds(scene)
            val targetManager = Target(entityManager)
            targetManager.place(scene)
        }

        entityManager.addSystem(BasketballShooterSystem(entityManager))
    }

    override fun onPause() {
        super.onPause()
        sdkManager.pause()
    }

    override fun onResume() {
        super.onResume()
        sdkManager.resume()
    }

    override fun onDestroy() {
        super.onDestroy()
        sdkManager.stop()
        sdkManager.destroy()
    }
}

class BasketballShooterSystem(private val entityManager: EntityManager) : SystemBase() {
    private var lastShotTime = 0L

    override fun onUpdate(context: UpdateContext) {
        // This is a simplified shooting mechanism. A real application would use controller input.
        if (System.currentTimeMillis() - lastShotTime > 2000) {
            val basketball = Basketball(entityManager)
            basketball.shoot()
            lastShotTime = System.currentTimeMillis()
        }
    }
}
