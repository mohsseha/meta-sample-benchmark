
# 3D Object Sample with ISDK

This sample demonstrates how to create an immersive VR application for Meta Spatial SDK v0.8.0 that allows users to select from a set of 3D objects and insert them into a custom scene environment using ISDK (Interaction SDK) for advanced hand and controller interactions.

## Features

*   **ISDK-based Interaction**: Utilizes the Interaction SDK for natural hand and controller-based interactions.
*   **Dynamic Object Spawning**: Select and place 3D objects into the scene from a UI panel.
*   **Grabbable Objects**: Spawned objects are grabbable and movable.
*   **Jetpack Compose UI**: The object selection UI is built with Jetpack Compose.
*   **Custom Scene**: The application loads a custom 3D scene from a glXF file.

## Project Structure

*   `app/src/main/java/com/meta/object_3d_sample_isdk/`: Contains the main application code.
    *   `MainActivity.kt`: The main activity that sets up the VR environment and loads the scene.
    *   `ObjectSelectionUI.kt`: The Jetpack Compose UI for selecting 3D objects.
*   `app/src/main/assets/scenes/`: Contains the scene and model files.
    *   `scene.glxf`: The main scene definition.
    *   `cube.gltf`, `sphere.gltf`, `cylinder.gltf`: The 3D models.
    *   `cube.png`, `sphere.png`, `cylinder.png`: Thumbnails for the UI.
*   `build.gradle`, `app/build.gradle`: Gradle build files.

## How to Build and Run

### Prerequisites

*   Android Studio with the Meta Spatial SDK plugin.
*   A Meta Quest 2, 3, or Pro headset.
*   Developer mode enabled on the headset.

### Steps

1.  **Open the project in Android Studio.**
2.  **Connect your Meta Quest headset to your computer.**
3.  **Build and run the application on your headset.**

## How it Works

1.  The `MainActivity` creates a `Compositor` and a `SpatialUI` instance.
2.  It then loads the `scene.glxf` file, which defines the initial scene with a floor and a UI panel.
3.  The `ObjectSelectionUI` is a Jetpack Compose function that displays a list of available 3D objects.
4.  When the user clicks on an object in the UI, the `addObjectToScene` function is called.
5.  This function creates a new `Entity` in the scene, sets its position, attaches a `Model` component with the selected glTF model, and adds a `Grabbable` component to make it interactive.

## ISDK Notes

*   **ISDK is the default input system in Meta Spatial SDK v0.8.0.** No special configuration is required to enable it.
*   **Panel Orientation**: For ISDK to work correctly with UI panels, the panel's normal vector must be pointing forward. In the `scene.glxf` file, the `Panel` component is used, which handles this automatically.
*   **Grabbable Component**: The `Grabbable` component is what makes an entity interactive with ISDK. It allows users to grab, move, and rotate the entity with their hands or controllers.
*   **Near-field and Far-field Interaction**: ISDK supports both near-field (direct touch) and far-field (raycasting) interactions. The `Grabbable` component works with both without any extra configuration.
