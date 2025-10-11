package com.meta.premiumsamples.premiummediasample.panels

import android.content.Context
import com.meta.premiumsamples.premiummediasample.data.MediaItem
import com.meta.premiumsamples.premiummediasample.player.VideoPlayer
import com.meta.spatial.sdk.scene.Scene
import com.meta.spatial.sdk.scene.panel.VideoSurfacePanel
import com.meta.spatial.sdk.scene.panel.registration.VideoSurfacePanelRegistration

class StandardVideoPanel(
    scene: Scene,
    private val context: Context,
    private val mediaItem: MediaItem
) : BasePanel(scene) {

    private val videoPlayer = VideoPlayer(context)

    override fun create() {
        val registration = VideoSurfacePanelRegistration.Builder(
            "standard_video_panel",
            1920,
            1080
        ).build()

        panel = scene.createPanel(registration)
        (panel as? VideoSurfacePanel)?.let {
            videoPlayer.getPlayer().setVideoSurface(it.surface)
        }
        videoPlayer.prepare(mediaItem)
        videoPlayer.getPlayer().play()
    }

    override fun destroy() {
        videoPlayer.release()
        super.destroy()
    }
}
