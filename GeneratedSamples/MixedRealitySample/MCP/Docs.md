# Documentation

## Mixed Reality Utility Kit (MRUK)

The Mixed Reality Utility Kit (MRUK) is a set of tools that help you build mixed reality experiences. It provides features for scene understanding, spatial anchors, and physics.

### Scene Understanding

The scene understanding feature allows you to get information about the user's physical environment, such as the layout of the room and the location of furniture. This information can be used to create more immersive and realistic mixed reality experiences.

### Spatial Anchors

Spatial anchors allow you to place virtual objects in the real world and have them stay in place. This is useful for creating persistent mixed reality experiences that can be shared with other users.

### Physics

The physics feature allows you to simulate the motion of virtual objects in the real world. This can be used to create more realistic and interactive mixed reality experiences.

## How to Use MRUK

To use MRUK in your project, you need to add the `com.meta.spatial-sdk:mruk:0.8.0` dependency to your `build.gradle.kts` file. You also need to add the `com.meta.permission.ACCESS_SCENE_DATA` permission to your `AndroidManifest.xml` file.

Once you have done this, you can use the `MRUKFeature` class to access the MRUK features. For example, you can use the `loadSceneFromDevice()` method to get the scene data from the device.

## Example

The following code shows how to use MRUK to get the scene data from the device and create collision meshes for the walls, floor, and ceiling:

```kotlin
val mrukFeature = sdkManager.getFeature(MRUKFeature::class.java)
mrukFeature.loadSceneFromDevice().thenAccept { scene ->
    val sceneManager = Scene(entityManager)
    sceneManager.createBounds(scene)
    val targetManager = Target(entityManager)
    targetManager.place(scene)
}
```

This code will create a `Scene` object that contains the collision meshes for the walls, floor, and ceiling. You can then use this object to perform collision detection with virtual objects.
