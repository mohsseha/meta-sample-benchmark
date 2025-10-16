
package com.metaspatial.spatialsound

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.Surface
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.FrameLayout
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.meta.spatial.sdk.ISystem
import com.meta.spatial.sdk.SystemManager
import com.meta.spatial.sdk.components.Panel
import com.meta.spatial.sdk.components.Position
import com.meta.spatial.sdk.components.Rotation
import com.meta.spatial.sdk.components.Scale
import com.meta.spatial.sdk.components.Visible
import com.meta.spatial.sdk.core.Entity
import com.meta.spatial.sdk.core.Scene
import com.meta.spatial.sdk.scenes.DefaultScene
import com.meta.spatial.sdk.systems.audio.SpatialAudioSystem
import com.meta.spatial.sdk.systems.audio.components.SpatialSound
import com.meta.spatial.sdk.types.Vector3

class SceneManager(private val systemManager: SystemManager) : ISystem, SurfaceHolder.Callback {

    private lateinit var scene: Scene
    private lateinit var videoPanel: Entity
    private lateinit var exoPlayer: ExoPlayer
    private lateinit var context: Context
    private lateinit var surfaceView: SurfaceView

    override fun onEnter() {
        context = systemManager.context
        scene = DefaultScene(systemManager.context)
        systemManager.registerSystem(scene)

        // Enable spatial audio
        systemManager.registerSystem(SpatialAudioSystem(systemManager.context))

        createVideoPanel()
        setupVideoPlayer()
    }

    private fun createVideoPanel() {
        val inflater = LayoutInflater.from(context)
        val panelLayout = inflater.inflate(R.layout.video_panel_layout, null) as FrameLayout
        surfaceView = panelLayout.findViewById(R.id.surface_view)
        surfaceView.holder.addCallback(this)

        videoPanel = scene.createEntity("VideoPanel")
        videoPanel.setComponent(Position(Vector3(0f, 0f, -2f)))
        videoPanel.setComponent(Rotation(Vector3(0f, 0f, 0f)))
        videoPanel.setComponent(Scale(Vector3(1.77f, 1f, 1f))) // 16:9 aspect ratio
        videoPanel.setComponent(Visible(true))
        videoPanel.setComponent(Panel(panelLayout))
    }

    private fun setupVideoPlayer() {
        exoPlayer = ExoPlayer.Builder(context).build()

        val videoUri = Uri.parse("asset:///sample_video.mp4")
        val mediaItem = MediaItem.fromUri(videoUri)
        val mediaSource = ProgressiveMediaSource.Factory(DefaultDataSource.Factory(context))
            .createMediaSource(mediaItem)

        exoPlayer.setMediaSource(mediaSource)
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true

        // Attach spatial sound to the video panel
        val spatialSound = SpatialSound(videoUri.toString())
        spatialSound.isSpatialized = true
        videoPanel.setComponent(spatialSound)
    }

    override fun onExit() {
        exoPlayer.release()
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        exoPlayer.setVideoSurface(holder.surface)
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        // No-op
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        exoPlayer.setVideoSurface(null)
    }
}
