package com.metaspatial.spatialsound

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ext.spatial.SpatialAudioHelper
import com.google.android.exoplayer2.Player
import com.meta.spatialsdk.Features
import com.meta.spatialsdk.SpatialSDK
import com.meta.spatialsdk.features.SpatialAudioFeature
import com.meta.spatialsdk.scenes.Scene
import com.meta.spatialsdk.scenes.components.Position
import com.meta.spatialsdk.scenes.components.Rotation
import com.meta.spatialsdk.scenes.components.Scale
import com.meta.spatialsdk.scenes.components.VideoPlayer
import com.meta.spatialsdk.systems.SystemBase
import com.meta.spatialsdk.systems.UpdateContext
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var spatialSDK: SpatialSDK
    private var exoPlayer: ExoPlayer? = null
    private var videoPlayerEntity: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        spatialSDK = SpatialSDK(this)
        spatialSDK.initialize(MySystem())

        setupScene()
        setupVideoPlayer()
        setupSpatialAudio()
    }

    private fun setupScene() {
        val scene = spatialSDK.scene
        scene.createEntity().apply {
            addComponent(Position(0f, 0f, -2f))
            addComponent(Rotation(0f, 0f, 0f))
            addComponent(Scale(1f, 1f, 1f))
            videoPlayerEntity = this.id
        }
    }

    private fun setupVideoPlayer() {
        exoPlayer = ExoPlayer.Builder(this).build()
        val videoUri = Uri.parse("android.resource://$packageName/${R.raw.video}")
        val mediaItem = MediaItem.fromUri(videoUri)
        exoPlayer?.setMediaItem(mediaItem)
        exoPlayer?.prepare()
        exoPlayer?.playWhenReady = true

        val videoPlayerComponent = VideoPlayer(exoPlayer!!)
        spatialSDK.scene.getEntity(videoPlayerEntity).addComponent(videoPlayerComponent)
    }

    private fun setupSpatialAudio() {
        val spatialAudioFeature = spatialSDK.features.getFeature(Features.SPATIAL_AUDIO) as SpatialAudioFeature
        exoPlayer?.let {
            val audioSessionId = it.audioSessionId
            spatialAudioFeature.registerAudioSessionId(audioSessionId)
        }
    }

    override fun onResume() {
        super.onResume()
        spatialSDK.resume()
        exoPlayer?.play()
    }

    override fun onPause() {
        super.onPause()
        spatialSDK.pause()
        exoPlayer?.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        spatialSDK.destroy()
        exoPlayer?.release()
    }

    inner class MySystem : SystemBase() {
        override fun onUpdate(context: UpdateContext) {
            // System update logic can be added here if needed
        }
    }
}
