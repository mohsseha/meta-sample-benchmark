package com.meta.spatialvideosample

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import com.meta.spatial.sdk.*
import com.meta.spatial.sdk.activities.SpatialActivity
import com.meta.spatial.sdk.audio.SpatialAudio
import com.meta.spatial.sdk.audio.SpatialAudioSource
import com.meta.spatial.sdk.components.Panel
import com.meta.spatial.sdk.components.Transform
import com.meta.spatial.sdk.math.Vector3

/**
 * This activity demonstrates how to play a video with spatialized audio in the Meta Spatial SDK.
 * The audio will sound as if it's coming from the video panel's location in 3D space.
 */
class VideoPlayerActivity : SpatialActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var spatialAudioSource: SpatialAudioSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up the 3D scene with a skybox and a video panel.
        setupScene()

        // Initialize the Android MediaPlayer to handle video playback.
        initializeMediaPlayer()
    }

    /**
     * Creates the 3D environment for the video playback experience.
     * This includes a skybox for immersion and a panel to display the video.
     */
    private fun setupScene() {
        // Create a skybox to provide a sense of being in a virtual environment.
        val skybox = createEntity("skybox")
        skybox.add<Panel> {
            // Use a sphere for the skybox geometry.
            shape = Panel.Shape.Sphere
            // Make the inside of the sphere visible.
            isBackFaceVisible = true
            // Apply the skybox texture.
            setTexture(assets.open("skybox.png"))
        }
        skybox.get<Transform> {
            // Scale the skybox to be large enough to encompass the scene.
            scale = Vector3(100.0f, 100.0f, 100.0f)
        }

        // Create a panel entity that will display the video content.
        val videoPanel = createEntity("videoPanel")
        videoPanel.add<Panel> {
            // Use a quad (a flat rectangle) for the video panel.
            shape = Panel.Shape.Quad
            // Set the dimensions of the panel (16:9 aspect ratio).
            width = 4.0f
            height = 2.25f
        }
        videoPanel.get<Transform> {
            // Position the panel in front of the user.
            position = Vector3(0.0f, 0.0f, -4.0f)
        }

        // Set the video content for the panel.
        val videoUri = Uri.parse("asset:///sample.mp4")
        videoPanel.get<Panel>().setVideo(videoUri)
    }

    /**
     * Initializes the MediaPlayer to play the video file.
     * The audio from this MediaPlayer will be spatialized.
     */
    private fun initializeMediaPlayer() {
        // Create a new instance of MediaPlayer.
        mediaPlayer = MediaPlayer()

        // Set the data source for the media player from the assets folder.
        val assetFileDescriptor = assets.openFd("sample.mp4")
        mediaPlayer.setDataSource(
            assetFileDescriptor.fileDescriptor,
            assetFileDescriptor.startOffset,
            assetFileDescriptor.length
        )
        assetFileDescriptor.close()

        // Enable looping to have the video play continuously.
        mediaPlayer.isLooping = true

        // Prepare the media player asynchronously.
        mediaPlayer.prepareAsync()

        // Set a listener to be called when the media player is prepared.
        mediaPlayer.setOnPreparedListener {
            // Start playing the video.
            it.start()

            // Once the video is playing, spatialize its audio.
            spatializeAudio(it)
        }
    }

    /**
     * Configures the spatial audio for the given MediaPlayer.
     * This function creates a spatial audio source and attaches it to the video panel.
     *
     * @param mediaPlayer The MediaPlayer instance whose audio needs to be spatialized.
     */
    private fun spatializeAudio(mediaPlayer: MediaPlayer) {
        // Get the SpatialAudio system, which is responsible for managing all spatial audio sources.
        val spatialAudio = world.getSystem(SpatialAudio::class.java)

        // Create a new spatial audio source.
        spatialAudioSource = spatialAudio.createSpatialAudioSource()

        // Attach the MediaPlayer to the spatial audio source.
        // This directs the audio output of the MediaPlayer to the spatial audio system.
        spatialAudioSource.setMediaPlayer(mediaPlayer)

        // Find the video panel entity in the scene.
        val videoPanel = findEntity("videoPanel")

        // Attach the audio source to the video panel's transform.
        // This is the crucial step that makes the audio emanate from the panel's location.
        // The SpatialAudio system will automatically update the audio's position and orientation
        // based on the user's head position relative to the panel.
        if (videoPanel != null) {
            spatialAudioSource.setTransform(videoPanel.get<Transform>())
        }
    }

    override fun onPause() {
        super.onPause()
        // Pause the video when the activity is paused.
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
        }
    }

    override fun onResume() {
        super.onResume()
        // Resume the video when the activity is resumed.
        if (!mediaPlayer.isPlaying) {
            mediaPlayer.start()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Release the resources used by the MediaPlayer and SpatialAudioSource.
        mediaPlayer.release()
        spatialAudioSource.release()
    }
}