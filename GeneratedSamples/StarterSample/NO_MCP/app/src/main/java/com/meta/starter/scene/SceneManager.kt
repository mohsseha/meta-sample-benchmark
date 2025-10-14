package com.meta.starter.scene

import android.net.Uri
import com.meta.spatial.core.Entity
import com.meta.spatial.core.Vector3
import com.meta.spatial.runtime.ReferenceSpace
import com.meta.spatial.runtime.Scene
import com.meta.spatial.runtime.SceneMaterial
import com.meta.spatial.runtime.SceneMesh
import com.meta.spatial.toolkit.Color
import com.meta.spatial.toolkit.Mesh
import com.meta.spatial.toolkit.Visible
import com.meta.spatial.toolkit.gltf.GLXFManager

class SceneManager(private val scene: Scene, private val glxfManager: GLXFManager) {

    fun setupScene() {
        // 1. Set the reference space to LOCAL_FLOOR
        scene.setReferenceSpace(ReferenceSpace.LOCAL_FLOOR)

        // 2. Configure scene lighting
        scene.setLightingEnvironment(
            // ambient light color
            Color.valueOf(0.1f, 0.1f, 0.1f, 1.0f),
            // sun color
            Color.valueOf(1.0f, 1.0f, 1.0f, 1.0f),
            // sun direction
            Vector3(0.0f, -1.0f, 0.0f)
        )

        // 3. Update the IBL environment
        scene.updateIBLEnvironment("environment.env")

        // 4. Set the viewer origin
        scene.setViewOrigin(0.0f, 1.7f, 0.0f, 0.0f)

        // 5. Create a skybox
        createSkybox()

        // 6. Load the scene composition
        loadSceneComposition()
    }

    private fun createSkybox() {
        val skyboxEntity = Entity.create()
        // The skybox is a large sphere that surrounds the scene.
        // We are using a simple jpg file as the texture for the skybox.
        val skyboxMesh =
            SceneMesh.skybox(100.0f, SceneMaterial.loadLocalFile("skybox.jpg", unlit = true))
        skyboxEntity.setComponent(Mesh(uri = skyboxMesh.getUri()))
        skyboxEntity.setComponent(Visible(true))
    }

    private fun loadSceneComposition() {
        // Load the main scene composition from the assets folder.
        // This file is typically exported from Meta Spatial Editor.
        glxfManager.inflateGLXF(Uri.parse("apk:///scenes/Composition.glxf"))
    }
}
