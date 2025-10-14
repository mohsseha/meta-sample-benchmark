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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.meta.spatial.sdk.compose.Panel
import com.meta.spatial.sdk.compose.Transform

@Composable
fun AnimatedUI() {
    Transform(
        position = floatArrayOf(0f, 1.5f, -1f)
    ) {
        Panel {
            val (count, setCount) = remember { mutableStateOf(0) }

            Column {
                Text("Procedural Animation Counter: $count")
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { setCount(count + 1) }) {
                    Text("Increment")
                }
            }
        }
    }
}
