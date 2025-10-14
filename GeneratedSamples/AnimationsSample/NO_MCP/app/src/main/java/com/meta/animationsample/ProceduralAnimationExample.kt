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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import com.meta.spatial.sdk.compose.Box
import com.meta.spatial.sdk.compose.Transform
import kotlinx.coroutines.delay
import kotlin.math.sin

@Composable
fun ProceduralAnimationExample() {
    val time by produceState(0f) {
        while (true) {
            value += 0.01f
            delay(16)
        }
    }

    Transform(
        position = floatArrayOf(1f, 1.5f + sin(time * 5f) * 0.2f, -2f)
    ) {
        Box(
            size = floatArrayOf(0.5f, 0.5f, 0.5f),
            color = floatArrayOf(0f, 0f, 1f, 1f)
        )
    }
}
