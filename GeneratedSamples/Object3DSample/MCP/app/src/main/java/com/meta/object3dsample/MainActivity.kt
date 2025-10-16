package com.meta.object3dsample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.meta.spatial.core.AppSystemActivity
import com.meta.spatial.ecs.Transform
import com.meta.spatial.scene.Scene
import com.meta.spatial.scene.SceneEntity
import com.meta.spatial.scene.components.GltfModel
import kotlin.random.Random

class MainActivity : AppSystemActivity() {

    private lateinit var scene: Scene
    private var objectsNode: SceneEntity? = null

    // The catalog of objects that can be spawned in the scene.
    // The key is the name of the object and the value is the path to the glTF file.
    private val objectCatalog = mapOf(
        "Cube" to "scenes/cube.gltf",
        "Sphere" to "scenes/sphere.gltf",
        "Torus" to "scenes/torus.gltf"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create a new scene and load it from the glXF file.
        scene = Scene(this)
        scene.loadFromFile("scenes/scene.glxf") {
            // Get the "Objects" node from the scene.
            // This is the node where we will spawn the new objects.
            objectsNode = it.findNodeByName("Objects")
        }

        // Set the content of the activity to be the object selection UI.
        setContent {
            ObjectSelectionUI(objectCatalog.keys.toList()) { objectName ->
                spawnObject(objectName)
            }
        }
    }

    /**
     * Spawns a new object in the scene.
     *
     * @param objectName The name of the object to spawn.
     */
    private fun spawnObject(objectName: String) {
        // Get the path to the glTF file from the object catalog.
        val gltfPath = objectCatalog[objectName] ?: return

        // Create a new entity and add it to the "Objects" node.
        val entity = scene.createEntity()
        objectsNode?.addChild(entity)

        // Set the transform of the entity to a random position.
        entity.getOrCreateComponent<Transform>().position.set(
            Random.nextFloat() * 2 - 1,
            Random.nextFloat() * 2 - 1,
            Random.nextFloat() * 2 - 1
        )

        // Set the glTF model of the entity.
        entity.getOrCreateComponent<GltfModel>().assetPath = gltfPath
    }
}

/**
 * A Jetpack Compose UI that displays a list of buttons for selecting an object to spawn.
 *
 * @param objectNames The list of object names to display.
 * @param onObjectSelected A callback that is invoked when an object is selected.
 */
@Composable
fun ObjectSelectionUI(objectNames: List<String>, onObjectSelected: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        objectNames.forEach { objectName ->
            Button(
                onClick = { onObjectSelected(objectName) },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Spawn $objectName")
            }
        }
    }
}