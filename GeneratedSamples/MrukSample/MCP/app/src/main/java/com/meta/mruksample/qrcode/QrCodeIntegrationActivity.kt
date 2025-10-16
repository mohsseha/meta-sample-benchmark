package com.meta.mruksample.qrcode

import android.os.Bundle
import android.widget.TextView
import com.meta.spatial.sdk.AppSystemActivity
import com.meta.spatial.sdk.scene.Scene
import com.meta.spatial.sdk.scene.components.Position
import com.meta.spatial.sdk.scene.components.Visible
import com.meta.spatial.sdk.scene.entities.Panel
import com.meta.spatial.sdk.mruk.Mruk

/**
 * This activity demonstrates how to detect QR codes in the environment and display their content.
 *
 * It uses the MRUK APIs to scan for QR codes and then displays the decoded text in a panel.
 */
class QrCodeIntegrationActivity : AppSystemActivity() {

    private lateinit var scene: Scene
    private lateinit var mruk: Mruk

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

        // Scan for QR codes
        mruk.startQrCodeScanning { qrCode ->
            // Create a new panel to display the QR code text
            val panel = Panel(2f, 1f)
            // Create a new text view to display the QR code text
            val textView = TextView(this)
            // Set the text of the text view to the decoded QR code text
            textView.text = qrCode.text
            // Set the content view of the panel to the text view
            panel.setContentView(textView)
            // Set the position of the panel to the center of the QR code
            panel.setComponent(Position(qrCode.center.x, qrCode.center.y, qrCode.center.z))
            // Add the panel to the scene
            scene.add(panel)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Stop QR code scanning when the activity is destroyed
        mruk.stopQrCodeScanning()
    }
}
