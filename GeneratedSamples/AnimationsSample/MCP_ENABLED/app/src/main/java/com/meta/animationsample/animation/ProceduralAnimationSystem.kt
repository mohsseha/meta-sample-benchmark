// This code requires the Meta Spatial SDK.
// Please ensure you have the SDK installed and configured in your environment.

package com.meta.animationsample.animation

import com.meta.animationsample.component.AnimatedObject
import com.meta.spatial.core.SingleEntity
import com.meta.spatial.core.System
import com.meta.spatial.scene.Transform

class ProceduralAnimationSystem : System() {

    private val drivers = mutableMapOf<SingleEntity, ReusableAnimationDriver>()

    override fun onEntityAdded(entity: SingleEntity) {
        val animatedObject = entity.getComponent(AnimatedObject::class.java)
        if (animatedObject != null && animatedObject.isProcedural) {
            val transform = entity.getComponent(Transform::class.java) ?: Transform()
            entity.addComponent(transform)

            val driver = ReusableAnimationDriver(transform)
            driver.startFloatingAnimation()
            drivers[entity] = driver
        }
    }

    override fun onEntityRemoved(entity: SingleEntity) {
        drivers.remove(entity)?.stop()
    }
}
