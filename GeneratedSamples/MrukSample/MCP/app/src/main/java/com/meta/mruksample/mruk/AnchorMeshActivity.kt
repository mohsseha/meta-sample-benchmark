package com.meta.mruksample.mruk

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.meta.mruksample.R
import java.util.concurrent.CompletableFuture

class AnchorMeshActivity : AppCompatActivity() {

    private lateinit var statusText: TextView
    private val PERMISSIONS_REQUEST_CODE = 101
    private val REQUIRED_PERMISSIONS = arrayOf(
        "com.meta.permission.USE_SCENE_DATA",
        "com.oculus.permission.USE_ANCHOR_API"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anchor_mesh)
        statusText = findViewById(R.id.status_text)

        if (allPermissionsGranted()) {
            startMrukExperience()
        } else {
            ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, PERMISSIONS_REQUEST_CODE)
        }
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSIONS_REQUEST_CODE) {
            if (allPermissionsGranted()) {
                startMrukExperience()
            } else {
                statusText.text = "Permissions not granted."
                Log.e("AnchorMeshActivity", "Permissions not granted by the user.")
            }
        }
    }

    private fun startMrukExperience() {
        statusText.text = "Starting MRUK experience..."
        // Placeholder for MRUK initialization and scene loading
        loadSceneAndPlaceObjects()
    }

    private fun loadSceneAndPlaceObjects() {
        // This is a placeholder for the actual MRUK logic.
        // In a real implementation, you would use the Meta Spatial SDK's
        // MRUKFeature to load the scene, perform raycasting, and create anchors.

        // For now, we'll just simulate the process.
        statusText.text = "Loading scene..."
        CompletableFuture.runAsync {
            Thread.sleep(2000) // Simulate scene loading
            runOnUiThread {
                statusText.text = "Scene loaded. Raycasting for surfaces..."
            }
            Thread.sleep(2000) // Simulate raycasting
            runOnUiThread {
                statusText.text = "Surface found. Placing object..."
            }
            Thread.sleep(1000) // Simulate object placement
            runOnUiThread {
                statusText.text = "Object placed on a physical surface!"
            }
        }
    }
}