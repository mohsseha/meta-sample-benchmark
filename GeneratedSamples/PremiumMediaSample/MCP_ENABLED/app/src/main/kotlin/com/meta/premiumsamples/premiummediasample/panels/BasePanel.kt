package com.meta.premiumsamples.premiummediasample.panels

import com.meta.spatial.sdk.scene.Panel
import com.meta.spatial.sdk.scene.Scene

abstract class BasePanel(protected val scene: Scene) {

    protected var panel: Panel? = null

    abstract fun create()

    fun destroy() {
        panel?.let {
            scene.destroyPanel(it)
            panel = null
        }
    }

    fun getPanel(): Panel? {
        return panel
    }
}
