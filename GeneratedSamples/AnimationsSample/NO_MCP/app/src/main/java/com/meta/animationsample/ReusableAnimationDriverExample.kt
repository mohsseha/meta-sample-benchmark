/*
 * Copyright (c) Meta Platforms, Inc. and affiliates
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.meta.spatial.sdk.compose.Box
import com.meta.spatial.sdk.compose.Transform
import com.meta.spatial.sdk.compose.animation.Animation
import com.meta.spatial.sdk.compose.animation.Playback
import com.meta.spatial.sdk.compose.animation.Transition
import com.meta.spatial.sdk.compose.animation.easing.Linear
import kotlinx.coroutines.delay

@Composable
fun ReusableAnimationDriverExample() {
    val (isAnimating, setIsAnimating) = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(2000)
            setIsAnimating(!isAnimating)
        }
    }

    ReusableAnimatedObject(isAnimating)
}

@Composable
fun ReusableAnimatedObject(isAnimating: Boolean) {
    Transform(
        position = floatArrayOf(-1f, 1.5f, -2f)
    ) {
        Animation(
            playback = if (isAnimating) Playback.ONCE else Playback.PAUSE,
            transition = Transition(
                duration = 1000,
                easing = Linear
            )
        ) {
            Box(
                size = floatArrayOf(0.5f, 0.5f, 0.5f),
                color = if (isAnimating) floatArrayOf(1f, 0f, 0f, 1f) else floatArrayOf(0f, 1f, 0f, 1f)
            )
        }
    }
}
