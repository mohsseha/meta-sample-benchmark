package com.meta.premiumsamples.premiummediasample.panels

import android.content.Context
import androidx.media3.common.C
import androidx.media3.common.MediaItem as ExoPlayerMediaItem
import com.meta.premiumsamples.premiummediasample.data.MediaItem
import com.meta.premiumsamples.premiummediasample.player.VideoPlayer
import com.meta.spatial.scene.DirectToSurfacePanel

class EquirectangularVideoPanel(
    private val context: Context,
    private val mediaItem: MediaItem
) : DirectToSurfacePanel(
    width = 4096,
    height = 2048,
    name = "EquirectangularVideoPanel"
) {

    override fun onSurfaceReady(surface: Any) {
        val player = VideoPlayer.getPlayer(context, mediaItem)

        val exoPlayerMediaItem = ExoPlayerMediaItem.Builder()
            .setUri(mediaItem.uri)
            .setMimeType("video/mp4")
            .build()

        player.setVideoSurface(surface as android.view.Surface)
        player.setMediaItem(exoPlayerMediaItem)
        player.prepare()
        player.play()
    }
}
