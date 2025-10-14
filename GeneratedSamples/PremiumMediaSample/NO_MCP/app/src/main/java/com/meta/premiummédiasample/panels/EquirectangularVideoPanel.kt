package com.meta.premiummédiasample.panels

import com.meta.spatial.entities.Entity
import com.meta.spatial.scene.Anchor
import com.meta.spatial.systems.PanelSystem
import com.meta.spatial.ui.EquirectangularPanel

class EquirectangularVideoPanel(private val entity: Entity, private val panelSystem: PanelSystem) {

    private val panel: EquirectangularPanel

    init {
        panel = panelSystem.createEquirectangularPanel(entity, 2.0f)
        panel.setDensity(4096)
    }

    fun setSurfaceProvider(surfaceProvider: EquirectangularPanel.SurfaceProvider) {
        panel.setSurfaceProvider(surfaceProvider)
    }

    fun snapToAnchor(anchor: Anchor) {
        entity.setParent(anchor.getEntity())
    }
}
