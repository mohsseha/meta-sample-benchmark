package com.meta.object3dsampleisdk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.meta.object3dsampleisdk.ui.theme.Object3DSampleIsdkTheme
import com.meta.xr.sdk.compose.activity.MetaActivity
import com.meta.xr.sdk.compose.scene.MetaScene
import com.meta.xr.sdk.compose.scene.rememberMetaSceneController

import com.meta.object3dsampleisdk.systems.ObjectSpawningSystem
import com.meta.object3dsampleisdk.ui.ObjectSelectionPanel
import com.meta.xr.sdk.compose.panel.MetaPanel
import com.meta.xr.sdk.compose.scene.rememberSystem
import com.meta.xr.sdk.component.Transform
import org.joml.Vector3f

class MainActivity : MetaActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Object3DSampleIsdkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val metaSceneController = rememberMetaSceneController()
                    val objectSpawningSystem = rememberSystem { ObjectSpawningSystem() }
                    MetaScene(
                        metaSceneController = metaSceneController,
                        sceneUri = "scenes/scene.glxf"
                    ) {
                        MetaPanel(
                            transform = Transform().apply {
                                position = Vector3f(0.0f, 1.5f, -4.0f)
                            }
                        ) {
                            ObjectSelectionPanel { objectType ->
                                objectSpawningSystem.spawnObject(objectType)
                            }
                        }
                    }
                }
            }
        }
    }
}
