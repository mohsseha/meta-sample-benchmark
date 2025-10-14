/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.meta.animationsample

import androidx.compose.runtime.Composable
import com.meta.spatial.sdk.compose.Model
import com.meta.spatial.sdk.compose.Transform
import com.meta.spatial.sdk.compose.animation.Animation
import com.meta.spatial.sdk.compose.animation.Playback

@Composable
fun GltfAnimatedObject() {
    Transform(
        position = floatArrayOf(0f, 1.5f, -2f)
    ) {
        Model(
            asset = "scenes/animated_drone.glb",
            animation = Animation(
                playback = Playback.LOOP,
                speed = 1.0f
            )
        )
    }
}
