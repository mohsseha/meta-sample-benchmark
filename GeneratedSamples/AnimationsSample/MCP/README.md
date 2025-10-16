# Animations Sample

This sample application demonstrates various animation techniques available in the Meta Spatial SDK v0.8.0.

## Animation Techniques Demonstrated

### 1. glTF Animation Playback

This technique involves playing animations that are embedded within a glTF 3D model file. The `GltfAnimationSystem` is responsible for loading a glTF model and playing its animation. The animation is played using the `Animated` component.

### 2. Reusable Animation Drivers & Procedural Frame-Based Animation

This technique demonstrates how to create animations programmatically in code. The `ProceduralAnimationSystem` creates a simple animation that moves a cube up and down. This system is reusable and can be applied to any entity. The animation is calculated per-frame in the `onUpdate` function.

### 3. UI Animations

This technique demonstrates how to create animated UI elements using Jetpack Compose. The `UiAnimationSystem` creates a simple UI with a button that scales up and down when clicked. The UI is rendered on a `ComposePanel` in the 3D scene.

## How to Run the Sample

This project is a standard Android application and can be built and run using Android Studio. You will need to have the Meta Spatial SDK set up in your development environment.

**Note:** The glTF model and UI elements are simple placeholders. The focus of this sample is on the code structure and animation systems.