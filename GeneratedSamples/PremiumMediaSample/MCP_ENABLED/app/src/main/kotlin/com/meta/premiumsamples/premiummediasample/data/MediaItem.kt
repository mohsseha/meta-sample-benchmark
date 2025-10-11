package com.meta.premiumsamples.premiummediasample.data

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MediaItem(
    val id: String,
    val title: String,
    val description: String,
    val thumbnailUrl: String,
    val videoUrl: String,
    val type: MediaType,
    val drmInfo: DrmInfo? = null
) : Parcelable

@Parcelize
enum class MediaType : Parcelable {
    STANDARD,
    STANDARD_DRM,
    EQUIRECT_180
}

@Parcelize
data class DrmInfo(
    val licenseUrl: String,
    val scheme: String = "widevine"
) : Parcelable
