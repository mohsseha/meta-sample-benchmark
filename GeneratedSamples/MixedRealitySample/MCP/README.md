# Mixed Reality Sample - Physical Environment Interaction App

This project is a mixed reality application for the Meta Spatial SDK v0.8.0 that allows users to interact with their physical environment by shooting basketballs at targets on their room's walls, with realistic physics interactions including bouncing off walls, ceilings, and objects.

## Features

- **Mixed Reality Experience**: See your actual physical room with virtual objects seamlessly integrated.
- **Physical Interaction**: Shoot virtual basketballs that bounce realistically off your room's surfaces.
- **Scene Understanding**: The application uses the Meta Spatial SDK's Mixed Reality Utility Kit (MRUK) to understand the layout of your room and create collision meshes for physical objects.
- **Physics Simulation**: The application uses the Meta Spatial SDK's physics engine to simulate the motion of the basketballs.

## How to Build and Run

1.  **Prerequisites**:
    *   Android Studio
    *   Meta Quest 2/3/Pro headset
    *   Meta Spatial SDK v0.8.0

2.  **Build**:
    *   Open the project in Android Studio.
    *   Build the project to generate the APK.

3.  **Run**:
    *   Install the APK on your Meta Quest headset.
    *   Launch the application.

## Code Overview

-   **`MainActivity.kt`**: The main entry point of the application. It handles permission requests, initializes the Meta Spatial SDK, and manages the application's lifecycle.
-   **`BasketballShooterSystem`**: A custom system that handles the logic for shooting basketballs.
-   **`Basketball.kt`**: A class that represents a basketball.
-   **`Scene.kt`**: A class that represents the scene.
-   **`Target.kt`**: A class that represents a target.
-   **`app/src/main/assets`**: Contains the 3D models and textures for the basketball and targets.

## MRUK Integration

The application uses the `MRUKFeature` to access the scene data from the device. The `loadSceneFromDevice()` method is used to retrieve the persisted scene model. The room layout is then used to create collision meshes for the walls, floor, and ceiling.

## Physics System

The application uses the `PhysicsFeature` to enable physics simulation. The basketballs are created as dynamic rigid bodies with a sphere shape, and the room surfaces are created as static rigid bodies with box shapes. The physics engine handles the collision detection and response between the basketballs and the room surfaces.
