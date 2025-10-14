package com.meta.premiumsamples.premiummediasample.data

import android.net.Uri

data class MediaItem(
    val title: String,
    val uri: Uri,
    val type: MediaType,
    val drmInfo: DrmInfo? = null,
    val thumbnailUrl: String
)

enum class MediaType {
    STANDARD,
    VIDEO_180,
    DRM
}

data class DrmInfo(
    val licenseUri: String,
    val scheme: String = "widevine"
)
