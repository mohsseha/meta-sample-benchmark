
# Animations Sample

This sample application demonstrates various animation techniques available in the Meta Spatial SDK.

## Animation Techniques Demonstrated

### 1. glTF Animation Playback

This technique involves loading and playing animations directly from a `glTF` 3D model file. The `drone.gltf` model in this sample contains a simple rotation animation that is played back using the `FromGltf` animation source.

**Key APIs:**
- `rememberAnimation(FromGltf(...))`
- `Transform with animation`

### 2. Reusable Animation Drivers

This technique demonstrates how to create reusable animation systems that can be applied to any object in the scene. In this sample, a rotation animation is created programmatically and applied to a drone model. This animation can be easily reused for other objects.

**Key APIs:**
- `Animation.rotation(...)`
- `repeatable(...)`

### 3. Procedural Frame-Based Animation

This technique shows how to create animations that are calculated on a per-frame basis. This is useful for creating dynamic and interactive animations that are not based on pre-authored keyframes. In this sample, a drone's position and scale are animated using a sine wave function.

**Key APIs:**
- `FrameCallback { ... }`
- `rememberTransform()`
- `rememberScale()`

### 4. UI Animations

The sample also demonstrates how to animate UI elements using `AnimatedVisibility` from Jetpack Compose. This allows for smooth transitions when showing and hiding UI elements.

**Key APIs:**
- `AnimatedVisibility`

## How to Run the Sample

1.  **Set up your development environment:** Follow the official Meta Spatial SDK documentation to set up your development environment, including Android Studio and the Meta Spatial Editor CLI.
2.  **Build and run:** Open the project in Android Studio, connect your Meta Quest headset, and run the application.

## Project Structure

-   `app/src/main/java/com/meta/spatial/animation/sample/`: Contains the main application code.
    -   `MainActivity.kt`: The main entry point of the application.
    -   `AnimationScene.kt`: Contains the core logic for the scene and animations.
-   `app/src/main/assets/scenes/`: Contains the 3D models used in the application.
-   `app/src/main/res/`: Contains the application resources, such as drawables and layouts.
