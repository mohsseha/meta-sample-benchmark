# Mixed Reality Sample - Physical Environment Interaction App

This sample application demonstrates how to create a mixed reality experience on the Meta Quest platform using the Meta Spatial SDK. Users can shoot virtual basketballs that interact realistically with their physical environment, bouncing off walls, floors, and ceilings.

## Features
- **Mixed Reality Experience**: See your physical room integrated with virtual objects.
- **Scene Understanding**: The application uses the Meta Spatial SDK's MRUK (Mixed Reality Utility Kit) to understand the geometry of your room.
- **Physics Simulation**: Virtual basketballs have realistic physics properties and bounce off physical surfaces.
- **Procedural Geometry**: Collision meshes for the walls, floor, and ceiling are generated procedurally based on the scene data.

## Getting Started

### Prerequisites
- Meta Quest 2, 3, or Pro headset
- Android Studio with the Meta Spatial SDK installed
- Meta Quest Developer Hub (MQDH)

### Building and Running the Application
1. Clone this repository.
2. Open the project in Android Studio.
3. Connect your Meta Quest headset to your computer.
4. Build and run the application on your headset.

## How it Works

### 1. Scene Permissions
The application first requests permission from the user to access scene data. This is necessary for the MRUK to get information about the user's physical environment.

### 2. MRUK Integration
Once permission is granted, the application uses the `Room` class from the MRUK to load the scene model. This model contains information about the room's geometry, including the walls, floor, and ceiling.

### 3. Procedural Mesh Generation
For each wall, the floor, and the ceiling, the application creates a procedural mesh that matches the dimensions and position of the physical surface. These meshes are used for collision detection.

### 4. Physics System
The application enables the physics engine and sets a global gravity. It then creates physics materials for the walls and the basketballs. The wall material has a high restitution (bounciness) to make the basketballs bounce realistically.

### 5. Object Spawning and Interaction
The application periodically spawns basketballs in front of the user. Each basketball is a separate entity with a 3D model, a physics body, and a collider. An initial velocity is applied to the basketball to "shoot" it forward.

### 6. Collision Detection
When a basketball collides with a wall, the floor, or the ceiling, the physics engine handles the collision and calculates the new trajectory of the basketball.

## Code Overview
- `MainActivity.kt`: The main entry point of the application. It handles scene permissions, MRUK integration, physics setup, and object spawning.
- `activity_main.xml`: The layout file for the main activity. It contains the `Renderer` view that displays the mixed reality scene.
- `assets`: This directory contains the 3D models and textures for the basketball and the target.

## Physics Tuning
The physics properties of the basketballs and the walls can be adjusted to change the feel of the application.
- **`restitution`**: This property of the `PhysicsMaterial` controls the bounciness of an object. A value of 1.0 means a perfectly elastic collision (no energy loss), while a value of 0.0 means a perfectly inelastic collision (the object doesn't bounce at all).
- **`mass`**: This property of the `PhysicsBody` controls the mass of the basketball. A higher mass will make the basketball feel heavier and less affected by collisions.
- **`gravity`**: The global gravity of the scene can be adjusted in the `setupScene` function.

## MRUK Best Practices
- **Request permissions only when needed**: The application requests scene permission at startup. In a real-world application, you should only request permission when the user tries to access a feature that requires it.
- **Handle permission denial gracefully**: If the user denies the scene permission, the application should still be usable, although the mixed reality features will be disabled.
- **Cache scene data**: Loading the scene model can take some time. If your application frequently needs to access scene data, you should cache it in memory to avoid reloading it every time.
