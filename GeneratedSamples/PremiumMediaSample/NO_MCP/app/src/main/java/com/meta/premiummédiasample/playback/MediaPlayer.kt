package com.meta.premiummédiasample.playback

import android.content.Context
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager
import com.google.android.exoplayer2.drm.FrameworkMediaDrm
import com.google.android.exoplayer2.drm.HttpMediaDrmCallback
import com.google.android.exoplayer2.source.dash.DashMediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.meta.premiummédiasample.data.MediaItem as AppMediaItem

class MediaPlayer(context: Context) {

    private var exoPlayer: ExoPlayer = ExoPlayer.Builder(context).build()

    fun getExoPlayer(): ExoPlayer {
        return exoPlayer
    }

    fun play(mediaItem: AppMediaItem) {
        val exoMediaItem = MediaItem.fromUri(mediaItem.videoUrl)

        if (mediaItem.drmLicenseUrl != null) {
            val drmSessionManager = DefaultDrmSessionManager.Builder()
                .setUuidAndExoMediaDrmProvider(
                    FrameworkMediaDrm.WIDEVINE_UUID,
                    FrameworkMediaDrm.DEFAULT_PROVIDER
                )
                .build(
                    HttpMediaDrmCallback(
                        mediaItem.drmLicenseUrl,
                        DefaultHttpDataSource.Factory()
                    )
                )

            val mediaSource = DashMediaSource.Factory(DefaultHttpDataSource.Factory())
                .setDrmSessionManagerProvider { drmSessionManager }
                .createMediaSource(exoMediaItem)

            exoPlayer.setMediaSource(mediaSource)
        } else {
            exoPlayer.setMediaItem(exoMediaItem)
        }

        exoPlayer.prepare()
        exoPlayer.play()
    }

    fun release() {
        exoPlayer.release()
    }
}
