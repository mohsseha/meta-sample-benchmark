
package com.meta.animationsample

import android.animation.ValueAnimator
import com.meta.spatial.Component

/**
 * A component that holds the name of the animation to be played from a glTF file.
 */
data class GltfAnimationComponent(
    val animationName: String,
    var isPlaying: Boolean = true,
    var loop: Boolean = true,
    var speed: Float = 1.0f
) : Component

/**
 * A component for procedural animations.
 * This component will be used to animate an entity's position in a circle.
 */
data class ProceduralAnimationComponent(
    var radius: Float = 1.0f,
    var speed: Float = 1.0f,
    var angle: Float = 0.0f
) : Component

/**
 * A component for reusable animation drivers.
 * This component will be used to animate the scale of an entity.
 */
data class ScaleAnimationComponent(
    var animator: ValueAnimator
) : Component
