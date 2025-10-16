package com.metaspatial.customcomponentssample

import com.meta.spatialsdk.components.Component
import com.meta.spatialsdk.components.ComponentIdentifier
import com.meta.spatialsdk.components.ComponentRegistry

data class SharedColorComponent(var color: Int = 0) : Component {
    override fun getIdentifier(): ComponentIdentifier {
        return IDENTIFIER
    }

    companion object {
        val IDENTIFIER = ComponentIdentifier("com.metaspatial.customcomponentssample.SharedColorComponent")

        fun register() {
            ComponentRegistry.register(IDENTIFIER, SharedColorComponent::class.java)
        }
    }
}
