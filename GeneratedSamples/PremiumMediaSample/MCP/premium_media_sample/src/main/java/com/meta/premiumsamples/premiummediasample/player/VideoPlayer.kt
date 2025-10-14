package com.meta.premiumsamples.premiummediasample.player

import android.content.Context
import androidx.media3.common.MediaItem as ExoPlayerMediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager
import androidx.media3.exoplayer.drm.FrameworkMediaDrm
import androidx.media3.exoplayer.drm.HttpMediaDrmCallback
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory
import com.meta.premiumsamples.premiummediasample.data.MediaItem
import java.util.UUID

object VideoPlayer {

    private var exoPlayer: ExoPlayer? = null

    fun getPlayer(context: Context, mediaItem: MediaItem): ExoPlayer {
        if (exoPlayer == null) {
            exoPlayer = ExoPlayer.Builder(context).build()
        }

        val exoPlayerMediaItem = ExoPlayerMediaItem.Builder()
            .setUri(mediaItem.uri)

        if (mediaItem.drmInfo != null) {
            val drmSessionManager = DefaultDrmSessionManager.Builder()
                .setUuidAndExoMediaDrmProvider(
                    UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed"), // Widevine UUID
                    FrameworkMediaDrm.DEFAULT_PROVIDER
                )
                .build(HttpMediaDrmCallback(mediaItem.drmInfo.licenseUri, DefaultMediaSourceFactory(context)))
            exoPlayer?.setMediaSource(DefaultMediaSourceFactory(context).setDrmSessionManagerProvider { drmSessionManager }.createMediaSource(exoPlayerMediaItem.build()))
        } else {
            exoPlayer?.setMediaItem(exoPlayerMediaItem.build())
        }

        exoPlayer?.prepare()
        return exoPlayer!!
    }

    fun releasePlayer() {
        exoPlayer?.release()
        exoPlayer = null
    }
}
