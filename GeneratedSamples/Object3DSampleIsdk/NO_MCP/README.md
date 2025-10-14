
# 3D Object Sample with ISDK

This sample demonstrates how to create an immersive VR application for the Meta Spatial SDK that allows users to select from a set of 3D objects and insert them into a custom scene environment using the Interaction SDK (ISDK) for advanced hand and controller interactions.

## Features

*   **Immersive VR Environment**: A 3D scene loaded from a `.glxf` file.
*   **Object Selection UI**: A 2D panel created with Jetpack Compose allows users to select objects.
*   **Dynamic Object Spawning**: Users can add objects to the scene dynamically.
*   **ISDK Interactions**: Objects in the scene are grabbable and can be manipulated using hand tracking or controllers.

## How to Run

1.  **Set up your development environment**: Follow the official Meta Spatial SDK documentation to set up your Android Studio and Meta Quest device.
2.  **Build and run**: Open the project in Android Studio, build it, and run it on a connected Meta Quest headset.

## Code Overview

*   **`MainActivity.kt`**: The main entry point of the application. It's a `SpatialActivity` that loads the scene and sets up the UI.
*   **`scenes/scene.glxf`**: The scene composition file. It defines the initial objects in the scene and their properties.
*   **`scenes/models/`**: Contains the 3D models in glTF format.
*   **`ObjectSelectionUI`**: A Jetpack Compose function that creates the UI for selecting objects.

## ISDK Integration

The Interaction SDK (ISDK) is the default input system in Meta Spatial SDK v0.8.0. This sample leverages ISDK for the following:

*   **Grabbable Objects**: The `ISDKGrabbableControllerStyleBehavior` component is added to objects to make them interactive.
*   **Panel Interaction**: The object selection UI is a `Panel` that users can interact with using hand tracking or controllers.

The `addObject` function in `MainActivity.kt` demonstrates how to dynamically create a new entity, assign a 3D model to it, and make it grabbable by adding the `ISDKGrabbableControllerStyleBehavior` component.
