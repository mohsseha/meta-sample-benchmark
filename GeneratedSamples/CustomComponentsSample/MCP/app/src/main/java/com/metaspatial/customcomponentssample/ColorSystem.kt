package com.metaspatial.customcomponentssample

import com.meta.spatialsdk.ecs.System
import com.meta.spatialsdk.ecs.queries.Query
import com.meta.spatialsdk.ecs.queries.QueryBuilder

class ColorSystem : System() {
    private lateinit var query: Query

    override fun onStart() {
        query = QueryBuilder()
            .require(SharedColorComponent::class.java)
            .build()
    }

    override fun onUpdate(deltaTime: Float) {
        query.forEach { entity ->
            val sharedColor = entity.getComponent(SharedColorComponent::class.java)
            // Here you would typically use the color to affect the entity's appearance.
            // For this example, we'll just print the color value.
            println("Entity ${entity.id} has color ${sharedColor.color}")
        }
    }
}
