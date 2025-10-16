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
 * distributed under the License in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.meta.premiumsamples.premiummediasample

import android.app.Activity
import com.meta.xr.spatial.sdk.mruk.Mruk
import com.meta.xr.spatial.sdk.mruk.MrukAnchor
import com.meta.xr.spatial.sdk.mruk.MrukError
import com.meta.xr.spatial.sdk.mruk.MrukManager
import com.meta.xr.spatial.sdk.mruk.MrukResult
import com.meta.xr.spatial.sdk.mruk.MrukScene

class MrukManager(private val activity: Activity) {

    private val mrukManager = Mruk.createMrukManager(activity)
    private var mrukScene: MrukScene? = null

    fun requestScenePermission(onPermissionGranted: () -> Unit, onPermissionDenied: () -> Unit) {
        mrukManager.requestScenePermission(
            onPermissionGranted = {
                onPermissionGranted()
            },
            onPermissionDenied = {
                onPermissionDenied()
            }
        )
    }

    fun queryScene(onSceneQueried: (MrukScene) -> Unit, onError: (MrukError) -> Unit) {
        mrukManager.queryScene(
            onResult = { result ->
                when (result) {
                    is MrukResult.Success -> {
                        mrukScene = result.value
                        onSceneQueried(result.value)
                    }
                    is MrukResult.Error -> {
                        onError(result.error)
                    }
                }
            }
        )
    }

    fun getWalls(): List<MrukAnchor> {
        return mrukScene?.getAnchorsWithLabel("WALL") ?: emptyList()
    }
}
