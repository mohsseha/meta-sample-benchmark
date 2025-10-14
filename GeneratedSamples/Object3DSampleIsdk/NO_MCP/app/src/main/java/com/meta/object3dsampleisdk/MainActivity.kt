
package com.meta.object3dsampleisdk

import android.os.Bundle
import androidx.compose.runtime.Composable
import com.meta.spatial.SpatialActivity
import com.meta.spatial.core.Entity
import com.meta.spatial.core.Singletons
import com.meta.spatial.core.Transform
import com.meta.spatial.core.lookAt
import com.meta.spatial.core.plus
import com.meta.spatial.isdk.ISDKGrabbableControllerStyleBehavior
import com.meta.spatial.scene.Scene
import com.meta.spatial.scene.compose.Panel
import com.meta.spatial.scene.compose.PanelTheme
import com.meta.spatial.ui.compose.Button
import com.meta.spatial.ui.compose.Column
import com.meta.spatial.ui.compose.Text
import com.meta.spatial.ui.compose.Vector3
import com.meta.spatial.ui.compose.dp

class MainActivity : SpatialActivity() {

    private lateinit var scene: Scene

    override fun onSetupScene(savedInstanceState: Bundle?) {
        scene = Scene.load("scene.glxf")

        val panel = Entity.create()
        panel.name = "ObjectSelectionPanel"
        val panelTransform = Transform()
        panelTransform.position = Vector3(0.0f, 1.5f, -2.0f)
        panel.set(panelTransform)
        panel.set(Panel(400.dp, 300.dp) {
            ObjectSelectionUI()
        })
        scene.add(panel)
    }

    @Composable
    private fun ObjectSelectionUI() {
        PanelTheme {
            Column {
                Text("Select an object to add")
                Button(onClick = { addObject("models/cube.gltf") }) {
                    Text("Cube")
                }
                Button(onClick = { addObject("models/sphere.gltf") }) {
                    Text("Sphere")
                }
                Button(onClick = { addObject("models/cylinder.gltf") }) {
                    Text("Cylinder")
                }
            }
        }
    }

    private fun addObject(modelPath: String) {
        val entity = Entity.create()
        entity.name = modelPath.substringAfterLast("/").substringBefore(".")
        val transform = Transform()
        // Position the new object in front of the user
        val headPose = Singletons.headPose.transform
        transform.position = headPose.position + headPose.forward * 2.0f
        entity.set(transform)
        entity.set(com.meta.spatial.scene.Renderable(gltfModel = modelPath))
        entity.set(ISDKGrabbableControllerStyleBehavior())
        scene.add(entity)
    }
}
