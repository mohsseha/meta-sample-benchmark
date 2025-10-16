/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.meta.mruksample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.meta.spatial.sdk.base.permission.PermissionManager

class MainActivity : AppCompatActivity() {

    private lateinit var permissionManager: PermissionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        permissionManager = PermissionManager(this)

        findViewById<Button>(R.id.anchor_mesh_button).setOnClickListener {
            checkPermissionsAndStartExperience(AnchorMeshActivity::class.java)
        }

        findViewById<Button>(R.id.keyboard_tracker_button).setOnClickListener {
            checkPermissionsAndStartExperience(KeyboardTrackerActivity::class.java)
        }

        findViewById<Button>(R.id.qr_code_scanner_button).setOnClickListener {
            checkPermissionsAndStartExperience(QrCodeScannerActivity::class.java)
        }

        findViewById<Button>(R.id.raycast_button).setOnClickListener {
            checkPermissionsAndStartExperience(RaycastActivity::class.java)
        }
    }

    private fun checkPermissionsAndStartExperience(activityClass: Class<*>) {
        if (arePermissionsGranted()) {
            startExperience(activityClass)
        } else {
            requestPermissions { granted ->
                if (granted) {
                    startExperience(activityClass)
                }
            }
        }
    }

    private fun startExperience(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }

    private fun arePermissionsGranted(): Boolean {
        return permissionManager.isPermissionGranted(PermissionManager.Permission.SCENE)
    }

    private fun requestPermissions(onResult: (Boolean) -> Unit) {
        permissionManager.requestPermission(PermissionManager.Permission.SCENE) {
            onResult(it.isGranted)
        }
    }
}
