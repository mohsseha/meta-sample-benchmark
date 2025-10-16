
# Physics Sample

This is a sample application for the Meta Spatial SDK that demonstrates how to use the physics system.

## Overview

This application showcases how to:

*   Enable the physics system in your application.
*   Add `PhysicsComponent` to entities in your scene.
*   Configure physics properties such as mass, friction, and bounciness.
*   Create custom systems to interact with physics-enabled entities.
*   Use different types of physics bodies: static, dynamic, and kinematic.

## Project Structure

The project is a standard Android application with the following structure:

*   `app/src/main/java/com/meta/spatial/physics/sample`: The main package for the application.
    *   `MainActivity.kt`: The main activity that initializes the Meta Spatial SDK and the world.
    *   `components`: Custom components for the different interaction types.
    *   `systems`: Custom systems that implement the logic for the different interaction types.
*   `app/src/main/assets/scenes`: The scene files for the application.
    *   `physics_scene.glxf`: The main scene file.
    *   `physics_scene.gltf`: The 3D model file for the scene.

## How to Use

To use this sample, you will need to have the Meta Spatial SDK set up in your development environment. You can then build and run this application on a Meta Quest headset.

When you launch the application, you will see a scene with several objects:

*   A static floor.
*   A dynamic cube that you can grab and throw.
*   A button that you can press.
*   A trigger that you can pull.
*   A spinner that you can rotate.

## Adjusting Physics Properties in the Meta Spatial Editor

You can adjust the physics properties of the objects in the scene using the Meta Spatial Editor. To do this, open the `physics_scene.glxf` file in the editor. You can then select an object in the scene and edit its `PhysicsComponent` properties in the inspector.

For example, you can change the mass of the dynamic cube to make it heavier or lighter. You can also change the friction of the floor to make it more or less slippery.

## Custom Interaction Systems

This sample includes three custom interaction systems:

*   `ButtonSystem`: This system applies a force to the button when it is pressed.
*   `TriggerSystem`: This system applies a force to the trigger when it is pulled.
*   `SpinnerSystem`: This system applies a torque to the spinner to make it rotate.

These systems are a good example of how to create your own custom interactions with the physics system. You can create your own custom systems to implement any type of interaction you can imagine.
