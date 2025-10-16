
package com.meta.spatial.sdk.sample.customcomponents

import com.meta.xr.sdk.query.Query
import com.meta.xr.sdk.query.contains
import com.meta.xr.sdk.system.System

class SharedDataSystem : System() {
    private val query = Query()

    init {
        query.contains(SharedDataComponent::class.java)
    }

    override fun onUpdate(deltaTime: Float) {
        query.forEach { entity ->
            val sharedData = entity.getComponent(SharedDataComponent::class.java)
            sharedData.sharedCounter++
            // The component data is updated directly on the entity
        }
    }
}
