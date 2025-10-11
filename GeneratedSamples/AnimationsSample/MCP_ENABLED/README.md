# Animations Sample

This sample application demonstrates various animation techniques using the Meta Spatial SDK.

## How to Build

This project is set up to be built without the Meta Spatial Gradle Plugin. To build this project, you will need to have the Meta Spatial SDK installed and configured in your environment. You will also need to manually add the Meta Spatial SDK dependencies to your project.

## Animation Techniques Demonstrated

### 1. glTF Animation Playback

The `GltfAnimationSystem` is responsible for playing animations embedded in glTF models. It listens for entities with an `AnimatedObject` component that specifies a `modelPath`. When such an entity is added, the system:

1.  Adds a `GltfComponent` to the entity.
2.  Once the glTF model is loaded, it creates an `Animation` from the glTF data.
3.  Sets the animation to loop and plays it.

This is demonstrated with the `drone.gltf` model in the `MainScene`.

### 2. Reusable Animation Drivers

The `ReusableAnimationDriver` class showcases how to create reusable animation logic that can be applied to multiple entities. This driver implements a simple floating animation using a `ValueAnimator`.

The `ProceduralAnimationSystem` uses this driver to animate entities with the `isProcedural` flag set in their `AnimatedObject` component. The system creates a new driver for each entity and manages its lifecycle.

### 3. Procedural Frame-Based Animation

The `ProceduralAnimationSystem` also demonstrates procedural animation. By using a `ValueAnimator`, it calculates the position of an entity on each frame, creating a smooth animation without pre-authored animation data.

This is demonstrated with the two cube entities in the `MainScene`. Each cube gets its own `ReusableAnimationDriver`, and they are animated independently.

## Project Structure

-   `MainActivity.kt`: The main entry point of the application.
-   `MainScene.kt`: The main scene where the animated objects are placed.
-   `animation/`: This package contains the animation systems and drivers.
    -   `GltfAnimationSystem.kt`: System for playing glTF animations.
    -   `ProceduralAnimationSystem.kt`: System for procedural animations.
    -   `ReusableAnimationDriver.kt`: A reusable driver for a floating animation.
-   `component/`: This package contains the `AnimatedObject` component.
    -   `AnimatedObject.kt`: A component to mark an entity as animated and provide animation-related data.