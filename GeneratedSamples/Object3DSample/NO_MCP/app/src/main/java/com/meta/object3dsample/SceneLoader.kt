package com.meta.object3dsample

import android.content.Context
import com.meta.spatial.sdk.core.Scene
import com.meta.spatial.sdk.core.SceneManager
import com.meta.spatial.sdk.core.entities.Entity
import com.meta.spatial.sdk.core.entities.components.Model
import com.meta.spatial.sdk.core.entities.components.Transform

object SceneLoader {
    private var scene: Scene? = null

    fun loadScene(context: Context) {
        scene = SceneManager.loadScene(context, "scenes/main.xml")
    }

    fun addObjectToScene(modelName: String) {
        scene?.let {
            val entity = Entity()
            val transform = Transform()
            transform.position.z = -2.0f
            val model = Model("models/$modelName.gltf")
            entity.add(transform)
            entity.add(model)
            it.add(entity)
        }
    }
}
