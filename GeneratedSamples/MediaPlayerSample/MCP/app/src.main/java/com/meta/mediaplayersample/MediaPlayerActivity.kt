package com.meta.mediaplayersample

import android.os.Bundle
import android.webkit.WebView
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.meta.spatial.sdk.SpatialActivity
import com.meta.spatial.sdk.activities.PanelRegistration
import com.meta.spatial.sdk.scene.Scene
import com.meta.spatial.sdk.scene.Skybox
import com.meta.spatial.sdk.scene.Visible

class MediaPlayerActivity : SpatialActivity() {

    private val viewModel: VideoViewModel by viewModels()
    private var skyboxEntity: Skybox? = null
    private var isPassthroughEnabled by mutableStateOf(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Observe the selected video and play it in the WebView
        viewModel.selectedVideo.observe(this) { video ->
            video?.let {
                val webView = findViewById<WebView>(R.id.web_view)
                webView?.settings?.javaScriptEnabled = true
                webView?.settings?.mediaPlaybackRequiresUserGesture = false
                webView?.loadUrl(it.videoUrl)
            }
        }
    }

    override fun onSceneReady(scene: Scene) {
        super.onSceneReady(scene)
        skyboxEntity = scene.getSkybox()
    }

    override fun registerPanels(): List<PanelRegistration> {
        return listOf(
            PanelRegistration(
                "video_list",
                "Video List",
                { VideoListPanel(viewModel) }
            ),
            PanelRegistration(
                "video_playback",
                "Video Playback",
                R.layout.video_playback
            ),
            PanelRegistration(
                "controls",
                "Controls",
                { PassthroughToggle() }
            )
        )
    }

    @Composable
    fun PassthroughToggle() {
        Column {
            Button(onClick = {
                togglePassthrough()
            }) {
                Text(if (isPassthroughEnabled) "Disable Passthrough" else "Enable Passthrough")
            }
        }
    }

    private fun togglePassthrough() {
        isPassthroughEnabled = !isPassthroughEnabled
        scene.enablePassthrough(isPassthroughEnabled)
        skyboxEntity?.setComponent(Visible(!isPassthroughEnabled))
    }
}
