# Custom Components Sample - Shared Component System App

This sample application demonstrates the use of custom components and systems in the Meta Spatial SDK. It showcases how to create a shared data component that affects the behavior of multiple entities in a scene, following the Entity-Component-System (ECS) architecture pattern.

## Architecture Overview

The application follows a basic ECS pattern:

*   **Entities**: These are the fundamental objects in the scene. In this sample, we have a "settings" entity and multiple "rotating object" entities.
*   **Components**: These are data containers that are attached to entities. They define the properties and behavior of the entities.
    *   `SharedSettingsComponent`: A custom component that holds a single `rotationSpeed` value. This component is attached to a single entity and its data is shared across the application.
    *   `RotatableComponent`: A custom "marker" component that identifies entities that should be rotated. It contains no data itself.
    *   `Transform`: A built-in SDK component that defines the position, rotation, and scale of an entity in 3D space.
*   **Systems**: These are the logic controllers that process entities based on the components they possess.
    *   `ObjectRotationSystem`: A custom system that queries the scene for two types of entities:
        1.  The single entity with the `SharedSettingsComponent` to retrieve the global `rotationSpeed`.
        2.  All entities that have both a `RotatableComponent` and a `Transform` component.
        The system then updates the rotation of each "rotatable" entity on every frame, using the shared `rotationSpeed`.

## How it Works

1.  **Initialization (in `MainActivity.kt`)**:
    *   A `Scene` is created to hold all the entities and systems.
    *   A single entity is created and the `SharedSettingsComponent` is added to it. This entity acts as a central point for configuration.
    *   Multiple entities are created, and each is given a `Transform` (to position it in the scene) and a `RotatableComponent` (to mark it for rotation).
    *   The `ObjectRotationSystem` is added to the scene.

2.  **Runtime (in `ObjectRotationSystem.kt`)**:
    *   On each frame update, the `onUpdate` method of the `ObjectRotationSystem` is called.
    *   The system first finds the entity with the `SharedSettingsComponent` and reads the `rotationSpeed`.
    *   It then finds all entities that have a `RotatableComponent`.
    *   For each of these entities, it updates the `rotation` property of their `Transform` component, causing the object to rotate.

This setup demonstrates a powerful and scalable way to manage shared data and behavior in a VR application using the Meta Spatial SDK.