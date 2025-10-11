package com.meta.mruksample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.meta.mruksample.databinding.ActivityMainBinding
import com.meta.mruksample.experiences.AnchorMeshExperience
import com.meta.mruksample.experiences.KeyboardTrackerExperience
import com.meta.mruksample.experiences.QRCodeScannerExperience
import com.meta.mruksample.experiences.RaycastExperience
import com.meta.spatial.sdk.MRUKView
import com.meta.spatial.sdk.Scene
import com.meta.spatial.sdk.SceneObserver

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var permissionManager: PermissionManager
    private lateinit var mrukView: MRUKView

    private var anchorMeshExperience: AnchorMeshExperience? = null
    private var keyboardTrackerExperience: KeyboardTrackerExperience? = null
    private var qrCodeScannerExperience: QRCodeScannerExperience? = null
    private var raycastExperience: RaycastExperience? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        permissionManager = PermissionManager(this)
        mrukView = binding.mrukView

        if (permissionManager.hasScenePermission()) {
            initializeExperiences()
        } else {
            permissionManager.requestScenePermission()
        }

        setupUI()
    }

    private fun initializeExperiences() {
        val scene = Scene.getCurrentScene(this)
        if (!scene.isValid()) {
            Toast.makeText(this, "Scene data is not available. Please ensure you have a guardian configured.", Toast.LENGTH_LONG).show()
            return
        }

        scene.addObserver(object : SceneObserver {
            override fun onSceneUpdated(scene: Scene) {
                Log.d("MainActivity", "Scene updated")
                anchorMeshExperience?.onSceneUpdate(scene)
                keyboardTrackerExperience?.onSceneUpdate(scene)
                qrCodeScannerExperience?.onSceneUpdate(scene)
                raycastExperience?.onSceneUpdate(scene)
            }
        })

        anchorMeshExperience = AnchorMeshExperience(mrukView)
        keyboardTrackerExperience = KeyboardTrackerExperience(mrukView)
        qrCodeScannerExperience = QRCodeScannerExperience(mrukView)
        raycastExperience = RaycastExperience(mrukView)
    }

    private fun setupUI() {
        binding.btnAnchorMesh.setOnClickListener {
            anchorMeshExperience?.start()
            keyboardTrackerExperience?.stop()
            qrCodeScannerExperience?.stop()
            raycastExperience?.stop()
        }
        binding.btnKeyboardTracker.setOnClickListener {
            anchorMeshExperience?.stop()
            keyboardTrackerExperience?.start()
            qrCodeScannerExperience?.stop()
            raycastExperience?.stop()
        }
        binding.btnQrCodeScanner.setOnClickListener {
            anchorMeshExperience?.stop()
            keyboardTrackerExperience?.stop()
            qrCodeScannerExperience?.start()
            raycastExperience?.stop()
        }
        binding.btnRaycast.setOnClickListener {
            anchorMeshExperience?.stop()
            keyboardTrackerExperience?.stop()
            qrCodeScannerExperience?.stop()
            raycastExperience?.start()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (permissionManager.handlePermissionsResult(requestCode, permissions, grantResults)) {
            initializeExperiences()
        } else {
            Toast.makeText(this, "Scene permission is required for this application.", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        mrukView.resume()
    }

    override fun onPause() {
        super.onPause()
        mrukView.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mrukView.destroy()
    }
}
