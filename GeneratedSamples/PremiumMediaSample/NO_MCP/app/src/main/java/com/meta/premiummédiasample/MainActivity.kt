package com.meta.premiummédiasample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.meta.premiummédiasample.data.MediaCatalog
import com.meta.premiummédiasample.data.MediaItem
import com.meta.premiummédiasample.data.MediaType
import com.meta.premiummédiasample.panels.DirectToSurfaceVideoPanel
import com.meta.premiummédiasample.panels.EquirectangularVideoPanel
import com.meta.premiummédiasample.panels.StandardVideoPanel
import com.meta.premiummédiasample.playback.MediaPlayer
import com.meta.premiummédiasample.shaders.ShaderManager
import com.meta.spatial.PermissionState
import com.meta.spatial.Permissions
import com.meta.spatial.Scene
import com.meta.spatial.SpatialSdk
import com.meta.spatial.entities.Entity
import com.meta.spatial.entities.SceneEntity
import com.meta.spatial.geometry.Pose
import com.meta.spatial.geometry.Quaternion
import com.meta.spatial.geometry.Vector3
import com.meta.spatial.graphics.Renderable
import com.meta.spatial.scene.Anchor
import com.meta.spatial.scene.RoomLayout
import com.meta.spatial.scene.SceneCapture
import com.meta.spatial.scene.queries.SceneQueries
import com.meta.spatial.systems.PassthroughSystem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private lateinit var scene: Scene
    private lateinit var passthroughSystem: PassthroughSystem
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    companion object {
        private const val MEDIA_SELECTION_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        scene = SpatialSdk.createScene(this)
        passthroughSystem = scene.getSystem(PassthroughSystem::class.java)

        if (Permissions.queryPermission(Permissions.Permission.SCENE_DATA) != PermissionState.GRANTED) {
            Permissions.requestPermission(Permissions.Permission.SCENE_DATA)
        }

        coroutineScope.launch {
            SceneCapture.captureScene()
        }

        setupScene()

        val intent = Intent(this, MediaSelectionActivity::class.java)
        startActivityForResult(intent, MEDIA_SELECTION_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == MEDIA_SELECTION_REQUEST_CODE && resultCode == RESULT_OK) {
            val mediaId = data?.getStringExtra("mediaId")
            if (mediaId != null) {
                val mediaItem = MediaCatalog.items.find { it.id == mediaId }
                if (mediaItem != null) {
                    createPanelForMedia(mediaItem)
                }
            }
        }
    }

    private fun createPanelForMedia(mediaItem: MediaItem) {
        val mediaPlayer = MediaPlayer(this)
        val panelSystem = scene.getSystem(PanelSystem::class.java)
        val panelEntity = scene.createEntity()

        val roomLayout = SceneQueries.getRoomLayout(scene)
        val wallAnchors = roomLayout?.getAnchors(RoomLayout.Label.WALL_FACE)
        val wallAnchor = wallAnchors?.firstOrNull()

        when (mediaItem.type) {
            MediaType.STANDARD -> {
                val panel = StandardVideoPanel(panelEntity, panelSystem)
                panel.setSurfaceProvider { mediaPlayer.getExoPlayer().setVideoSurface(it) }
                wallAnchor?.let { panel.snapToAnchor(it) }
            }
            MediaType.EQUIRECTANGULAR_180 -> {
                val panel = EquirectangularVideoPanel(panelEntity, panelSystem)
                panel.setSurfaceProvider { mediaPlayer.getExoPlayer().setVideoSurface(it) }
                wallAnchor?.let { panel.snapToAnchor(it) }
            }
            MediaType.STANDARD_DRM -> {
                val panel = DirectToSurfaceVideoPanel(panelEntity, panelSystem)
                mediaPlayer.getExoPlayer().setVideoSurface(panel.getSurface())
                wallAnchor?.let { panel.snapToAnchor(it) }
            }
        }

        mediaPlayer.play(mediaItem)
    }


    private fun setupScene() {
        val rootEntity = scene.getRoot()
        val roomLayout = SceneQueries.getRoomLayout(scene)

        if (roomLayout != null) {
            val wallAnchors = roomLayout.getAnchors(RoomLayout.Label.WALL_FACE)
            if (wallAnchors.isNotEmpty()) {
                val wallAnchor = wallAnchors[0]
                val shaderManager = ShaderManager(this)
                val sceneTexture = passthroughSystem.getSceneTexture()
                val reflectionMaterial = shaderManager.createReflectionMaterial(sceneTexture)
                wallAnchor.getEntity().getOrCreateComponent(Renderable::class.java).setMaterial(reflectionMaterial)
            }
        }
    }

    fun createAndSnapPanel(anchor: Anchor) {
        // This is where we will create and snap the video panels to the wall.
        // We will implement this later.
    }

    override fun onResume() {
        super.onResume()
        scene.resume()
    }

    override fun onPause() {
        super.onPause()
        scene.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        scene.destroy()
    }
}
