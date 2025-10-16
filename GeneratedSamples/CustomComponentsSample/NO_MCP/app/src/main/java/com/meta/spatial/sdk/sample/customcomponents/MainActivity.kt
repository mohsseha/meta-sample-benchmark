
package com.meta.spatial.sdk.sample.customcomponents

import android.os.Bundle
import com.meta.xr.sdk.activity.SpatialActivity
import com.meta.xr.sdk.component.Transform
import com.meta.xr.sdk.entity.Entity
import com.meta.xr.sdk.scene.Scene
import com.meta.xr.sdk.scene.createScene
import com.meta.xr.sdk.system.SystemManager

class MainActivity : SpatialActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create a new scene
        val scene = createScene()

        // Register the custom system
        SystemManager.registerSystem(SharedDataSystem::class.java)

        // Create a shared component instance
        val sharedData = SharedDataComponent(sharedCounter = 10)

        // Create multiple entities that share the same component instance
        createEntityWithSharedComponent(scene, sharedData, -1.0f)
        createEntityWithSharedComponent(scene, sharedData, 0.0f)
        createEntityWithSharedComponent(scene, sharedData, 1.0f)
    }

    private fun createEntityWithSharedComponent(scene: Scene, sharedData: SharedDataComponent, xPosition: Float) {
        val entity = Entity()
        val transform = Transform()
        transform.position.x = xPosition
        entity.addComponent(transform)
        entity.addComponent(sharedData)
        scene.addChild(entity)
    }
}
