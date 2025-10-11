# 3D Object Sample with ISDK

This project is a sample application for the Meta Spatial SDK v0.8.0, demonstrating how to create an immersive VR application that allows users to select and interact with 3D objects using the Interaction SDK (ISDK).

## Features

- **ISDK-based Interaction**: Utilizes the latest ISDK for advanced hand and controller interactions, including grabbing, touching, and manipulating objects.
- **Dynamic Object Spawning**: Users can select from a variety of 3D objects through a UI panel and spawn them into the scene.
- **Jetpack Compose UI**: The object selection UI is built with Jetpack Compose, showcasing how to integrate 2D UI panels in a 3D environment.
- **Custom Scene Environment**: The application loads a custom 3D environment from a `glXF` file, which can be customized in the Meta Spatial Editor.

## Getting Started

To build and run this project, you will need:

- Android Studio
- Meta Quest 2, 3, or Pro headset
- Meta Spatial SDK v0.8.0

### Building the Project

1. Clone this repository.
2. Open the project in Android Studio.
3. Connect your Meta Quest headset to your computer.
4. Build and run the application on your device.

## How It Works

### ISDK Integration

The application uses the `ISDKInputSystem` as the primary input system, which is the default in Meta Spatial SDK v0.8.0. The `Grabbable` component is added to the spawned 3D objects to make them interactive.

### Object Selection UI

The object selection UI is a `ComposePanel` that is attached to a node in the scene. The UI is built with Jetpack Compose and allows the user to select which 3D object to spawn.

### 3D Object Spawning

When an object is selected from the UI, the application loads the corresponding `gltf` model and adds it to the scene. The `Grabbable` component is then added to the new object to make it interactive.

## Project Structure

- **`app/src/main/java`**: Contains the main application logic in `MainActivity.kt`.
- **`app/src/main/assets/scenes`**: Contains the main scene file `main.glxf`.
- **`app/src/main/assets/models`**: Contains the 3D object models in `gltf` format.
- **`app/src/main/assets/textures`**: Contains the UI textures.

## Customization

You can customize this project by:

- **Adding your own 3D models**: Place your `gltf` models in the `app/src/main/assets/models` directory and update the `objectModels` list in `MainActivity.kt`.
- **Customizing the UI**: Modify the `ObjectSelectionUI` composable in `MainActivity.kt` to change the appearance and layout of the object selection UI.
- **Editing the scene**: Open the `main.glxf` file in the Meta Spatial Editor to modify the 3D environment.
