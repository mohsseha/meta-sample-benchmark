package com.meta.premiumsamples.premiummediasample.data

object MediaRepository {

    fun getMediaItems(): List<MediaItem> {
        return listOf(
            MediaItem(
                id = "1",
                title = "Standard Video",
                thumbnailUrl = "https://via.placeholder.com/150",
                videoUrl = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                type = MediaType.STANDARD
            ),
            MediaItem(
                id = "2",
                title = "180 Degree Video",
                thumbnailUrl = "https://via.placeholder.com/150",
                videoUrl = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
                type = MediaType.EQUIRECT_180
            ),
            MediaItem(
                id = "3",
                title = "DRM Protected Video",
                thumbnailUrl = "https://via.placeholder.com/150",
                videoUrl = "https://storage.googleapis.com/wvmedia/cenc/h264/tears/tears.mpd",
                type = MediaType.STANDARD_DRM,
                drmInfo = DrmInfo(
                    licenseUrl = "https://proxy.uat.widevine.com/proxy?provider=widevine_test"
                )
            )
        )
    }
}
