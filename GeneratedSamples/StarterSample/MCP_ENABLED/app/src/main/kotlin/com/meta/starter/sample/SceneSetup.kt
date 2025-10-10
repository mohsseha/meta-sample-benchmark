package com.meta.starter.sample

import com.meta.spatial.SpatialActivity
import com.meta.spatial.scene.Scene
import com.meta.spatial.scene.SceneObject
import com.meta.spatial.scene.Vector3

fun setupScene(activity: SpatialActivity, scene: Scene) {
    // Set up a simple skybox and lighting
    scene.setLightingEnvironment(
        sunDirection = Vector3(0.0f, -1.0f, 0.0f),
        sunColor = Vector3(1.0f, 1.0f, 1.0f),
        sunIntensity = 1.0f,
        ambientColor = Vector3(0.2f, 0.2f, 0.2f),
        ambientIntensity = 1.0f
    )
    scene.skybox = SceneObject.createSkybox(activity, "skybox.ktx")
}
