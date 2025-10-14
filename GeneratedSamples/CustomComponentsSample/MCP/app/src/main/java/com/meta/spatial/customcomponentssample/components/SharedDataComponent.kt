
package com.meta.spatial.customcomponentssample.components

import com.meta.spatial.core.Component
import com.meta.spatial.core.ComponentLiveness
import com.meta.spatial.core.PrototypedComponent

class SharedDataComponent : Component() {
    var sharedText: String = ""

    companion object : PrototypedComponent {
        override val id = "SharedDataComponent".hashCode()
        override val liveness = ComponentLiveness.SCENE
        override fun create() = SharedDataComponent()
    }
}
