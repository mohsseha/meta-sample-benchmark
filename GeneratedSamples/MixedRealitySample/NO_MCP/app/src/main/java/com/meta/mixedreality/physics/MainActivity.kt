
package com.meta.mixedreality.physics

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.meta.mixedreality.physics.mruk.SceneManager
import com.meta.mixedreality.physics.physics.PhysicsManager
import com.meta.mixedreality.physics.target.TargetManager
import com.meta.mixedreality.physics.ui.theme.MixedRealityPhysicsSampleTheme
import com.meta.xr.sdk.activity.SpatialActivity
import com.meta.xr.sdk.input.InputDevice
import com.meta.xr.sdk.input.InputManager
import com.meta.xr.sdk.input.InputSource
import com.meta.xr.sdk.permission.PermissionManager
import com.meta.xr.sdk.scene.Scene

class MainActivity : SpatialActivity() {

    private lateinit var permissionManager: PermissionManager
    private lateinit var sceneManager: SceneManager
    private lateinit var physicsManager: PhysicsManager
    private lateinit var targetManager: TargetManager
    private lateinit var inputManager: InputManager

    private var sceneLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permissionManager = PermissionManager(this)
        sceneManager = SceneManager()
        physicsManager = PhysicsManager()
        targetManager = TargetManager()
        inputManager = InputManager(this)

        setContent {
            MixedRealityPhysicsSampleTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    // The main composable for the application will be here.
                    // We can add a simple UI to show the status of the scene loading.
                }
            }
        }
    }

    override fun onEnter() {
        super.onEnter()
        if (!sceneLoaded) {
            requestScenePermission()
        }
    }

    override fun onUpdate(deltaTime: Float) {
        super.onUpdate(deltaTime)
        if (sceneLoaded) {
            physicsManager.update(deltaTime)
            handleInput()
        }
    }

    private fun requestScenePermission() {
        val permissions = arrayOf("com.oculus.permission.USE_SCENE")
        permissionManager.requestPermissions(permissions) { results ->
            if (results.all { it.value }) {
                loadScene()
            } else {
                // Handle permission denial
            }
        }
    }

    private fun loadScene() {
        Scene.load(this) { success ->
            if (success) {
                sceneLoaded = true
                val scene = Scene(this)
                sceneManager.createSceneMeshes(this, scene)
                targetManager.createTargets(this, scene)
            } else {
                // Handle scene loading failure
            }
        }
    }

    private fun handleInput() {
        val rightController = inputManager.getDevice(InputSource.CONTROLLER, InputDevice.RIGHT)
        if (rightController.isButtonPressed(InputManager.Button.PRIMARY_INDEX_TRIGGER)) {
            shootBasketball()
        }
    }

    private fun shootBasketball() {
        val basketball = physicsManager.createBasketball()
        val rightController = inputManager.getDevice(InputSource.CONTROLLER, InputDevice.RIGHT)
        basketball.transform.position = rightController.pose.position
        basketball.getComponent(com.meta.xr.sdk.spatial.component.physics.PhysicsComponent::class.java)?.apply {
            val forward = rightController.pose.rotation.getForwardVector()
            linearVelocity = forward * 10.0f
        }
    }
}
