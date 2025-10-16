# Mixed Reality Sample - Physical Environment Interaction App

This sample application demonstrates how to create a mixed reality experience for the Meta Spatial SDK v0.8.0 that allows users to interact with their physical environment. In this application, users can shoot basketballs at targets placed on their room's walls, with realistic physics interactions.

## Features

*   **Mixed Reality Experience:** The application uses the Meta Quest's passthrough capabilities to blend the virtual and physical worlds.
*   **Scene Understanding:** The application uses the MRUK (Mixed Reality Utility Kit) to understand the user's physical environment, including the walls, ceiling, and floor.
*   **Physics-Based Interactions:** The application uses the Meta Spatial SDK's physics engine to simulate realistic interactions between the virtual basketballs and the physical environment.
*   **Controller Input:** The application uses the VR controllers to allow users to shoot basketballs.

## Getting Started

### Prerequisites

*   Meta Quest 2, 3, or Pro headset
*   Android Studio
*   Meta Spatial SDK v0.8.0

### Building and Running the Application

1.  Clone this repository.
2.  Open the project in Android Studio.
3.  Connect your Meta Quest headset to your computer.
4.  Build and run the application.

## Code Overview

### MainActivity.kt

This is the main entry point of the application. It is responsible for:

*   Initializing the Meta Spatial SDK.
*   Enabling passthrough and hiding the skybox.
*   Setting up the physics system.
*   Initializing the `RoomManager` and `GameManager`.

### RoomManager.kt

This class is responsible for:

*   Requesting permission to access scene data.
*   Retrieving the scene data from the MRUK.
*   Creating procedural meshes for the walls and adding them to the physics system.

### GameManager.kt

This class is responsible for:

*   Placing targets on the walls.
*   Handling controller input for shooting basketballs.
*   Spawning basketballs and applying physics properties to them.

## Key Concepts

### Mixed Reality Utility Kit (MRUK)

The MRUK is a set of tools and APIs that make it easier to build mixed reality experiences. In this application, we use the MRUK to:

*   **Request scene permission:** Before we can access any scene data, we need to request permission from the user.
*   **Get scene data:** Once we have permission, we can get the scene data, which includes information about the user's physical environment, such as the walls, ceiling, and floor.
*   **Create procedural meshes:** We use the scene data to create procedural meshes that represent the physical surfaces in the user's environment. These meshes are then used by the physics engine to simulate realistic collisions.

### Physics System

The Meta Spatial SDK includes a physics engine that can be used to simulate realistic interactions between objects. In this application, we use the physics engine to:

*   **Simulate gravity:** We apply gravity to the basketballs to make them fall realistically.
*   **Detect collisions:** We detect collisions between the basketballs and the walls, ceiling, and floor.
*   **Simulate bouncing:** We simulate realistic bouncing behavior when the basketballs collide with surfaces.
