package com.meta.mruksample.experiences

import com.meta.spatial.sdk.MRUKView
import com.meta.spatial.sdk.Scene
import com.meta.spatial.sdk.SceneObject
import com.meta.spatial.sdk.model.Model
import com.meta.spatial.sdk.model.ModelLoader

class KeyboardTrackerExperience(private val mrukView: MRUKView) {

    private var keyboardModel: Model? = null

    fun onSceneUpdate(scene: Scene) {
        val keyboard = scene.getObjectsByType(SceneObject.Type.KEYBOARD).firstOrNull()
        if (keyboard != null) {
            if (keyboardModel == null) {
                keyboardModel = ModelLoader.loadModel("models/keyboard_model.gltf")
                mrukView.addModel(keyboardModel!!)
            }
            keyboardModel?.transform = keyboard.transform
        } else {
            keyboardModel?.let {
                mrukView.removeModel(it)
                keyboardModel = null
            }
        }
    }

    fun start() {
        val scene = Scene.getCurrentScene(mrukView.context)
        onSceneUpdate(scene)
    }

    fun stop() {
        keyboardModel?.let {
            mrukView.removeModel(it)
            keyboardModel = null
        }
    }
}
