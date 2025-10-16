
package com.meta.spatial.premiummediasample

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MediaItem(
    val id: String,
    val title: String,
    val uri: String,
    val thumbnailUrl: String,
    val mediaType: MediaType,
    val drmScheme: DrmScheme? = null
) : Parcelable

enum class MediaType {
    STANDARD,
    VIDEO_180
}

enum class DrmScheme {
    WIDEVINE
}
