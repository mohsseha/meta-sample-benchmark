package com.meta.premiumsamples.premiummediasample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import com.meta.premiumsamples.premiummediasample.data.MediaItem
import com.meta.premiumsamples.premiummediasample.data.MediaLibrary
import com.meta.premiumsamples.premiummediasample.data.MediaType
import com.meta.premiumsamples.premiummediasample.mruk.MrukManager
import com.meta.premiumsamples.premiummediasample.panels.DrmVideoPanel
import com.meta.premiumsamples.premiummediasample.panels.EquirectangularVideoPanel
import com.meta.premiumsamples.premiummediasample.panels.StandardVideoPanel
import com.meta.premiumsamples.premiummediasample.shaders.ShaderManager
import com.meta.spatial.core.AbstractSpatialActivity
import com.meta.spatial.core.SpatialFeature
import com.meta.spatial.core.System
import com.meta.spatial.environment.PassthroughFeature
import com.meta.spatial.environment.SceneFeature
import com.meta.spatial.input.InputListener
import com.meta.spatial.scene.SceneObject
import com.meta.spatial.scene.ScenePermissionState
import com.meta.spatial.scene.SceneRequest
import com.meta.spatial.scene.SceneRequestType

class MainActivity : AbstractSpatialActivity(), InputListener {

    private lateinit var passthroughFeature: PassthroughFeature
    private lateinit var sceneFeature: SceneFeature
    private lateinit var mrukManager: MrukManager
    private lateinit var shaderManager: ShaderManager

    private var currentPanel: SceneObject? = null

    private val mediaSelectionReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action == "com.meta.premiumsamples.premiummediasample.MEDIA_SELECTED") {
                val mediaTitle = intent.getStringExtra("media_title")
                val mediaItem = MediaLibrary.getMediaItems().find { it.title == mediaTitle }
                if (mediaItem != null) {
                    onMediaItemSelected(mediaItem)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        passthroughFeature = PassthroughFeature(this)
        sceneFeature = SceneFeature(this)
        mrukManager = MrukManager(sceneFeature)
        shaderManager = ShaderManager(this)

        requestSceneData()
        launchComposeActivity()

        registerReceiver(mediaSelectionReceiver, IntentFilter("com.meta.premiumsamples.premiummediasample.MEDIA_SELECTED"))
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(mediaSelectionReceiver)
    }

    override fun createFeatures(): List<SpatialFeature> {
        return listOf(passthroughFeature, sceneFeature)
    }

    override fun createSystems(): List<System> {
        return emptyList()
    }

    private fun requestSceneData() {
        val sceneRequest = SceneRequest(SceneRequestType.SCENE_DATA)
        sceneFeature.requestScene(sceneRequest) { result ->
            if (result == ScenePermissionState.GRANTED) {
                // Scene data is available
            }
        }
    }

    private fun launchComposeActivity() {
        val intent = Intent(this, ComposeActivity::class.java)
        startActivity(intent)
    }

    fun onMediaItemSelected(mediaItem: MediaItem) {
        currentPanel?.destroy()

        currentPanel = when (mediaItem.type) {
            MediaType.STANDARD -> StandardVideoPanel(this, mediaItem)
            MediaType.VIDEO_180 -> EquirectangularVideoPanel(this, mediaItem)
            MediaType.DRM -> DrmVideoPanel(this, mediaItem)
        }

        currentPanel?.let { panel ->
            sceneFeature.getScene().addChild(panel)
            mrukManager.findWallAndSnap(panel)

            val shader = shaderManager.loadShader("shaders/reflection.vert", "shaders/reflection.frag")
            if (shader != null) {
                shaderManager.applyShaderToSceneObject(panel, shader)
            }
        }
    }

    fun togglePassthrough() {
        if (passthroughFeature.isPassthroughEnabled) {
            passthroughFeature.disablePassthrough()
        } else {
            passthroughFeature.enablePassthrough()
        }
    }
}
