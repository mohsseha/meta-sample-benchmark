# 3D Object Sample with ISDK

This sample application demonstrates how to create an immersive VR application for Meta Spatial SDK v0.8.0 that allows users to select from a set of 3D objects and insert them into a custom scene environment using ISDK (Interaction SDK) for advanced hand and controller interactions.

## Features

*   **ISDK-based interaction**: The application uses the ISDK for advanced hand and controller interactions, including near-field touch, grabbing, and manipulation of objects.
*   **Object selection UI**: A UI panel created with Jetpack Compose allows users to browse and select from a variety of 3D models.
*   **Dynamic object spawning**: Selected 3D objects are dynamically spawned into the scene with grabbable and manipulatable properties.
*   **Custom scene environment**: The application loads a custom 3D scene environment from a glXF file.

## Getting Started

To build and run this sample, you will need:

*   Android Studio
*   Meta Quest 2, 3, or Pro headset
*   Meta Spatial SDK v0.8.0

## ISDK Integration

The ISDK is the default input system in Meta Spatial SDK v0.8.0. This sample demonstrates how to:

*   Enable and configure the ISDK for hand tracking and controller-based interactions.
*   Add grabbable properties to 3D objects to allow them to be grabbed and manipulated.
*   Handle interaction events to provide visual feedback and smooth grabbing and release behavior.

## Panel Orientation

The ISDK requires that panels be oriented with their normals pointing forward. This sample demonstrates how to create a Jetpack Compose UI panel with the correct orientation.

## Grabbable Setup

To make an object grabbable, you need to add the `Grabbable` and `Touchable` components to it. This sample demonstrates how to do this programmatically when an object is spawned into the scene.

## Best Practices

*   Use near-field interactions for objects that are close to the user and far-field interactions for objects that are further away.
*   Provide clear visual feedback to the user to indicate which objects are interactive and what actions can be performed on them.
*   Use the Meta Spatial Editor to create and edit your scene and to configure the properties of your 3D objects.
