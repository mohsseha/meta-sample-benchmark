package com.meta.object3dsampleisdk

import android.content.Context
import android.view.MotionEvent
import com.meta.spatial.core.SpatialView
import com.meta.spatial.core.scenes.Scene
import com.meta.spatial.core.scenes.nodes.Node

class Object3DView(context: Context) : SpatialView(context) {

    private var scene: Scene? = null

    fun setScene(scene: Scene) {
        this.scene = scene
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        // Handle touch events for ISDK interaction
        return super.onTouchEvent(event)
    }

    fun spawnObject(objectName: String) {
        scene?.let {
            // Load the object from the glTF file
            it.loadModel("objects.gltf", objectName) { result ->
                if (result.isSuccess) {
                    val modelNode = result.getOrThrow()
                    // Add the object to the scene
                    it.addNode(modelNode)
                    // Make the object grabbable
                    makeObjectGrabbable(modelNode)
                } else {
                    result.exceptionOrNull()?.printStackTrace()
                }
            }
        }
    }

    private fun makeObjectGrabbable(node: Node) {
        // The recommended way to make an object grabbable is to add the Grabbable
        // component in the Meta Spatial Editor. However, for the purpose of this
        // sample, we will add the component programmatically.
        node.addComponent(com.meta.spatial.core.components.Grabbable::class.java)
        node.addComponent(com.meta.spatial.core.components.Touchable::class.java)
    }
}
