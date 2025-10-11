package com.meta.mruksample

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class PermissionManager(private val activity: Activity) {

    companion object {
        private const val PERMISSION_REQUEST_CODE = 1001
        private const val SCENE_PERMISSION = "com.meta.permission.USE_SCENE"
    }

    fun hasScenePermission(): Boolean {
        return ContextCompat.checkSelfPermission(activity, SCENE_PERMISSION) == PackageManager.PERMISSION_GRANTED
    }

    fun requestScenePermission() {
        ActivityCompat.requestPermissions(activity, arrayOf(SCENE_PERMISSION), PERMISSION_REQUEST_CODE)
    }

    fun handlePermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray): Boolean {
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                return true
            }
        }
        return false
    }
}
