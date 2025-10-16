
package com.meta.mediaplayersample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.meta.mediaplayersample.ui.VideoListPanel
import com.meta.mediaplayersample.ui.VideoPlayer
import com.meta.mediaplayersample.ui.theme.MediaPlayerSampleTheme
import com.meta.spatial.sdk.base.Sdk
import com.meta.spatial.sdk.base.Sdk.Passthrough
import com.meta.spatial.sdk.base.Sdk.Scene
import com.meta.spatial.sdk.base.compose.ComposePanel
import com.meta.spatial.sdk.base.panel.Panel
import com.meta.spatial.sdk.base.panel.PanelPose
import com.meta.spatial.sdk.base.panel.PanelShape
import com.meta.spatial.sdk.base.scene.ScenePose
import org.joml.Quaternionf
import org.joml.Vector3f

class MainActivity : ComponentActivity() {

    private val viewModel: VideoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Sdk.initialize(this)

        val videoListPanel = ComposePanel(
            "video-list-panel",
            PanelPose(Vector3f(-1.5f, 1.5f, -2.0f), Quaternionf()),
            PanelShape.Rectangle(1.0f, 1.5f)
        )

        val videoPlayerPanel = ComposePanel(
            "video-player-panel",
            PanelPose(Vector3f(0.0f, 1.5f, -3.0f), Quaternionf()),
            PanelShape.Rectangle(1.8f, 1.0f)
        )

        videoListPanel.setContent {
            MediaPlayerSampleTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    VideoListPanel(viewModel)
                }
            }
        }

        videoPlayerPanel.setContent {
            MediaPlayerSampleTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    VideoPlayer(viewModel)
                }
            }
        }

        setContent {
            val isPassthroughEnabled by viewModel.isPassthroughEnabled.collectAsState()
            Passthrough.setEnabled(isPassthroughEnabled)

            // This Box is a placeholder for the 3D scene
            Box(modifier = Modifier.fillMaxSize())
        }

        Scene.setPose(ScenePose(Vector3f(0.0f, 0.0f, 0.0f), Quaternionf()))
    }
}
