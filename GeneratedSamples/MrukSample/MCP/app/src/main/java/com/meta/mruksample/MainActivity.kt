package com.meta.mruksample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.meta.mruksample.objecttracking.ObjectTrackingActivity
import com.meta.mruksample.qrcode.QrCodeIntegrationActivity
import com.meta.mruksample.raycasting.RaycastingActivity
import com.meta.mruksample.surfaceanchoring.SurfaceAnchoringActivity
import com.meta.spatial.sdk.AppSystemActivity
import com.meta.spatial.sdk.scene.Scene
import com.meta.spatial.sdk.scene.components.Visible

/**
 * The main activity of the application.
 *
 * This activity displays a menu with buttons to launch the different MRUK experiences.
 */
class MainActivity : AppSystemActivity() {

    private lateinit var scene: Scene

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create a new scene
        scene = Scene(this)
        // Set the content view to the main activity layout
        setContentView(R.layout.activity_main)

        // Enable passthrough to see the real world
        scene.enablePassthrough(true)
        // Find the skybox entity and hide it
        val skyboxEntity = scene.query { it.has(com.meta.spatial.sdk.scene.components.Skybox::class.java) }.firstOrNull()
        skyboxEntity?.setComponent(Visible(false))

        // Set up the button listeners to launch the different experiences
        findViewById<Button>(R.id.surface_anchoring_button).setOnClickListener {
            startActivity(Intent(this, SurfaceAnchoringActivity::class.java))
        }

        findViewById<Button>(R.id.object_tracking_button).setOnClickListener {
            startActivity(Intent(this, ObjectTrackingActivity::class.java))
        }

        findViewById<Button>(R.id.qr_code_integration_button).setOnClickListener {
            startActivity(Intent(this, QrCodeIntegrationActivity::class.java))
        }

        findViewById<Button>(R.id.raycasting_button).setOnClickListener {
            startActivity(Intent(this, RaycastingActivity::class.java))
        }
    }
}
