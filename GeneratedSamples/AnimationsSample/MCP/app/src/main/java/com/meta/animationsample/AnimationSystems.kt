
package com.meta.animationsample

import com.meta.spatial.Entity
import com.meta.spatial.ISystem
import com.meta.spatial.Transform
import com.meta.spatial.World

/**
 * A system that plays animations from glTF files.
 *
 * NOTE: This is a placeholder system. The actual implementation would require
 * the Meta Spatial SDK's animation APIs.
 */
class GltfAnimationSystem : ISystem {
    override fun update(world: World, deltaTime: Float) {
        val entities = world.query(GltfAnimationComponent::class.java)
        for (entity in entities) {
            val animationComponent = entity.getComponent(GltfAnimationComponent::class.java)
            if (animationComponent.isPlaying) {
                // In a real implementation, you would use the SDK's animation API
                // to play the animation.
                // For example:
                // val animationPlayer = entity.getComponent(AnimationPlayer::class.java)
                // animationPlayer.play(animationComponent.animationName, animationComponent.loop, animationComponent.speed)
            }
        }
    }
}

/**
 * A system that animates an entity's position in a circle.
 */
class ProceduralAnimationSystem : ISystem {
    override fun update(world: World, deltaTime: Float) {
        val entities = world.query(ProceduralAnimationComponent::class.java, Transform::class.java)
        for (entity in entities) {
            val animationComponent = entity.getComponent(ProceduralAnimationComponent::class.java)
            val transform = entity.getComponent(Transform::class.java)

            animationComponent.angle += animationComponent.speed * deltaTime
            transform.position.x = Math.cos(animationComponent.angle.toDouble()).toFloat() * animationComponent.radius
            transform.position.z = Math.sin(animationComponent.angle.toDouble()).toFloat() * animationComponent.radius
        }
    }
}

/**
 * A system that animates the scale of an entity using a ValueAnimator.
 */
class ScaleAnimationSystem : ISystem {
    override fun update(world: World, deltaTime: Float) {
        val entities = world.query(ScaleAnimationComponent::class.java, Transform::class.java)
        for (entity in entities) {
            val animationComponent = entity.getComponent(ScaleAnimationComponent::class.java)
            val transform = entity.getComponent(Transform::class.java)

            if (!animationComponent.animator.isStarted) {
                animationComponent.animator.addUpdateListener { animation ->
                    val scale = animation.animatedValue as Float
                    transform.scale.set(scale, scale, scale)
                }
                animationComponent.animator.start()
            }
        }
    }
}
