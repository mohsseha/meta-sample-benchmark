package com.meta.premiummédiasample.panels

import android.view.Surface
import com.meta.spatial.entities.Entity
import com.meta.spatial.scene.Anchor
import com.meta.spatial.systems.PanelSystem
import com.meta.spatial.ui.DirectSurfacePanel

class DirectToSurfaceVideoPanel(private val entity: Entity, private val panelSystem: PanelSystem) {

    private val panel: DirectSurfacePanel

    init {
        panel = panelSystem.createDirectSurfacePanel(entity, 1280, 720)
    }

    fun getSurface(): Surface {
        return panel.getSurface()
    }

    fun snapToAnchor(anchor: Anchor) {
        entity.setParent(anchor.getEntity())
    }
}
