/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.meta.starter.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.meta.starter.sample.ui.theme.StarterSampleTheme
import com.meta.spatial.sdk.*
import com.meta.spatial.sdk.compose.Panel
import com.meta.spatial.sdk.compose.PanelComposition
import com.meta.spatial.sdk.compose.PanelConfig
import com.meta.spatial.sdk.compose.PanelPlacement
import com.meta.spatial.sdk.core.Connection
import com.meta.spatial.sdk.core.Scene
import com.meta.spatial.sdk.features.VRFeature
import com.meta.spatial.sdk.features.PanelFeature
import com.meta.spatial.sdk.features.AssetFeature
import com.meta.spatial.sdk.features.EnvironmentFeature
import com.meta.spatial.sdk.types.Position
import com.meta.spatial.sdk.types.Rotation

class MainActivity : ComponentActivity() {
    private lateinit var connection: Connection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the Meta Spatial SDK
        connection = Connection(this)

        // Request VR feature
        connection.requestFeature(VRFeature::class.java)

        // Request Panel feature for Jetpack Compose UI
        connection.requestFeature(PanelFeature::class.java)

        // Request Asset feature for loading scenes and other assets
        connection.requestFeature(AssetFeature::class.java)

        // Request Environment feature for skybox and lighting
        connection.requestFeature(EnvironmentFeature::class.java)

        // Set up the scene
        setupScene()

        // Set the content to our PanelComposition
        setContent {
            StarterSampleTheme {
                PanelComposition(connection) {
                    WelcomePanel()
                }
            }
        }
    }

    private fun setupScene() {
        // Load the scene from the glXF file
        val assetFeature = connection.getFeature(AssetFeature::class.java)
        assetFeature.loadSceneFromAssets("scenes/main.glxf") { scene ->
            // Set the loaded scene as the active scene
            connection.getFeature(EnvironmentFeature::class.java).scene = scene
        }
    }

    override fun onResume() {
        super.onResume()
        connection.resume()
    }

    override fun onPause() {
        super.onPause()
        connection.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        connection.disconnect()
    }
}

@Composable
fun WelcomePanel() {
    Panel(
        config = PanelConfig(
            width = 1.0f,
            height = 0.5f,
            placement = PanelPlacement.Absolute(
                position = Position(0.0f, 1.5f, -2.0f),
                rotation = Rotation(0.0f, 0.0f, 0.0f)
            )
        )
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Text("Welcome to the Starter Sample!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StarterSampleTheme {
        WelcomePanel()
    }
}
