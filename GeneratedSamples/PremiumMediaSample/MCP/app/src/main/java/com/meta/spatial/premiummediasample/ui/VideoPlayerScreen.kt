
package com.meta.spatial.premiummediasample.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.meta.spatial.premiummediasample.MediaItem
import com.meta.spatial.premiummediasample.VideoPlayer
import com.meta.spatial.scene.Scene
import com.meta.spatial.scene.Visible

@Composable
fun VideoPlayerScreen(mediaItem: MediaItem) {
    val context = LocalContext.current
    val exoPlayer = remember { ExoPlayer.Builder(context).build() }
    val videoPlayer = remember { VideoPlayer(exoPlayer) }
    var passthroughEnabled by remember { mutableStateOf(false) }
    val scene = Scene.current

    DisposableEffect(Unit) {
        videoPlayer.prepare(mediaItem)
        onDispose {
            videoPlayer.release()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(
            factory = { context ->
                PlayerView(context).apply {
                    player = exoPlayer
                }
            },
            modifier = Modifier.fillMaxSize()
        )

        Button(
            onClick = {
                passthroughEnabled = !passthroughEnabled
                scene.enablePassthrough(passthroughEnabled)
                scene.skyboxEntity.setComponent(Visible(!passthroughEnabled))
            },
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Text(text = if (passthroughEnabled) "Disable Passthrough" else "Enable Passthrough")
        }
    }
}
