package com.meta.mediaplayersample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView
import com.meta.spatial.core.AppSystemActivity
import com.meta.spatial.core.Panel
import com.meta.spatial.core.PanelConfig
import com.meta.spatial.core.Visible
import com.meta.spatial.core.WorldLock
import com.meta.spatial.core.components.Position
import com.meta.spatial.core.components.Rotation
import com.meta.spatial.core.components.Scale
import com.meta.spatial.core.components.Surface
import com.meta.spatial.core.systems.PanelSystem
import com.meta.spatial.core.systems.PassthroughSystem
import com.meta.mediaplayersample.ui.VideoListPanel
import com.meta.mediaplayersample.ui.theme.MediaPlayerSampleTheme

class MainActivity : AppSystemActivity() {

    private val viewModel: VideoPlayerViewModel by viewModels()
    private var player: ExoPlayer? = null
    private lateinit var playerView: PlayerView
    private var videoPanel: Panel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Register systems
        systemManager.registerSystem(PanelSystem(this))
        systemManager.registerSystem(PassthroughSystem(this))

        // Spawn the video list panel
        spawnVideoListPanel()

        // Observe the selected video
        viewModel.selectedVideo.observe(this) { video ->
            video?.let {
                playVideo(it.videoUrl)
            }
        }

        // Observe passthrough state
        viewModel.isPassthroughEnabled.observe(this) { isEnabled ->
            scene.enablePassthrough(isEnabled)
            // This assumes you have a skybox entity, which is common in spatial apps.
            // If you don't have one, you can ignore this line.
            scene.query().filter(listOf("skybox")).firstOrNull()?.setComponent(Visible(!isEnabled))
        }
    }

    private fun spawnVideoListPanel() {
        val panelSystem = systemManager.getSystem(PanelSystem::class.java)
        val panel = panelSystem.createPanel(
            PanelConfig(
                width = 400,
                height = 600,
                dpi = 140
            )
        )
        panel.setComposeContent {
            MediaPlayerSampleTheme {
                VideoListPanel(viewModel = viewModel)
            }
        }
        panel.entity.setComponent(Position(x = -1.5f, y = 1.5f, z = -2.0f))
        panel.entity.setComponent(WorldLock(true))
    }

    private fun playVideo(videoUrl: String) {
        if (player == null) {
            player = ExoPlayer.Builder(this).build()
            playerView = PlayerView(this)
            playerView.player = player

            val panelSystem = systemManager.getSystem(PanelSystem::class.java)
            videoPanel = panelSystem.createPanel(
                PanelConfig(
                    width = 1280,
                    height = 720,
                    dpi = 240
                )
            )
            videoPanel?.entity?.setComponent(Surface(playerView.surface))
            videoPanel?.entity?.setComponent(Position(x = 0.0f, y = 1.5f, z = -3.0f))
            videoPanel?.entity?.setComponent(Rotation(x = 0.0f, y = 0.0f, z = 0.0f))
            videoPanel?.entity?.setComponent(Scale(x = 2.0f, y = 2.0f, z = 2.0f))
            videoPanel?.entity?.setComponent(WorldLock(true))
        }

        val mediaItem = MediaItem.fromUri(videoUrl)
        player?.setMediaItem(mediaItem)
        player?.prepare()
        player?.play()
    }

    override fun onPause() {
        super.onPause()
        player?.pause()
    }

    override fun onResume() {
        super.onResume()
        player?.play()
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.release()
    }
}
