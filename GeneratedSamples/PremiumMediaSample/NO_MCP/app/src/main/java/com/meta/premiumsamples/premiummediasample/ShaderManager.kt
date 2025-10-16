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

import android.content.Context
import com.meta.xr.spatial.sdk.base.Shader
import java.io.IOException

class ShaderManager(private val context: Context) {

    fun loadShader(vertexShaderFileName: String, fragmentShaderFileName: String): Shader? {
        return try {
            val vertexShader = context.assets.open(vertexShaderFileName).bufferedReader().use { it.readText() }
            val fragmentShader = context.assets.open(fragmentShaderFileName).bufferedReader().use { it.readText() }
            Shader(vertexShader, fragmentShader)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
}
