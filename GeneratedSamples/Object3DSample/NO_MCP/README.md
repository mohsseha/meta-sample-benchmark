# 3D Object Sample - Interactive 3D Object Selection and Insertion App

This sample application demonstrates how to create an immersive VR experience with the Meta Spatial SDK that allows users to select and insert 3D objects into a scene. The scene and object properties can be adjusted through the Meta Spatial Editor.

## Features

*   **Immersive VR Environment**: A simple 3D scene with a floor and lighting.
*   **Object Selection UI**: A UI panel built with Jetpack Compose that allows users to select from a variety of 3D objects.
*   **Dynamic Object Spawning**: A system for spawning selected 3D objects into the scene at runtime.
*   **Meta Spatial Editor Integration**: The scene is structured to be compatible with the Meta Spatial Editor, allowing for easy customization of object properties.

## Getting Started

To run this sample, you will need to have the Meta Spatial SDK and the Meta Spatial Editor configured in your development environment.

1.  **Open the project in Android Studio.**
2.  **Replace the placeholder assets**:
    *   Replace the empty `.bin` files in `app/src/main/assets/scenes` with your own glTF models.
    *   Replace the empty `.png` files in `app/src/main/res/drawable` with your own thumbnails for the UI.
3.  **Build and run the application on a Meta Quest headset.**

## How it Works

### Scene Composition

The main scene is defined in the `object_scene.glxf` file. This file is a glXF (a Meta extension of glTF) that describes the scene's structure, including the floor, lighting, and the 3D objects that can be spawned.

The objects to be spawned (Cube, Sphere, Cylinder) are defined as nodes in the scene, but they are disabled by default using the `META_spatial_node` extension. This allows them to be part of the scene's asset library without being visible at startup.

### Object Spawning

The `ObjectSpawner` class is responsible for spawning objects into the scene. When the user selects an object from the UI, the `spawnObject` method is called. This method finds the corresponding node in the scene's asset library, clones it, positions the new object in front of the camera, and adds it to the scene.

### Meta Spatial Editor Integration

The scene is structured to be compatible with the Meta Spatial Editor. You can open the `object_scene.glxf` file in the editor to:

*   **Modify the scene**: Change the lighting, the floor, or add other static objects.
*   **Adjust object properties**: Select the disabled object nodes (Cube, Sphere, Cylinder) and modify their properties, such as their scale or material. These changes will be reflected in the spawned objects at runtime.

## Project Structure

*   `app/src/main/java/com/meta/object3dsample`: The main application code.
    *   `MainActivity.kt`: The main activity that sets up the scene and the UI.
    *   `ObjectSpawner.kt`: The class responsible for spawning objects.
    *   `ui`: The Jetpack Compose UI code.
*   `app/src/main/assets/scenes`: The scene assets.
    *   `object_scene.glxf`: The main scene file.
    *   `*.bin`: The glTF model files (placeholders).
*   `app/src/main/res/drawable`: The UI thumbnails (placeholders).

This sample provides a basic framework for creating interactive VR experiences with the Meta Spatial SDK. You can extend it by adding more objects, creating more complex scenes, and adding more advanced interactions.
