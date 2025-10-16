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

import com.meta.xr.spatial.sdk.base.Panel
import com.meta.xr.spatial.sdk.base.PanelManager
import com.meta.xr.spatial.sdk.base.PanelType
import com.meta.xr.spatial.sdk.compose.ComposePanelRegistration
import com.meta.xr.spatial.sdk.video.VideoPanel
import com.meta.xr.spatial.sdk.video.VideoPanelRegistration

class PanelManager(private val panelManager: PanelManager) {

    /**
     * Creates a panel of the appropriate type for the given [MediaItem].
     */
    fun createPanelForMedia(mediaItem: MediaItem): Panel {
        return when (mediaItem.mediaType) {
            // For standard video, we use a ComposePanel to display the video.
            // This allows us to easily add UI elements on top of the video.
            MediaType.STANDARD -> {
                val composePanelRegistration = ComposePanelRegistration.create("standard-video-panel")
                composePanelRegistration.setComposeContent {
                    // We'll add the video player UI here later.
                }
                val panel = panelManager.createPanel(composePanelRegistration)
                panel.panelType = PanelType.FLAT
                panel
            }
            // For 180-degree video, we use a VideoPanel with a spherical panel type.
            // This allows the video to be displayed in a 180-degree field of view.
            MediaType.EQUIRECTANGULAR_180 -> {
                val videoPanelRegistration = VideoPanelRegistration.create("equirect-video-panel")
                videoPanelRegistration.setVideoURI(mediaItem.videoUri)
                val panel = panelManager.createPanel(videoPanelRegistration) as VideoPanel
                panel.panelType = PanelType.SPHERE
                panel
            }
            // For DRM-protected video, we use a VideoPanel with a flat panel type.
            // This is because DRM-protected content requires a secure video path,
            // which is provided by the VideoPanel.
            MediaType.DRM_PROTECTED -> {
                val videoPanelRegistration = VideoPanelRegistration.create("drm-video-panel")
                videoPanelRegistration.setVideoURI(mediaItem.videoUri)
                val panel = panelManager.createPanel(videoPanelRegistration) as VideoPanel
                panel.panelType = PanelType.FLAT
                panel
            }
        }
    }
}
