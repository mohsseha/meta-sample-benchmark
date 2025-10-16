# 3D Object Sample with ISDK

This sample application demonstrates how to create an immersive VR application for the Meta Spatial SDK v0.8.0 that allows users to select from a set of 3D objects and insert them into a custom scene environment using the ISDK (Interaction SDK) for advanced hand and controller interactions.

## Features

*   **ISDK-based Interaction**: The application uses the ISDK for advanced hand and controller interactions, allowing users to naturally interact with objects in the scene.
*   **Object Selection UI**: A UI panel created with Jetpack Compose allows users to browse and select from a variety of 3D objects.
*   **Dynamic Object Spawning**: Selected objects are dynamically spawned into the scene with grabbable and manipulatable properties.
*   **Custom Scene Environment**: The application loads a custom 3D scene environment from a `glXF` file.

## Getting Started

To build and run this sample, you will need to have the Meta Spatial SDK v0.8.0 and Android Studio set up on your development machine.

1.  **Clone the repository**:
    ```bash
    git clone https://github.com/meta-quest/meta-spatial-sdk-samples.git
    ```
2.  **Open the project in Android Studio**:
    Open the `Object3DSampleIsdk` project in Android Studio.
3.  **Build and run the application**:
    Build the project and deploy it to your Meta Quest headset.

## How it Works

The application consists of the following main components:

*   **`MainActivity.kt`**: The main activity of the application, which sets up the immersive VR experience and manages the scene.
*   **`ObjectSelectionPanel.kt`**: A Jetpack Compose UI that displays a list of selectable 3D objects.
*   **`ObjectSpawningSystem.kt`**: A system that handles the spawning of selected objects into the scene.
*   **`scene.glxf`**: A `glXF` file that defines the 3D scene environment and includes placeholder 3D objects.

When the application launches, the `MainActivity` creates a `MetaScene` and loads the `scene.glxf` file. The `ObjectSelectionPanel` is displayed in the scene, allowing the user to select an object. When an object is selected, the `ObjectSpawningSystem` creates a new entity in the scene with the selected object's mesh and a `Grabbable` component, making it interactive.
