# Custom Components Sample

This sample application demonstrates the creation and use of custom components in the Meta Spatial SDK. It shows how to define a custom component, register it, attach it to entities, and process it using a custom system.

## Architecture

The application follows a simple Entity-Component-System (ECS) architecture.

*   **Entity**: A general-purpose object. In this sample, entities are created in the `MainActivity`.
*   **Component**: Data associated with an entity. The `SharedColorComponent` is a custom component that stores a color value.
*   **System**: Logic that transforms component data. The `ColorSystem` queries for entities with the `SharedColorComponent` and processes them.

## How to Run

1.  Open the project in Android Studio.
2.  Build and run the application on a Meta Quest device.
3.  Observe the logcat output to see the `ColorSystem` processing the entities.

## Code Overview

*   `SharedColorComponent.kt`: Defines the custom component. It's a simple data class that holds a color value.
*   `ColorSystem.kt`: Defines the system that processes the `SharedColorComponent`. It queries for entities with this component and prints their color to the log.
*   `MainActivity.kt`: The main entry point of the application. It registers the custom component and system, and creates three entities with different colors.
