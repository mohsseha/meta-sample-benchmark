package com.meta.premiummédiasample.panels

import com.meta.spatial.entities.Entity
import com.meta.spatial.scene.Anchor
import com.meta.spatial.systems.PanelSystem
import com.meta.spatial.ui.Panel

class StandardVideoPanel(private val entity: Entity, private val panelSystem: PanelSystem) {

    private val panel: Panel

    init {
        panel = panelSystem.createPanel(entity, 1.0f, 0.5625f) // 16:9 aspect ratio
    }

    fun setSurfaceProvider(surfaceProvider: Panel.SurfaceProvider) {
        panel.setSurfaceProvider(surfaceProvider)
    }

    fun snapToAnchor(anchor: Anchor) {
        entity.setParent(anchor.getEntity())
    }
}
