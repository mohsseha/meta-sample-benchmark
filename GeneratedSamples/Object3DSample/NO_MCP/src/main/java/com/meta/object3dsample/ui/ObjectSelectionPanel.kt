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

package com.meta.object3dsample.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.meta.object3dsample.ObjectSpawner

@Composable
fun ObjectSelectionPanel(objectSpawner: ObjectSpawner) {
    // A simple UI with buttons to spawn different objects
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Select an object to spawn:")
        Row {
            Button(onClick = { objectSpawner.spawnObject("Cube") }) {
                Text("Cube")
            }
            Button(onClick = { objectSpawner.spawnObject("Sphere") }) {
                Text("Sphere")
            }
            Button(onClick = { objectSpawner.spawnObject("Cylinder") }) {
                Text("Cylinder")
            }
        }
    }
}
