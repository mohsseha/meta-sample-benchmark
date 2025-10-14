/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.meta.spatialvideosample

import android.media.MediaPlayer
import android.os.Bundle
import android.view.Surface
import com.meta.xr.spatial.Headset
import com.meta.xr.spatial.SpatialActivity
import com.meta.xr.spatial.core.views.SpatialView
import com.meta.xr.spatial.core.views.VideoPlayerView
import com.meta.xr.spatial.core.views.VideoPlayerView.VideoPlayerViewArguments
import com.meta.xr.spatial.core.views.updateVideoView
import com.meta.xr.spatial.views.SpatialEnvironment

class MainActivity : SpatialActivity() {

    private lateinit var videoPlayerView: VideoPlayerView
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up the scene
        setupScene()

        // Set up the video player
        setupVideoPlayer()
    }

    private fun setupScene() {
        // Create a skybox
        SpatialEnvironment.setBackground(this, SpatialEnvironment.Background.SKY_2)

        // Create a video player view
        videoPlayerView = VideoPlayerView(
            this,
            VideoPlayerViewArguments(
                videoUri = "asset:///sample.mp4",
                autoPlay = true,
                width = 2.0f,
                height = 1.0f,
                surfaceReadyCallback = { surface ->
                    // The surface is ready, so we can start the media player
                    startMediaPlayer(surface)
                }
            )
        )

        // Position the video player view in front of the user
        videoPlayerView.translation.z = -3.0f

        // Add the video player view to the scene
        contentView.addView(videoPlayerView)
    }

    private fun setupVideoPlayer() {
        // Create a media player
        mediaPlayer = MediaPlayer.create(this, R.raw.sample)

        // Set the media player to loop
        mediaPlayer.isLooping = true

        // Enable spatial audio
        mediaPlayer.isSpatialized = true
    }

    private fun startMediaPlayer(surface: Surface) {
        // Set the surface for the media player
        mediaPlayer.setSurface(surface)

        // Start the media player
        mediaPlayer.start()
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer.pause()
    }

    override fun onResume() {
        super.onResume()
        if (!mediaPlayer.isPlaying) {
            mediaPlayer.start()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}
