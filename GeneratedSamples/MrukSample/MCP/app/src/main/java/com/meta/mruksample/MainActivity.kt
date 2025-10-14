package com.meta.mruksample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.meta.mruksample.mruk.AnchorMeshActivity
import com.meta.mruksample.mruk.KeyboardTrackerActivity
import com.meta.mruksample.mruk.QrCodeScannerActivity
import com.meta.mruksample.mruk.RaycastActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.anchor_mesh_button).setOnClickListener {
            startActivity(Intent(this, AnchorMeshActivity::class.java))
        }

        findViewById<Button>(R.id.keyboard_tracker_button).setOnClickListener {
            startActivity(Intent(this, KeyboardTrackerActivity::class.java))
        }

        findViewById<Button>(R.id.qr_code_scanner_button).setOnClickListener {
            startActivity(Intent(this, QrCodeScannerActivity::class.java))
        }

        findViewById<Button>(R.id.raycast_button).setOnClickListener {
            startActivity(Intent(this, RaycastActivity::class.java))
        }
    }
}
