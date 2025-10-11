package com.meta.premiumsamples.premiummediasample.player

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager
import androidx.media3.exoplayer.drm.FrameworkMediaDrm
import androidx.media3.exoplayer.drm.HttpMediaDrmCallback
import androidx.media3.exoplayer.source.DashMediaSource
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.datasource.DefaultHttpDataSource
import com.meta.premiumsamples.premiummediasample.data.DrmInfo
import java.util.UUID

class VideoPlayer(private val context: Context) {

    private var exoPlayer: ExoPlayer? = null

    fun getPlayer(): ExoPlayer {
        if (exoPlayer == null) {
            exoPlayer = ExoPlayer.Builder(context).build()
        }
        return exoPlayer!!
    }

    fun prepare(mediaItem: com.meta.premiumsamples.premiummediasample.data.MediaItem) {
        val player = getPlayer()
        val mediaItem3 = MediaItem.fromUri(mediaItem.videoUrl)

        val mediaSource = if (mediaItem.drmInfo != null) {
            val drmCallback = HttpMediaDrmCallback(mediaItem.drmInfo.licenseUrl, DefaultHttpDataSource.Factory())
            val drmSessionManager = DefaultDrmSessionManager.Builder()
                .setUuidAndExoMediaDrmProvider(UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed"), FrameworkMediaDrm.DEFAULT_PROVIDER)
                .build(drmCallback)
            DashMediaSource.Factory(DefaultDataSource.Factory(context))
                .setDrmSessionManagerProvider { drmSessionManager }
                .createMediaSource(mediaItem3)
        } else {
            ProgressiveMediaSource.Factory(DefaultDataSource.Factory(context))
                .createMediaSource(mediaItem3)
        }

        player.setMediaSource(mediaSource)
        player.prepare()
    }

    fun release() {
        exoPlayer?.release()
        exoPlayer = null
    }
}
