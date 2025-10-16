package com.meta.object3dsampleisdk

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.meta.object3dsampleisdk.ui.ObjectSelectionPanel
import com.meta.spatial.core.AppSystemActivity
import com.meta.spatial.core.scene
import com.meta.spatial.core.scenes.Scene

class MainActivity : AppSystemActivity() {

    private lateinit var object3DView: Object3DView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        object3DView = Object3DView(this)

        setContent {
            Box(modifier = Modifier.fillMaxSize()) {
                AndroidView(factory = { object3DView })
                ObjectSelectionPanel(object3DView = object3DView)
            }
        }

        // Load the main scene
        scene.load("scene.glxf") {
            if (it.isSuccess) {
                // Scene loaded successfully
                val scene = it.getOrThrow()
                object3DView.setScene(scene)
            } else {
                // Handle scene loading failure
                val exception = it.exceptionOrNull()
                exception?.printStackTrace()
            }
        }
    }
}
