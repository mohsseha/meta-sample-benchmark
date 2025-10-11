// This code requires the Meta Spatial SDK.
// Please ensure you have the SDK installed and configured in your environment.

package com.meta.animationsample.animation

import com.meta.animationsample.component.AnimatedObject
import com.meta.spatial.animation.Animation
import com.meta.spatial.animation.AnimationSystem
import com.meta.spatial.animation.PlayMode
import com.meta.spatial.core.SingleEntity
import com.meta.spatial.gltf.GltfComponent

class GltfAnimationSystem : AnimationSystem() {

    override fun onEntityAdded(entity: SingleEntity) {
        val animatedObject = entity.getComponent(AnimatedObject::class.java)
        if (animatedObject != null && !animatedObject.isProcedural) {
            val gltfComponent = GltfComponent(animatedObject.modelPath)
            entity.addComponent(gltfComponent)

            gltfComponent.onReady = {
                val animation = Animation.createFromGltf(gltfComponent)
                animation.playMode = PlayMode.LOOP
                entity.addComponent(animation)
                animation.play()
            }
        }
    }
}
