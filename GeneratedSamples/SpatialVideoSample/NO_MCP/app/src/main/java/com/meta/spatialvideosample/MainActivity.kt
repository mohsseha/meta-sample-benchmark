
package com.meta.spatialvideosample

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.Surface
import androidx.appcompat.app.AppCompatActivity
import com.meta.xr.sdk.Core
import com.meta.xr.sdk.Entity
import com.meta.xr.sdk.Scene
import com.meta.xr.sdk.component.Geometry
import com.meta.xr.sdk.component.Material
import com.meta.xr.sdk.component.Transform
import com.meta.xr.sdk.enums.Shape
import com.meta.xr.sdk.listener.SceneLifecycleListener
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    private lateinit var scene: Scene
    private var mediaPlayer: MediaPlayer? = null
    private var videoSurface: Surface? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Core.initialize(this)
        scene = Scene(this, object : SceneLifecycleListener {
            override fun onInit(scene: Scene) {
                setupScene(scene)
            }
        })
    }

    private fun setupScene(scene: Scene) {
        // Create a video panel
        val videoPanel = Entity()
        videoPanel.addComponent(Transform().apply {
            position.set(0.0f, 1.5f, -2.0f)
            scale.set(1.6f, 0.9f, 1.0f)
        })
        videoPanel.addComponent(Geometry(Shape.Quad))
        val material = Material()
        videoPanel.addComponent(material)
        scene.addEntity(videoPanel)

        // Create a placeholder video file
        val videoFile = createPlaceholderVideo()

        // Setup media player
        mediaPlayer = MediaPlayer().apply {
            setDataSource(applicationContext, Uri.fromFile(videoFile))
            setOnPreparedListener {
                videoSurface = Surface(material.getTexture())
                setSurface(videoSurface)
                isLooping = true
                start()
            }
            prepareAsync()
        }

        // Create a spatial audio source
        val audioSource = Entity()
        audioSource.addComponent(Transform().apply {
            position.set(0.0f, 1.5f, -2.0f)
        })
        // Attach the audio to the media player
        // This is a conceptual representation. The actual API might differ in v0.8.0
        // For the purpose of this sample, we will assume a component exists to link the audio
        // In a real scenario, you would use the appropriate Spatial SDK audio component
        // and configure it to use the MediaPlayer's audio session ID.
        // audioSource.addComponent(SpatialAudioSource(mediaPlayer.getAudioSessionId()));
        scene.addEntity(audioSource)
    }

    private fun createPlaceholderVideo(): File {
        val videoFile = File(cacheDir, "sample.mp4")
        if (!videoFile.exists()) {
            try {
                val inputStream = assets.open("sample.mp4")
                val outputStream = FileOutputStream(videoFile)
                inputStream.copyTo(outputStream)
                inputStream.close()
                outputStream.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return videoFile
    }

    override fun onResume() {
        super.onResume()
        scene.resume()
        mediaPlayer?.start()
    }

    override fun onPause() {
        super.onPause()
        scene.pause()
        mediaPlayer?.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
        videoSurface?.release()
        scene.destroy()
    }
}
