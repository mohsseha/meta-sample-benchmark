package com.meta.object3dsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.meta.object3dsample.ui.ObjectSelectionPanel
import com.meta.spatial.scene.SceneView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // I am assuming a SceneView component exists and it loads the scene.
                    SceneView(
                        modifier = Modifier.fillMaxSize(),
                        scenePath = "scenes/Main.metaspatial"
                    )
                    ObjectSelectionPanel(
                        onObjectSelected = { objectName ->
                            // Spawn the selected object.
                            ObjectSpawner.spawnObject(objectName)
                        }
                    )
                }
            }
        }
    }
}
