package com.meta.mruksample

import android.os.Bundle
import com.meta.spatial.sdk.base.PermissionsHelper
import com.meta.spatial.sdk.base.SpatialActivity
import com.meta.mruksample.databinding.ActivityMainBinding
import com.meta.mruksample.experiences.Experience
import com.meta.mruksample.experiences.KeyboardTrackerExperience
import com.meta.mruksample.experiences.QRCodeScannerExperience
import com.meta.mruksample.experiences.RaycastExperience
import com.meta.mruksample.experiences.SurfaceAnchorExperience

class MainActivity : SpatialActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentExperience: Experience? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!PermissionsHelper.hasScenePermission(this)) {
            PermissionsHelper.requestScenePermission(this)
        }

        binding.surfaceAnchorButton.setOnClickListener {
            stopCurrentExperience()
            currentExperience = SurfaceAnchorExperience(this)
            currentExperience?.start()
        }

        binding.keyboardTrackerButton.setOnClickListener {
            stopCurrentExperience()
            currentExperience = KeyboardTrackerExperience(this)
            currentExperience?.start()
        }

        binding.qrCodeScannerButton.setOnClickListener {
            stopCurrentExperience()
            currentExperience = QRCodeScannerExperience(this)
            currentExperience?.start()
        }

        binding.raycastButton.setOnClickListener {
            stopCurrentExperience()
            currentExperience = RaycastExperience(this)
            currentExperience?.start()
        }
    }

    private fun stopCurrentExperience() {
        currentExperience?.stop()
        currentExperience = null
    }

    override fun onDestroy() {
        super.onDestroy()
        stopCurrentExperience()
    }
}
