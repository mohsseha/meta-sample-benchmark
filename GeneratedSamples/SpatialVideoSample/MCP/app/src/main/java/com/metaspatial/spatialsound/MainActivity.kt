
package com.metaspatial.spatialsound

import android.os.Bundle
import com.meta.spatial.sdk.AppSystemActivity
import com.meta.spatial.sdk.SystemManager

class MainActivity : AppSystemActivity() {

    private lateinit var sceneManager: SceneManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sceneManager = SceneManager(systemManager)
        systemManager.registerSystem(sceneManager)
    }
}
