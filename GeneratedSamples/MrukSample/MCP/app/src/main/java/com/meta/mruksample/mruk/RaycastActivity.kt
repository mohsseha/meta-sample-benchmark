package com.meta.mruksample.mruk

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.meta.mruksample.R
import java.util.concurrent.CompletableFuture

// Placeholder for Scene and HitInfo classes
class Scene {
    fun lineSegmentIntersect(origin: Vector3, direction: Vector3): HitInfo? {
        // In a real implementation, this would perform a raycast against the scene geometry.
        // For this placeholder, we'll simulate a hit.
        return HitInfo(Vector3(0.0f, 0.0f, -2.0f), Vector3(0.0f, 1.0f, 0.0f), "Wall")
    }
}

data class Vector3(val x: Float, val y: Float, val z: Float)
data class HitInfo(val point: Vector3, val normal: Vector3, val sceneObjectName: String)

class RaycastActivity : AppCompatActivity() {

    private lateinit var statusText: TextView
    private lateinit var scene: Scene

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raycast)
        statusText = findViewById(R.id.raycast_status_text)
        scene = Scene()

        startRaycasting()
    }

    private fun startRaycasting() {
        statusText.text = "Raycasting..."
        CompletableFuture.runAsync {
            val rayOrigin = Vector3(0.0f, 1.5f, 0.0f)
            val rayDirection = Vector3(0.0f, 0.0f, -1.0f)
            val hitInfo = scene.lineSegmentIntersect(rayOrigin, rayDirection)

            runOnUiThread {
                if (hitInfo != null) {
                    statusText.text = "Raycast hit a ${hitInfo.sceneObjectName} at ${hitInfo.point}"
                } else {
                    statusText.text = "Raycast did not hit anything."
                }
            }
        }
    }
}
