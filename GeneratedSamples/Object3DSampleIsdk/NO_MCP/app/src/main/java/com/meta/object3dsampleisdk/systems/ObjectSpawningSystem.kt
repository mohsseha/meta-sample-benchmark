package com.meta.object3dsampleisdk.systems

import com.meta.xr.sdk.component.Transform
import com.meta.xr.sdk.ecs.Entity
import com.meta.xr.sdk.ecs.System
import com.meta.xr.sdk.isdk.Grabbable
import org.joml.Vector3f

class ObjectSpawningSystem : System() {
    fun spawnObject(objectType: String) {
        val entity = getScene().createEntity(objectType)
        entity.getOrCreateComponent(Transform::class.java).apply {
            position = Vector3f(0.0f, 1.0f, -2.0f)
        }
        entity.getOrCreateComponent(Grabbable::class.java)
    }
}
