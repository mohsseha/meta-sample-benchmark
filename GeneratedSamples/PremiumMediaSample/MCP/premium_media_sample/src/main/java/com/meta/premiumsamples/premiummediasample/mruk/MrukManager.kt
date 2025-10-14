package com.meta.premiumsamples.premiummediasample.mruk

import com.meta.spatial.scene.Scene
import com.meta.spatial.scene.SceneFeature
import com.meta.spatial.scene.SceneObject
import com.meta.spatial.scene.queries.FindSceneObjects
import com.meta.spatial.scene.queries.IsA
import com.meta.spatial.scene.semantic.Wall

class MrukManager(private val sceneFeature: SceneFeature) {

    fun findWallAndSnap(panel: SceneObject) {
        val query = FindSceneObjects(
            filter = IsA(Wall::class.java)
        )
        sceneFeature.query(query) { results ->
            val wall = results.firstOrNull()
            if (wall != null) {
                // Simple snapping logic: place the panel in front of the wall
                val wallPosition = wall.transform.position
                val wallRotation = wall.transform.rotation
                panel.transform.position = wallPosition
                panel.transform.rotation = wallRotation
            }
        }
    }
}
