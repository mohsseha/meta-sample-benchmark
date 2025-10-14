package com.meta.object3dsample

import com.meta.spatial.scene.Scene
import com.meta.spatial.scene.getScene
import com.meta.spatial.core.datamodel.Entity
import com.meta.spatial.core.datamodel.Transform
import com.meta.spatial.scene.components.MeshComponent

object ObjectSpawner {

    private val scene: Scene = getScene()

    fun spawnObject(objectName: String) {
        // Create a new entity.
        val entity = scene.createEntity()

        // Add a transform component to position the object.
        val transform = Transform()
        transform.translation.z = -2.0f // Position the object 2 meters in front of the user.
        scene.addComponent(entity, transform)

        // Add a mesh component to render the object.
        val meshComponent = MeshComponent()
        meshComponent.meshPath = "models/$objectName.gltf"
        scene.addComponent(entity, meshComponent)
    }
}
