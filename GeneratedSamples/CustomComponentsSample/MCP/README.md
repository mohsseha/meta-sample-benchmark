
# Custom Components Sample

This sample application demonstrates how to create and use custom components in the Meta Spatial SDK. It showcases the Entity-Component-System (ECS) architecture, a powerful pattern for building complex and interactive VR experiences.

## Overview

The application creates a simple scene with three rotating cubes and a shared data component. The rotation of the cubes is controlled by a custom `RotatorComponent`, and the shared data is stored in a `SharedDataComponent`. Two systems, `RotationSystem` and `SharedDataSystem`, are responsible for processing these components and updating the scene.

## Project Structure

The project follows a standard Android project structure, with the addition of a `components` and `systems` package to organize the custom components and systems.

-   `app/src/main/java/com/meta/spatial/customcomponentssample/`
    -   `MainActivity.kt`: The main entry point of the application.
    -   `components/`: Contains the custom component definitions.
        -   `SharedDataComponent.kt`: A component for storing shared data.
        -   `RotatorComponent.kt`: A component for controlling the rotation of an entity.
    -   `systems/`: Contains the systems that process the custom components.
        -   `RotationSystem.kt`: A system that rotates entities with a `RotatorComponent`.
        -   `SharedDataSystem.kt`: A system that reads data from the `SharedDataComponent`.

## Entity-Component-System (ECS)

This sample application is built using the ECS pattern. Here's a brief overview of the key concepts:

-   **Entities**: Entities are the fundamental objects in the scene. In this sample, the cubes and the shared data object are entities.
-   **Components**: Components are data containers that can be attached to entities. They define the properties and behavior of an entity. In this sample, `RotatorComponent` and `SharedDataComponent` are custom components.
-   **Systems**: Systems are responsible for the logic of the application. They query for entities with specific components and update their state. In this sample, `RotationSystem` and `SharedDataSystem` are the systems.

## How it Works

1.  **Initialization**: The `MainActivity` initializes the `DataModel`, which is the central repository for all entities and components.
2.  **System Registration**: The `RotationSystem` and `SharedDataSystem` are registered with the `DataModel`.
3.  **Entity Creation**: The `MainActivity` creates a shared data entity and three rotating cube entities.
4.  **Component Attachment**: The `SharedDataComponent` is attached to the shared data entity, and the `RotatorComponent` is attached to the cube entities.
5.  **System Execution**: The `DataModel` executes the registered systems on each frame.
    -   The `SharedDataSystem` queries for the entity with the `SharedDataComponent` and logs its `sharedText` value.
    -   The `RotationSystem` queries for entities with a `RotatorComponent` and a `Transform` component and updates their rotation.

## Component Lifecycle

In the Meta Spatial SDK, the lifecycle of a component is managed by the Entity-Component-System (ECS) architecture. The `SystemManager` is a core component of the Spatial SDK Application Runtime and is responsible for managing the lifecycle and execution of systems.

-   **Initialization**: Systems are initialized and registered with the `SystemManager`.
-   **Execution**: The `SystemManager` executes the systems on each frame, which in turn process the components.
-   **Cleanup**: For components that wrap native resources, such as `SceneObject` and `SceneAudioAsset`, it is important to explicitly call their `destroy()` or `destroyInternal()` methods to release the native memory. The Java garbage collector will not automatically clean up these resources.

By understanding the component lifecycle, you can write more efficient and robust code for your Meta Spatial SDK applications.

## Using with Meta Spatial Editor

The Meta Spatial Editor is a powerful tool for visually composing scenes. To use the custom components from this sample in the Meta Spatial Editor, you will need to set up your project correctly.

1.  **Project Structure**: Ensure that your Spatial SDK application has a `scenes` directory. This directory should contain your entire Meta Spatial Editor project.
2.  **Importing Components**: Custom components are defined in your application's code. The Meta Spatial Editor will automatically detect and allow you to use these components when you open your project.
3.  **Reference Sample**: The `CustomComponentsSample` in the `Meta-Spatial-SDK-Samples` GitHub repository is a great reference for understanding how to structure your project and use custom components with the Meta Spatial Editor.

By following these guidelines, you can seamlessly integrate your custom components into the Meta Spatial Editor and create rich, interactive VR experiences.

## How to Build and Run

To build and run this sample, you will need to have the Meta Spatial SDK and the Meta Quest development environment set up.

1.  Open the project in Android Studio.
2.  Connect your Meta Quest headset to your computer.
3.  Build and run the application.

You should see three rotating cubes in the scene. You can also check the Logcat in Android Studio to see the output from the `SharedDataSystem`.
