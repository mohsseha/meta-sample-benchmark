package com.meta.mruksample.experiences

import com.meta.spatial.sdk.MRUKView
import com.meta.spatial.sdk.Scene
import com.meta.spatial.sdk.SceneObject
import com.meta.spatial.sdk.math.Vector3
import com.meta.spatial.sdk.model.Model
import com.meta.spatial.sdk.model.ModelLoader

class AnchorMeshExperience(private val mrukView: MRUKView) {

    private val virtualObjects = mutableListOf<Model>()

    fun onSceneUpdate(scene: Scene) {
        // Remove old objects
        virtualObjects.forEach { mrukView.removeModel(it) }
        virtualObjects.clear()

        // Define a map of object types to model files
        val objectTypeToModel = mapOf(
            SceneObject.Type.TABLE to "models/table_object.gltf",
            SceneObject.Type.COUCH to "models/couch_object.gltf",
            SceneObject.Type.WINDOW to "models/window_object.gltf",
            SceneObject.Type.DOOR to "models/door_object.gltf",
            SceneObject.Type.BED to "models/bed_object.gltf",
            SceneObject.Type.WALL_ART to "models/wall_art_object.gltf",
            SceneObject.Type.OTHER to "models/placeholder.gltf"
        )

        // Place a virtual object on each detected object
        for ((type, modelFile) in objectTypeToModel) {
            val objects = scene.getObjectsByType(type)
            for (obj in objects) {
                val model = ModelLoader.loadModel(modelFile)
                model.transform.position = obj.transform.position
                model.transform.rotation = obj.transform.rotation
                mrukView.addModel(model)
                virtualObjects.add(model)
            }
        }
    }

    fun start() {
        // Initial scene update
        val scene = Scene.getCurrentScene(mrukView.context)
        onSceneUpdate(scene)
    }

    fun stop() {
        virtualObjects.forEach { mrukView.removeModel(it) }
        virtualObjects.clear()
    }
}
