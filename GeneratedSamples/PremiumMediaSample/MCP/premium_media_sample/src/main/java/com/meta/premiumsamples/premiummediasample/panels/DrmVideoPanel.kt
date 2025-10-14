package com.meta.premiumsamples.premiummediasample.panels

import android.content.Context
import com.meta.premiumsamples.premiummediasample.data.MediaItem
import com.meta.premiumsamples.premiummediasample.player.VideoPlayer
import com.meta.spatial.scene.DirectToSurfacePanel

class DrmVideoPanel(
    private val context: Context,
    private val mediaItem: MediaItem
) : DirectToSurfacePanel(
    width = 1920,
    height = 1080,
    name = "DrmVideoPanel"
) {

    override fun onSurfaceReady(surface: Any) {
        val player = VideoPlayer.getPlayer(context, mediaItem)
        player.setVideoSurface(surface as android.view.Surface)
        player.play()
    }
}
