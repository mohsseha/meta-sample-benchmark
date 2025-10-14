# Physics Sample

This sample application demonstrates how to use the physics system in the Meta Spatial SDK. It showcases how to add physics components to 3D objects, configure their properties, and create custom interaction systems.

## Features

*   **Physics-enabled objects**: The application includes several 3D objects with physics components, allowing them to collide, bounce, and respond to forces realistically.
*   **Custom interaction systems**: The application implements custom systems for different interaction types, including:
    *   **Buttons**: Objects that can be pushed and respond with physics.
    *   **Triggers**: Pull-able mechanisms with physics constraints.
    *   **Spinners**: Rotatable objects with angular physics.
*   **Scene loading**: The application loads a 3D scene from a glXF file, which defines the objects and their properties.
*   **Meta Spatial Editor integration**: The physics properties of the objects can be adjusted in the Meta Spatial Editor.

## Getting Started

To build and run this sample application, you will need:

*   Android Studio
*   Meta Quest 2/3/Pro headset
*   Meta Spatial SDK v0.8.0

To build and run the application:

1.  Open the project in Android Studio.
2.  Connect your Meta Quest headset to your computer.
3.  Click the "Run" button in Android Studio.

## How it Works

The application uses the Entity Component System (ECS) architecture of the Meta Spatial SDK. The physics interactions are implemented using custom systems that operate on entities with specific components.

### Physics Components

The `Physics` component is added to the 3D objects in the `scene.glxf` file. This component enables physics for the objects and allows you to configure their properties, such as mass, bounciness, and friction.

### Custom Interaction Systems

The application includes three custom interaction systems:

*   `ButtonSystem`: This system handles the logic for the buttons. It checks for collisions with the user's hands and applies a force to the button to simulate it being pressed.
*   `TriggerSystem`: This system handles the logic for the triggers. It checks for collisions with the user's hands and applies a force to the trigger to simulate it being pulled.
*   `SpinnerSystem`: This system handles the logic for the spinners. It checks for collisions with the user's hands and applies a torque to the spinner to make it spin.

### Main Activity

The `MainActivity` is the main entry point of the application. It is responsible for:

*   Registering the custom components and systems.
*   Adding the `PhysicsFeature`.
*   Loading the 3D scene.

## Meta Spatial Editor

The physics properties of the objects in this sample can be adjusted in the Meta Spatial Editor. To do this:

1.  Open the `scene.glxf` file in the Meta Spatial Editor.
2.  Select an object in the scene.
3.  In the "Properties" panel, you can adjust the physics properties of the object, such as its mass, bounciness, and friction.
