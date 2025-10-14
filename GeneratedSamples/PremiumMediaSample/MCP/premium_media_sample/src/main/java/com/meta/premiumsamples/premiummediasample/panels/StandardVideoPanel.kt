package com.meta.premiumsamples.premiummediasample.panels

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.ui.PlayerView
import com.meta.premiumsamples.premiummediasample.data.MediaItem
import com.meta.premiumsamples.premiummediasample.player.VideoPlayer
import com.meta.spatial.compose.ComposePanel

class StandardVideoPanel(
    private val context: Context,
    private val mediaItem: MediaItem
) : ComposePanel(
    width = 1920,
    height = 1080,
    name = "StandardVideoPanel"
) {

    @Composable
    override fun Content() {
        val player = VideoPlayer.getPlayer(context, mediaItem)
        AndroidView(factory = {
            PlayerView(it).apply {
                this.player = player
            }
        })
    }
}
