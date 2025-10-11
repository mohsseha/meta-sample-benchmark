package com.meta.object3dsample

import android.net.Uri
import android.os.Bundle
import androidx.compose.ui.platform.ComposeView
import com.meta.object3dsample.ui.ObjectSelectionPanel
import com.meta.spatial.sdk.AppSystemActivity
import com.meta.spatial.sdk.PanelRegistration
import com.meta.spatial.sdk.PanelRegistration.Companion.ViewPanelRegistration
import com.meta.spatial.sdk.compose.ComposePanelSettings
import com.meta.spatial.sdk.core.Entity
import com.meta.spatial.sdk.core.Gltf
import com.meta.spatial.sdk.core.Transform
import com.meta.spatial.sdk.core.World
import com.meta.spatial.sdk.math.Vec3
import com.meta.spatial.sdk.math.Quat
import com.meta.spatial.sdk.math.Vec3.Companion.one
import com.meta.spatial.sdk.math.Vec3.Companion.zero
import com.meta.spatial.sdk.scene.GLXFManager
import com.meta.spatial.sdk.scene.GLXFScene
import kotlinx.coroutines.launch

/**
 * The main activity for the 3D Object Sample application.
 *
 * This activity is an immersive VR experience that allows users to select and place 3D objects
 * in a scene. It demonstrates how to load a scene from a glXF file, create a UI with Jetpack
 * Compose, and dynamically spawn objects in the world.
 */
class MainActivity : AppSystemActivity() {

    private lateinit var glXFManager: GLXFManager
    private var gltfxEntity: Entity? = null
    private var objectCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the glXF manager and load the main scene.
        glXFManager = GLXFManager(this)
        loadGLXF("main")
    }

    /**
     * Registers the UI panels for the application.
     *
     * This method registers a Jetpack Compose panel that allows the user to select 3D objects.
     */
    override fun registerPanels(): List<PanelRegistration> {
        return listOf(
            ViewPanelRegistration(
                registrationId = R.id.object_selection_panel,
                viewCreator = { context ->
                    ComposeView(context).apply {
                        setContent {
                            ObjectSelectionPanel { gltfPath ->
                                spawnObject(gltfPath)
                            }
                        }
                    }
                },
                settingsCreator = {
                    ComposePanelSettings(
                        width = 400,
                        height = 600,
                    )
                }
            )
        )
    }

    /**
     * Loads a scene from a glXF file.
     *
     * @param compositionName The name of the composition to load.
     */
    private fun loadGLXF(compositionName: String) {
        // Destroy the previous scene if it exists.
        gltfxEntity?.destroy()
        gltfxEntity = Entity.create()
        // Launch a coroutine to load the scene.
        activityScope.launch {
            glXFManager.inflateGLXF(
                Uri.parse("apk:///scenes/${compositionName}.glxf"),
                rootEntity = gltfxEntity!!,
                keyName = compositionName
            )
        }
    }

    /**
     * Spawns a new 3D object in the scene.
     *
     * @param gltfPath The path to the glTF model to spawn.
     */
    private fun spawnObject(gltfPath: String) {
        // Create a new entity for the object.
        val newObject = Entity.create()
        // Add a Gltf component to load the model.
        newObject.addComponent(Gltf(Uri.parse(gltfPath)))

        // Calculate a position for the new object.
        val xPos = (objectCounter % 5) * 1.5f - 3.0f
        val zPos = (objectCounter / 5) * -1.5f - 3.0f
        objectCounter++

        // Add a Transform component to position the object in the world.
        newObject.addComponent(
            Transform(
                position = Vec3(xPos, 1.0f, zPos),
                rotation = Quat.identity,
                scale = one()
            )
        )
        // Add the new object to the world.
        World.addEntity(newObject)
    }
}