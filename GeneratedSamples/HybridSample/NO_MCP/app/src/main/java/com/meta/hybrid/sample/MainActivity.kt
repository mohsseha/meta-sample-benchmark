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

package com.meta.hybrid.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.meta.hybrid.sample.ui.theme.HybridSampleTheme
import com.meta.xr.spatial.sdk.SpatialActivity
import com.meta.xr.spatial.sdk.panel.PanelActivity

class MainActivity : ComponentActivity() {

    private var isImmersiveMode = mutableStateOf(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (intent.data?.host == "immersive") {
            isImmersiveMode.value = true
            // Launch immersive mode
            startActivity(SpatialActivity.createIntent(this, MainActivity::class.java))
        } else {
            isImmersiveMode.value = false
            // Launch panel mode
            startActivity(PanelActivity.createIntent(this, MainActivity::class.java))
        }

        setContent {
            HybridSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HybridApp(isImmersiveMode.value) {
                        isImmersiveMode.value = !isImmersiveMode.value
                        if (isImmersiveMode.value) {
                            startActivity(SpatialActivity.createIntent(this, MainActivity::class.java))
                        } else {
                            startActivity(PanelActivity.createIntent(this, MainActivity::class.java))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HybridApp(isImmersiveMode: Boolean, onSwitchMode: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = if (isImmersiveMode) "Immersive Mode" else "Panel Mode")
        Button(onClick = onSwitchMode) {
            Text(text = "Switch to ${if (isImmersiveMode) "Panel" else "Immersive"} Mode")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HybridSampleTheme {
        HybridApp(false) {}
    }
}
