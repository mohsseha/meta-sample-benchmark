package com.meta.object3dsample.data

data class ObjectData(val name: String, val gltfPath: String)

object ObjectCatalog {
    val objects = listOf(
        ObjectData("Cube", "models/cube.gltf"),
        ObjectData("Sphere", "models/sphere.gltf"),
        ObjectData("Cylinder", "models/cylinder.gltf")
    )
}