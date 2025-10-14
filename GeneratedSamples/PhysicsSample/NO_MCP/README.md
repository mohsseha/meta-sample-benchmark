# Physics Sample for Meta Spatial SDK

This application is a sample project for the Meta Spatial SDK v0.8.0, demonstrating how to use the physics engine and create custom interaction systems.

## Overview

This sample showcases a VR environment with various objects that have physics properties. Users can interact with these objects in different ways, such as pushing buttons, pulling triggers, and spinning objects. The application is built using Kotlin and the Meta Spatial SDK.

## Features

- **Physics Simulation**: Demonstrates the use of the Meta Spatial SDK's physics engine, including gravity, collisions, and rigid body dynamics.
- **Custom Interaction Systems**: Includes custom systems for handling different types of interactions:
    - **Button System**: Manages the state of pushable buttons.
    - **Trigger System**: Handles the mechanics of pullable triggers with constraints.
    - **Spinner System**: Controls the rotational physics of spinning objects.
- **Scene Loading**: Loads the scene and object properties from a `glxf` file.
- **Meta Spatial Editor Integration**: The scene is structured to allow for easy adjustment of physics properties in the Meta Spatial Editor.

## Project Structure

- **`app/src/main/java/com/meta/physicssample`**: Contains the main application code.
    - **`MainActivity.kt`**: The main entry point of the application. It initializes the Spatial SDK, registers the physics and custom interaction systems, and loads the scene.
    - **`ButtonSystem.kt`**: The system for handling button interactions.
    - **`TriggerSystem.kt`**: The system for handling trigger interactions.
    - **`SpinnerSystem.kt`**: The system for handling spinner interactions.
- **`app/src/main/assets/scenes`**: Contains the scene files.
    - **`physics_scene.glxf`**: The scene definition file, which includes the placement of objects and their physics properties.
    - **`*.gltf`**: Placeholder 3D model files.

## How it Works

### Physics

The physics simulation is enabled in `MainActivity.kt` by registering the `PhysicsSystem`. The physics properties of each object, such as mass, friction, and collision shape, are defined in the `physics_scene.glxf` file.

### Custom Systems

The custom interaction systems (`ButtonSystem`, `TriggerSystem`, `SpinnerSystem`) are also registered in `MainActivity.kt`. These systems query for entities with specific components (`ButtonComponent`, `TriggerComponent`, `SpinnerComponent`) and then apply the interaction logic.

- **Button System**: Detects collisions with buttons and updates their state.
- **Trigger System**: Uses constraints to limit the movement of triggers and detects when they are pulled.
- **Spinner System**: Uses constraints to control the rotation of spinners and monitors their angular velocity.

### Meta Spatial Editor

The `physics_scene.glxf` file is designed to be used with the Meta Spatial Editor. You can use the editor to:

- Adjust the physics properties of objects (e.g., mass, bounciness).
- Modify the constraints for triggers and spinners.
- Change the layout of the scene.

## Setup and Build

To build and run this project, you will need:

- Android Studio
- The Meta Spatial SDK v0.8.0
- A Meta Quest headset

1. **Clone the repository.**
2. **Open the project in Android Studio.**
3. **Ensure you have the Meta Spatial SDK configured in your environment.**
4. **Build and run the application on your Meta Quest headset.**
