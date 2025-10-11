package com.meta.premiumsamples.premiummediasample.mruk

import com.meta.spatial.sdk.scene.Scene
import com.meta.spatial.sdk.scene.SceneAnchor
import com.meta.spatial.sdk.scene.classification.SceneClassifier
import com.meta.spatial.sdk.scene.query.SceneQuery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MrukManager(private val scene: Scene) {

    suspend fun findWallAnchor(): SceneAnchor? {
        return withContext(Dispatchers.IO) {
            val query = SceneQuery.Builder()
                .withClassification(SceneClassifier.WALL_FACE)
                .build()
            val result = scene.query(query)
            result.anchors.firstOrNull()
        }
    }
}
