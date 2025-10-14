package com.meta.mediaplayersample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.meta.spatial.SpatialActivity
import com.meta.spatial.scene.Scene
import com.meta.spatial.scene.Target
import com.meta.spatial.scene.contents.Panel
import com.meta.spatial.scene.contents.Passthrough
import com.meta.spatial.ui.compose.SpatialTheme
import com.meta.mediaplayersample.ui.VideoListPanel
import com.meta.mediaplayersample.ui.VideoPlayerPanel

class MainActivity : SpatialActivity() {

    private val viewModel: VideoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val videoListPanel = Panel(
            width = 1.0f,
            height = 1.5f,
            target = Target.Head,
            transform = Panel.Transform(
                translation = Panel.Translation(-1.5f, 0.0f, -2.0f)
            )
        ).apply {
            setContent {
                SpatialTheme {
                    VideoListPanel(viewModel)
                }
            }
        }

        val videoPlayerPanel = Panel(
            width = 2.0f,
            height = 1.125f,
            target = Target.Head,
            transform = Panel.Transform(
                translation = Panel.Translation(1.5f, 0.0f, -2.0f)
            )
        ).apply {
            setContent {
                SpatialTheme {
                    VideoPlayerPanel(viewModel)
                }
            }
        }

        val passthrough = Passthrough()

        setScene(
            Scene {
                add(videoListPanel)
                add(videoPlayerPanel)
                viewModel.isPassthroughEnabled.value.let { isEnabled ->
                    if (isEnabled) {
                        add(passthrough)
                    } else {
                        remove(passthrough)
                    }
                }
            }
        )
    }
}
