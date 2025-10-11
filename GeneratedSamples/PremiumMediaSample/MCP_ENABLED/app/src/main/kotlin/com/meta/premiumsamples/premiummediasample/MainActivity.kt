package com.meta.premiumsamples.premiummediasample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.meta.premiumsamples.premiummediasample.data.MediaItem
import com.meta.premiumsamples.premiummediasample.mruk.MrukManager
import com.meta.premiumsamples.premiummediasample.panels.BasePanel
import com.meta.premiumsamples.premiummediasample.panels.DrmVideoPanel
import com.meta.premiumsamples.premiummediasample.panels.Equirect180VideoPanel
import com.meta.premiumsamples.premiummediasample.panels.StandardVideoPanel
import com.meta.premiumsamples.premiummediasample.shaders.ShaderManager
import com.meta.spatial.sdk.base.Permissions
import com.meta.spatial.sdk.base.Pose
import com.meta.spatial.sdk.scene.Scene
import com.meta.spatial.sdk.scene.Scene.Companion.create
import com.meta.spatial.sdk.scene.SceneAnchor
import com.meta.spatial.sdk.scene.panel.Panel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private lateinit var scene: Scene
    private lateinit var mrukManager: MrukManager
    private lateinit var shaderManager: ShaderManager
    private var currentPanel: BasePanel? = null
    private var passthroughEnabled = false

    private val mediaBrowserLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val mediaItem = result.data?.getParcelableExtra<MediaItem>("selected_media_item")
            mediaItem?.let {
                createAndPlacePanel(it)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Permissions.requestPermissions(this, listOf(Permissions.Permission.USE_SCENE))

        scene = create(this)
        mrukManager = MrukManager(scene)
        shaderManager = ShaderManager(this)

        setContent {
            MainScreen()
        }
    }

    @Composable
    fun MainScreen() {
        Column {
            Button(onClick = {
                val intent = Intent(this@MainActivity, MediaBrowserActivity::class.java)
                mediaBrowserLauncher.launch(intent)
            }) {
                Text("Open Media Browser")
            }
            Button(onClick = { togglePassthrough() }) {
                Text(if (passthroughEnabled) "Disable Passthrough" else "Enable Passthrough")
            }
        }
    }

    private fun togglePassthrough() {
        passthroughEnabled = !passthroughEnabled
        scene.passthrough = passthroughEnabled
    }

    private fun createAndPlacePanel(mediaItem: MediaItem) {
        currentPanel?.destroy()

        currentPanel = when (mediaItem.type) {
            com.meta.premiumsamples.premiummediasample.data.MediaType.STANDARD -> StandardVideoPanel(scene, this, mediaItem)
            com.meta.premiumsamples.premiummediasample.data.MediaType.STANDARD_DRM -> DrmVideoPanel(scene, this, mediaItem)
            com.meta.premiumsamples.premiummediasample.data.MediaType.EQUIRECT_180 -> Equirect180VideoPanel(scene, this, mediaItem)
        }

        currentPanel?.create()

        CoroutineScope(Dispatchers.Main).launch {
            val wallAnchor = mrukManager.findWallAnchor()
            currentPanel?.getPanel()?.let {
                placePanelOnWall(it, wallAnchor)
                applyReflectionShader(it)
            }
        }
    }

    private fun placePanelOnWall(panel: Panel, wallAnchor: SceneAnchor?) {
        if (wallAnchor != null) {
            panel.pose = wallAnchor.pose
        } else {
            // Default placement if no wall is found
            panel.pose = Pose.fromTranslation(0.0f, 1.5f, -2.0f)
        }
    }

    private fun applyReflectionShader(panel: Panel) {
        val shaderProgram = shaderManager.loadShaderProgram("shaders/reflection.vert", "shaders/reflection.frag")
        if (shaderProgram != null) {
            panel.shaderProgram = shaderProgram
        }
    }

    override fun onDestroy() {
        currentPanel?.destroy()
        scene.destroy()
        super.onDestroy()
    }
}