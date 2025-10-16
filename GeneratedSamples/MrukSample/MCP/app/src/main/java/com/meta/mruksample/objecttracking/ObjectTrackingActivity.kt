package com.meta.mruksample.objecttracking

import android.os.Bundle
import com.meta.spatial.sdk.AppSystemActivity
import com.meta.spatial.sdk.scene.Scene
import com.meta.spatial.sdk.scene.components.Position
import com.meta.spatial.sdk.scene.components.Visible
import com.meta.spatial.sdk.scene.entities.Model
import com.meta.spatial.sdk.mruk.Mruk
import com.meta.spatial.sdk.mruk.Mruk.TrackedObject

/**
 * This activity demonstrates how to track a physical object, in this case a keyboard.
 *
 * It uses the MRUK APIs to detect the keyboard and then overlays a virtual representation of it.
 */
class ObjectTrackingActivity : AppSystemActivity() {

    private lateinit var scene: Scene
    private lateinit var mruk: Mruk
    private var keyboardEntity: Model? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create a new scene
        scene = Scene(this)
        // Create a new MRUK instance
        mruk = Mruk(this)

        // Enable passthrough to see the real world
        scene.enablePassthrough(true)
        // Find the skybox entity and hide it
        val skyboxEntity = scene.query { it.has(com.meta.spatial.sdk.scene.components.Skybox::class.java) }.firstOrNull()
        skyboxEntity?.setComponent(Visible(false))

        // Find the keyboard and track it
        mruk.startObjectTracking(TrackedObject.KEYBOARD) { keyboard ->
            // If the keyboard entity has not been created yet, create it
            if (keyboardEntity == null) {
                keyboardEntity = Model.fromGltf("models/cube.gltf")
                scene.add(keyboardEntity!!)
            }
            // Update the position of the keyboard entity to match the tracked keyboard
            keyboardEntity!!.setComponent(Position(keyboard.center.x, keyboard.center.y, keyboard.center.z))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Stop object tracking when the activity is destroyed
        mruk.stopObjectTracking(TrackedObject.KEYBOARD)
    }
}
