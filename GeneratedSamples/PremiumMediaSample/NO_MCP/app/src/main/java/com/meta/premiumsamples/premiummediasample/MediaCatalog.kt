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

object MediaCatalog {
    val items = listOf(
        MediaItem(
            "Standard Video",
            "https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4",
            "https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4",
            MediaType.STANDARD
        ),
        MediaItem(
            "180 Degree Video",
            "https://storage.googleapis.com/exoplayer-test-media-1/360/congo.mp4",
            "https://storage.googleapis.com/exoplayer-test-media-1/360/congo.mp4",
            MediaType.EQUIRECTANGULAR_180
        ),
        MediaItem(
            "DRM Protected Video",
            "https://storage.googleapis.com/wvmedia/cenc/h264/tears/tears.mpd",
            "https://storage.googleapis.com/wvmedia/cenc/h264/tears/tears.mpd",
            MediaType.DRM_PROTECTED,
            "https://proxy.uat.widevine.com/proxy?provider=widevine_test"
        )
    )
}

data class MediaItem(
    val title: String,
    val videoUri: String,
    val thumbnailUri: String,
    val mediaType: MediaType,
    val drmLicenseUri: String? = null
)

enum class MediaType {
    STANDARD,
    EQUIRECTANGULAR_180,
    DRM_PROTECTED
}
