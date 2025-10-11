package com.meta.spatial.mediaplayersample.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.meta.spatial.mediaplayersample.VideoViewModel
import com.meta.spatial.sdk.compose.Panel
import com.meta.spatial.sdk.compose.Scene
import com.meta.spatial.sdk.compose.rememberScene

@Composable
fun MainScene() {
    val viewModel: VideoViewModel = viewModel()
    val videos by viewModel.videos.collectAsState()
    val selectedVideo by viewModel.selectedVideo.collectAsState()
    val isPassthroughEnabled by viewModel.isPassthroughEnabled.collectAsState()

    val scene = rememberScene {
        // Create the video list panel
        Panel {
            VideoList(videos = videos, onVideoSelected = { viewModel.onVideoSelected(it) })
        }

        // Create the video player panel
        selectedVideo?.let { video ->
            Panel {
                VideoPlayer(videoUrl = video.videoUrl)
            }
        }
    }

    Scene(scene = scene, passthrough = isPassthroughEnabled)
}
