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

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.meta.premiumsamples.premiummediasample.ui.theme.PremiumMediaSampleTheme
import com.meta.xr.spatial.sdk.activity.SpatialActivity
import com.meta.xr.spatial.sdk.base.Panel
import com.meta.xr.spatial.sdk.mruk.MrukAnchor

class MediaViewActivity : SpatialActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var mrukManager: MrukManager
    private lateinit var panelManager: PanelManager
    private lateinit var shaderManager: ShaderManager
    // A list of walls detected by MRUK.
    private var walls by mutableStateOf<List<MrukAnchor>>(emptyList())
    // The currently active video panel.
    private var currentPanel by mutableStateOf<Panel?>(null)
    // The custom reflection shader.
    private var reflectionShader by mutableStateOf<com.meta.xr.spatial.sdk.base.Shader?>(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mediaPlayer = MediaPlayer(this)
        // The MrukManager is used to interact with the MRUK scene graph.
        mrukManager = MrukManager(this)
        // The PanelManager is used to create and manage video panels.
        panelManager = PanelManager(getPanelManager())
        // The ShaderManager is used to load custom shaders from the assets folder.
        shaderManager = ShaderManager(this)

        // Load the custom reflection shader.
        reflectionShader = shaderManager.loadShader("shaders/reflection_shader.vert", "shaders/reflection_shader.frag")

        // Request scene permission to access the MRUK scene graph.
        mrukManager.requestScenePermission(
            onPermissionGranted = {
                // Query the scene to get the list of walls.
                mrukManager.queryScene(
                    onSceneQueried = { scene ->
                        walls = scene.getAnchorsWithLabel("WALL")
                    },
                    onError = { error ->
                        Log.e("MediaViewActivity", "Error querying scene: $error")
                    }
                )
            },
            onPermissionDenied = {
                Log.e("MediaViewActivity", "Scene permission denied")
            }
        )

        setContent {
            PremiumMediaSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MediaScreen(
                        mediaItems = MediaCatalog.items,
                        onPlay = { mediaItem ->
                            mediaPlayer.prepare(mediaItem)
                            mediaPlayer.getExoPlayer().play()
                            // Create a video panel for the selected media item.
                            currentPanel = panelManager.createPanelForMedia(mediaItem)
                            // Apply the custom reflection shader to the panel.
                            currentPanel?.shader = reflectionShader
                        },
                        onSnapToWall = {
                            // Snap the current panel to the first wall in the list.
                            currentPanel?.let { panel ->
                                if (walls.isNotEmpty()) {
                                    val wall = walls.first()
                                    panel.position = wall.position
                                    panel.rotation = wall.rotation
                                }
                            }
                        }
                    )
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}

@Composable
fun MediaScreen(
    mediaItems: List<MediaItem>,
    onPlay: (MediaItem) -> Unit,
    onSnapToWall: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(mediaItems) { mediaItem ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = mediaItem.title)
                    Button(onClick = { onPlay(mediaItem) }) {
                        Text("Play")
                    }
                }
            }
        }
        Button(onClick = onSnapToWall) {
            Text("Snap to Wall")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MediaScreenPreview() {
    PremiumMediaSampleTheme {
        MediaScreen(mediaItems = MediaCatalog.items, onPlay = {}, onSnapToWall = {})
    }
}
