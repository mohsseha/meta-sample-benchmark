package com.meta.premiumsamples.premiummediasample.data

import android.net.Uri

object MediaLibrary {

    fun getMediaItems(): List<MediaItem> {
        return listOf(
            MediaItem(
                title = "Standard Video",
                uri = Uri.parse("https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4"),
                type = MediaType.STANDARD,
                thumbnailUrl = "https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4"
            ),
            MediaItem(
                title = "180 Degree Video",
                uri = Uri.parse("https://storage.googleapis.com/exoplayer-test-media-1/360/congo.mp4"),
                type = MediaType.VIDEO_180,
                thumbnailUrl = "https://storage.googleapis.com/exoplayer-test-media-1/360/congo.mp4"
            ),
            MediaItem(
                title = "DRM Protected Video",
                uri = Uri.parse("https://storage.googleapis.com/wvmedia/cenc/h264/tears/tears.mpd"),
                type = MediaType.DRM,
                drmInfo = DrmInfo(
                    licenseUri = "https://proxy.uat.widevine.com/proxy?provider=widevine_test"
                ),
                thumbnailUrl = "https://storage.googleapis.com/wvmedia/cenc/h264/tears/tears.mpd"
            )
        )
    }
}
