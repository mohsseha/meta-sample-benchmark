/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.meta.premiumsamples.premiummediasample

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager
import androidx.media3.exoplayer.drm.FrameworkMediaDrm
import androidx.media3.exoplayer.drm.HttpMediaDrmCallback
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory
import java.util.UUID

class MediaPlayer(private val context: Context) {

    private var exoPlayer: ExoPlayer? = null

    fun getExoPlayer(): ExoPlayer {
        if (exoPlayer == null) {
            exoPlayer = ExoPlayer.Builder(context).build()
        }
        return exoPlayer!!
    }

    fun prepare(mediaItem: com.meta.premiumsamples.premiummediasample.MediaItem) {
        val exoPlayer = getExoPlayer()
        val mediaItemBuilder = MediaItem.Builder().setUri(mediaItem.videoUri)

        // For DRM-protected content, we need to configure a DRM session manager.
        if (mediaItem.mediaType == MediaType.DRM_PROTECTED) {
            // The DefaultDrmSessionManager is used to manage the DRM session.
            // We need to provide a UUID for the DRM scheme (in this case, Widevine).
            val drmSessionManager = DefaultDrmSessionManager.Builder()
                .setUuidAndExoMediaDrmProvider(
                    UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed"), // Widevine
                    FrameworkMediaDrm.DEFAULT_PROVIDER
                )
                .build(
                    // The HttpMediaDrmCallback is used to get the DRM license from the license server.
                    HttpMediaDrmCallback(mediaItem.drmLicenseUri, DefaultMediaSourceFactory(context))
                )
            exoPlayer.mediaSourceFactory = DefaultMediaSourceFactory(context).setDrmSessionManagerProvider { drmSessionManager }
        }

        exoPlayer.setMediaItem(mediaItemBuilder.build())
        exoPlayer.prepare()
    }

    fun release() {
        exoPlayer?.release()
        exoPlayer = null
    }
}
