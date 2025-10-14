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

package com.meta.object3dsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.meta.spatial.sdk.Context
import com.meta.spatial.sdk.Scene
import com.meta.spatial.sdk.compose.SceneView
import com.meta.object3dsample.ui.ObjectSelectionPanel
import com.meta.object3dsample.ui.theme.Object3DSampleTheme

class MainActivity : ComponentActivity() {
    private lateinit var scene: Scene

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the Meta Spatial SDK
        val sdkContext = Context.create(this)
        scene = sdkContext.createScene()

        // Load the scene from the glXF file
        scene.loadFromAssets("scenes/object_scene.glxf")

        setContent {
            Object3DSampleTheme {
                SceneView(scene = scene)
                ObjectSelectionPanel(objectSpawner = ObjectSpawner(scene))
            }
        }
    }

    override fun onResume() {
        super.onResume()
        scene.resume()
    }

    override fun onPause() {
        super.onPause()
        scene.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        scene.destroy()
    }
}
