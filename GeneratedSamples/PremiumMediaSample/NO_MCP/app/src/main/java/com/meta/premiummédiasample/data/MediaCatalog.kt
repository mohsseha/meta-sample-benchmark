package com.meta.premiummédiasample.data

data class MediaItem(
    val id: String,
    val title: String,
    val thumbnailUrl: String,
    val videoUrl: String,
    val type: MediaType,
    val drmLicenseUrl: String? = null
)

enum class MediaType {
    STANDARD,
    STANDARD_DRM,
    EQUIRECTANGULAR_180
}

object MediaCatalog {
    val items = listOf(
        MediaItem(
            id = "1",
            title = "Standard Video",
            thumbnailUrl = "file:///android_asset/thumbnails/standard.png",
            videoUrl = "https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4",
            type = MediaType.STANDARD
        ),
        MediaItem(
            id = "2",
            title = "DRM Protected Video",
            thumbnailUrl = "file:///android_asset/thumbnails/drm.png",
            videoUrl = "https://storage.googleapis.com/wvmedia/cenc/h264/tears/tears.mpd",
            type = MediaType.STANDARD_DRM,
            drmLicenseUrl = "https://proxy.uat.widevine.com/proxy?provider=widevine_test"
        ),
        MediaItem(
            id = "3",
            title = "180-degree Video",
            thumbnailUrl = "file:///android_asset/thumbnails/180.png",
            videoUrl = "https://storage.googleapis.com/exoplayer-test-media-1/360/congo.mp4",
            type = MediaType.EQUIRECTANGULAR_180
        )
    )
}
