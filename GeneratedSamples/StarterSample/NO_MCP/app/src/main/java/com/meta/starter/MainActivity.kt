package com.meta.starter

import android.os.Bundle
import com.meta.starter.scene.SceneManager
import com.meta.starter.ui.WelcomePanel
import com.meta.spatial.core.Entity
import com.meta.spatial.core.Vector3
import com.meta.spatial.toolkit.AppSystemActivity
import com.meta.spatial.toolkit.Panel
import com.meta.spatial.toolkit.PanelRegistration
import com.meta.spatial.toolkit.PanelSettings
import com.meta.spatial.toolkit.Transform
import com.meta.spatial.compose.ComposeViewPanelRegistration

class MainActivity : AppSystemActivity() {

    private lateinit var sceneManager: SceneManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun registerPanels(): List<PanelRegistration> {
        return listOf(
            ComposeViewPanelRegistration(
                R.id.welcome_panel,
                { _, _ -> WelcomePanel() },
                { PanelSettings(2.0f, 1.5f) }
            )
        )
    }

    override fun onSceneReady() {
        super.onSceneReady()
        sceneManager = SceneManager(scene, systemManager.glxfManager)
        sceneManager.setupScene()

        // Create and position the welcome panel
        val panelEntity = Entity.create()
        panelEntity.setComponent(Transform(position = Vector3(0.0f, 1.7f, -2.0f)))
        panelEntity.setComponent(Panel(R.id.welcome_panel))
    }
}
