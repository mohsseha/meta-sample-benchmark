# Custom Components Sample

This sample application demonstrates how to create and use custom components in the Meta Spatial SDK. It showcases the component-based architecture pattern, where entities are composed of data-driven components and systems are responsible for processing those components.

## Overview

The application creates a simple VR scene with two cubes that rotate at different speeds. The rotation speed is controlled by a custom component called `RotatableComponent`. A `RotationSystem` queries for entities with this component and updates their rotation each frame.

## Project Structure

-   **`app/src/main/java/com/meta/spatial/sdk/sample/customcomponent`**: The main package for the application.
    -   **`components/RotatableComponent.kt`**: Defines the custom component that holds the rotation speed of an entity.
    -   **`systems/RotationSystem.kt`**: Defines the system that processes entities with the `RotatableComponent` and updates their rotation.
    -   **`MainActivity.kt`**: The main entry point of the application. It sets up the scene, creates the entities, and adds the system.

## How it Works

1.  **`RotatableComponent`**: This data class holds a single `Float` value, `rotationSpeed`. It extends `IComponent` and is registered with the ECS using `ComponentDefinition`.
2.  **`RotationSystem`**: This system queries the ECS for all entities that have both a `Transform` and a `RotatableComponent`. In its `onUpdate` method, it iterates over these entities and updates their rotation based on the `rotationSpeed` in the `RotatableComponent`.
3.  **`MainActivity`**: In the `onCreate` method, a `Scene` is created. The `RotationSystem` is added to the scene. Two entities are created, each with a `Transform`, an `Appearance` (a cube), and a `RotatableComponent`. The `rotationSpeed` of the `RotatableComponent` is set to a different value for each cube, causing them to rotate at different speeds.

## How to Build and Run

1.  Open the project in Android Studio.
2.  Ensure you have the Meta Spatial SDK set up correctly.
3.  Build and run the application on a Meta Quest headset.

You should see two cubes rotating at different speeds in front of you.
