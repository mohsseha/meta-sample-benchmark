# 3D Object Sample

This sample demonstrates how to create an immersive VR application for Meta Spatial SDK v0.8.0 that allows users to select from a set of 3D objects and insert them into a custom scene environment.

## How to Use

1.  **Build and run the application** on a Meta Quest headset.
2.  **Select an object** from the UI panel.
3.  **The selected object will be added** to the scene in front of you.

## Scene Structure

The scene is loaded from the `app/src/main/assets/scenes/main.xml` file. This file defines the initial scene, including the environment and lighting. The 3D models are loaded from the `app/src/main/assets/models` directory.

## Meta Spatial Editor Integration

The scene structure is compatible with the Meta Spatial Editor. You can open the `main.xml` file in the editor to adjust the properties of the scene and objects. For example, you can change the position, rotation, and scale of the objects, as well as the color and intensity of the lights.
