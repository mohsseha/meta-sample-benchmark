
package com.meta.spatial.customcomponentssample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.meta.spatial.core.*
import com.meta.spatial.customcomponentssample.components.RotatorComponent
import com.meta.spatial.customcomponentssample.components.SharedDataComponent
import com.meta.spatial.customcomponentssample.systems.RotationSystem
import com.meta.spatial.customcomponentssample.systems.SharedDataSystem
import com.meta.spatial.math.Transform
import com.meta.spatial.math.Vec3
import com.meta.spatial.core.Gltf
import com.meta.spatial.core.Skybox

class MainActivity : AppCompatActivity() {

    private lateinit var dataModel: DataModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the DataModel
        dataModel = EntityContext.getDataModel() ?: DataModel()
        EntityContext.setDataModel(dataModel)

        // Create and register the systems
        val rotationSystem = RotationSystem()
        val sharedDataSystem = SharedDataSystem()
        dataModel.registerSystem(rotationSystem)
        dataModel.registerSystem(sharedDataSystem)

        // Create a shared data entity
        val sharedDataEntity = dataModel.createEntity()
        sharedDataEntity.addComponent(SharedDataComponent().apply {
            sharedText = "Hello from Shared Component!"
        })

        // Create multiple entities with the RotatorComponent
        createRotatorEntity(Vec3(-2.0f, 0.0f, -5.0f))
        createRotatorEntity(Vec3(0.0f, 0.0f, -5.0f))
        createRotatorEntity(Vec3(2.0f, 0.0f, -5.0f))

        // Set up the scene
        setupScene()
    }

    private fun createRotatorEntity(position: Vec3) {
        val entity = dataModel.createEntity()
        entity.addComponent(Transform().apply {
            this.position = position
        })
        entity.addComponent(RotatorComponent().apply {
            rotationSpeed = 0.5f
        })
        // Add a visual representation (e.g., a cube)
        entity.addComponent(Gltf().apply {
            uri = "https://raw.githubusercontent.com/KhronosGroup/glTF-Sample-Models/master/2.0/Cube/glTF/Cube.gltf"
        })
    }

    private fun setupScene() {
        // Create a skybox
        val skybox = dataModel.createEntity()
        skybox.addComponent(Skybox().apply {
            uri = "https://raw.githubusercontent.com/meta-quest/oculus-sdk-platform-samples/master/SampleFramework/Projects/Android/assets/skybox_texture.png"
        })

        // Create a floor
        val floor = dataModel.createEntity()
        floor.addComponent(Transform().apply {
            position = Vec3(0.0f, -1.5f, 0.0f)
            scale = Vec3(10.0f, 0.1f, 10.0f)
        })
        floor.addComponent(Gltf().apply {
            uri = "https://raw.githubusercontent.com/KhronosGroup/glTF-Sample-Models/master/2.0/Cube/glTF/Cube.gltf"
        })
    }
}
