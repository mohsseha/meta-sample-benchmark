
package com.meta.spatial.premiummediasample

import androidx.media3.common.MediaItem as ExoMediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager
import androidx.media3.exoplayer.drm.FrameworkMediaDrm
import androidx.media3.exoplayer.drm.HttpMediaDrmCallback
import androidx.media3.exoplayer.source.DashMediaSource
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import java.util.UUID

class VideoPlayer(private val exoPlayer: ExoPlayer) {

    fun prepare(mediaItem: MediaItem) {
        val exoMediaItem = ExoMediaItem.fromUri(mediaItem.uri)
        val mediaSource = if (mediaItem.drmScheme == DrmScheme.WIDEVINE) {
            val drmSessionManager = DefaultDrmSessionManager.Builder()
                .setUuidAndExoMediaDrmProvider(
                    UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed"), // Widevine UUID
                    FrameworkMediaDrm.DEFAULT_PROVIDER
                )
                .build(HttpMediaDrmCallback(null, DefaultMediaSourceFactory(exoPlayer.context)))
            DashMediaSource.Factory(DefaultMediaSourceFactory(exoPlayer.context))
                .setDrmSessionManagerProvider { drmSessionManager }
                .createMediaSource(exoMediaItem)
        } else {
            ProgressiveMediaSource.Factory(DefaultMediaSourceFactory(exoPlayer.context))
                .createMediaSource(exoMediaItem)
        }

        exoPlayer.setMediaSource(mediaSource)
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
    }

    fun release() {
        exoPlayer.release()
    }
}
