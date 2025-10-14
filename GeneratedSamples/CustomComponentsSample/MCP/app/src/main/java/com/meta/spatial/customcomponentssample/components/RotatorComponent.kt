
package com.meta.spatial.customcomponentssample.components

import com.meta.spatial.core.Component
import com.meta.spatial.core.ComponentLiveness
import com.meta.spatial.core.PrototypedComponent

class RotatorComponent : Component() {
    var rotationSpeed: Float = 1.0f

    companion object : PrototypedComponent {
        override val id = "RotatorComponent".hashCode()
        override val liveness = ComponentLiveness.SCENE
        override fun create() = RotatorComponent()
    }
}
