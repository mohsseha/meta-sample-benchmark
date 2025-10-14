# Animations Sample - Meta Spatial SDK

This sample application demonstrates various animation techniques available in the Meta Spatial SDK v0.8.0.

## Animation Techniques Demonstrated

### 1. glTF Animation Playback

This technique involves loading and playing animations that are embedded in a glTF 3D model file.

- **`GltfAnimationComponent`**: This component stores the name of the animation to be played.
- **`GltfAnimationSystem`**: This system is responsible for playing the animation. (Note: This is a placeholder implementation as the exact APIs are not documented).

### 2. Procedural Frame-Based Animation

This technique involves programmatically calculating the animation for each frame. In this sample, we animate the drone's position in a circle.

- **`ProceduralAnimationComponent`**: This component stores the parameters for the circular animation (radius, speed).
- **`ProceduralAnimationSystem`**: This system updates the entity's position based on the parameters in the `ProceduralAnimationComponent`.

### 3. Reusable Animation Drivers

This technique involves creating reusable animation systems that can be applied to any entity. In this sample, we create a system that animates the scale of an entity.

- **`ScaleAnimationComponent`**: This component stores the parameters for the scale animation (from, to, duration).
- **`ScaleAnimationSystem`**: This system updates the entity's scale based on the parameters in the `ScaleAnimationComponent`.

## Project Structure

- **`MainActivity.kt`**: The main entry point of the application.
- **`DroneController.kt`**: A controller responsible for setting up the scene, creating the drone entity, and registering the animation systems.
- **`AnimationComponents.kt`**: Contains the data components for the different animation techniques.
- **`AnimationSystems.kt`**: Contains the systems that implement the logic for the different animation techniques.
- **`assets/models/drone.gltf`**: A placeholder 3D model of a drone with a simple animation.
- **`assets/scenes/Main.metaspatial`**: The main scene file for the Spatial Editor.

## How to Run

1.  Open the project in Android Studio.
2.  Build and run the application on a Meta Quest device.
3.  Once the application starts, you will see a drone animating in a circle while also scaling up and down.