# 3D Object Sample

This sample demonstrates how to create an immersive VR application for Meta Spatial SDK v0.8.0 that allows users to select from a set of 3D objects and insert them into a custom scene environment.

## How to Use

1.  **Build and Run:** Build and run the application on a Meta Quest headset.
2.  **Select Objects:** Use the UI panel to select a 3D object from the catalog.
3.  **Place Objects:** The selected object will be spawned in the scene.

## Meta Spatial Editor Integration

The scene and objects in this sample are designed to be compatible with the Meta Spatial Editor. You can use the editor to:

*   **Modify the scene:** Change the environment, lighting, and other scene properties.
*   **Adjust object properties:** Modify the transform, materials, and other properties of the 3D objects.
*   **Add new objects:** Import your own 3D models and add them to the object catalog.

To use the Meta Spatial Editor with this sample:

1.  **Import the project:** Open the project in the Meta Spatial Editor.
2.  **Open the scene:** Open the `scenes/scene.glxf` file.
3.  **Edit the scene:** Make your desired changes to the scene and objects.
4.  **Export the scene:** Export the scene to update the `scene.glxf` file.

## Project Structure

*   **`app/src/main/java/com/meta/object3dsample/MainActivity.kt`:** The main activity that manages the scene and object lifecycle.
*   **`app/src/main/assets/scenes/`:** Contains the scene files (`scene.glxf`) and 3D object models (`.gltf`).
*   **`app/build.gradle`:** The Gradle build file for the application.

## Object Catalog

The object catalog is defined in the `MainActivity.kt` file. It is a map of object names to their corresponding glTF file paths. To add a new object, you need to:

1.  **Add the glTF file:** Place the glTF file in the `app/src/main/assets/scenes/` directory.
2.  **Add an entry to the catalog:** Add a new entry to the `objectCatalog` map in `MainActivity.kt`.
