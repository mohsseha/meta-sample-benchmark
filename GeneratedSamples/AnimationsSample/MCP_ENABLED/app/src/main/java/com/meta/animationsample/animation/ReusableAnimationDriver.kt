// This code requires the Meta Spatial SDK.
// Please ensure you have the SDK installed and configured in your environment.

package com.meta.animationsample.animation

import android.animation.ValueAnimator
import com.meta.spatial.math.Vector3
import com.meta.spatial.scene.Transform

class ReusableAnimationDriver(private val transform: Transform) {

    private var animator: ValueAnimator? = null

    fun startFloatingAnimation() {
        animator = ValueAnimator.ofFloat(0f, 2f * Math.PI.toFloat())
        animator?.duration = 3000
        animator?.repeatCount = ValueAnimator.INFINITE
        animator?.addUpdateListener { valueAnimator ->
            val angle = valueAnimator.animatedValue as Float
            val y = 1.5f + 0.5f * Math.sin(angle.toDouble()).toFloat()
            transform.position = Vector3(transform.position.x, y, transform.position.z)
        }
        animator?.start()
    }

    fun stop() {
        animator?.cancel()
    }
}