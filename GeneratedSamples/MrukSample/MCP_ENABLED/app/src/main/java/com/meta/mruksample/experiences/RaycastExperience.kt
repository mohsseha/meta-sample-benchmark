package com.meta.mruksample.experiences

import com.meta.spatial.sdk.MRUKView
import com.meta.spatial.sdk.Scene
import com.meta.spatial.sdk.input.Input
import com.meta.spatial.sdk.input.InputObserver
import com.meta.spatial.sdk.input.InputType
import com.meta.spatial.sdk.math.Vector3
import com.meta.spatial.sdk.model.Model
import com.meta.spatial.sdk.model.ModelLoader
import com.meta.spatial.sdk.raycast.Raycast

class RaycastExperience(private val mrukView: MRUKView) {

    private var placedObject: Model? = null

    private val inputObserver = object : InputObserver {
        override fun onInput(inputType: InputType, buttonState: Input.ButtonState, position: Vector3) {
            if (inputType == InputType.CONTROLLER_A && buttonState == Input.ButtonState.DOWN) {
                val raycastResult = Raycast.raycast(mrukView.camera.transform.position, mrukView.camera.transform.forward)
                if (raycastResult.hasHit()) {
                    if (placedObject == null) {
                        placedObject = ModelLoader.loadModel("models/placed_object.gltf")
                        mrukView.addModel(placedObject!!)
                    }
                    placedObject?.transform?.position = raycastResult.hitPoint
                }
            }
        }
    }

    fun onSceneUpdate(scene: Scene) {
        // This experience does not depend on scene updates
    }

    fun start() {
        Input.addObserver(inputObserver)
    }

    fun stop() {
        Input.removeObserver(inputObserver)
        placedObject?.let {
            mrukView.removeModel(it)
            placedObject = null
        }
    }
}
