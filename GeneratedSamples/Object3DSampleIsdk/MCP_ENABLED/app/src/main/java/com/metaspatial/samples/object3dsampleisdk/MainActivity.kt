package com.metaspatial.samples.object3dsampleisdk

import android.os.Bundle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.meta.spatial.sdk.SdkActivity
import com.meta.spatial.sdk.SdkApplication
import com.meta.spatial.sdk.compose.ComposePanel
import com.meta.spatial.sdk.compose.getComposePanel
import com.meta.spatial.sdk.core.nodes.Node
import com.meta.spatial.sdk.core.scenes.Scene
import com.meta.spatial.sdk.core.scenes.SceneUtils
import com.meta.spatial.sdk.interaction.isdk.Grabbable
import com.meta.spatial.sdk.interaction.isdk.ISDKInputSystem
import com.meta.spatial.sdk.interaction.isdk.addGrabbable

class Object3DApplication : SdkApplication() {
    override fun onCreate() {
        super.onCreate()
        // Initialization logic here if needed
    }
}

class MainActivity : SdkActivity() {
    private val objectModels = listOf("models/cube.gltf", "models/sphere.gltf")
    private var selectedModelIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadScene("scenes/main.glxf") { scene ->
            setupObjectSelector(scene)
        }
    }

    private fun setupObjectSelector(scene: Scene) {
        val objectSelectorNode = scene.findNodeByName("ObjectSelector")
        objectSelectorNode?.let {
            val composePanel = it.getComposePanel(this)
            composePanel.setContent {
                ObjectSelectionUI(
                    objectNames = objectModels.map { it.substringAfterLast("/") },
                    onSelectObject = { index ->
                        selectedModelIndex = index
                        spawnObject(scene)
                    }
                )
            }
        }
    }

    private fun spawnObject(scene: Scene) {
        val modelPath = objectModels[selectedModelIndex]
        SceneUtils.loadGltf(this, modelPath) { gltfNode ->
            gltfNode.translation.set(0.0, 1.0, -1.5)
            gltfNode.addGrabbable(this)
            scene.addChild(gltfNode)
        }
    }
}

@Composable
fun ObjectSelectionUI(objectNames: List<String>, onSelectObject: (Int) -> Unit) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text("Select an Object to Spawn")
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            objectNames.forEachIndexed { index, name ->
                Button(onClick = { onSelectObject(index) }) {
                    Text(name)
                }
            }
        }
    }
}