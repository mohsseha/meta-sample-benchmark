# Animations Sample

This sample demonstrates various animation techniques available in the Meta Spatial SDK.

## Animation Techniques Demonstrated

### 1. glTF Animation Playback

This technique involves loading a 3D model (in glTF format) that has animations embedded within the file. The Spatial SDK can then play these animations.

**File:** `GltfAnimatedObject.kt`

This file shows how to load a `glb` model and play its animation in a loop. The `Model` composable is used with an `Animation` parameter to control playback.

### 2. Reusable Animation Drivers

This technique demonstrates how to create a reusable animation driver that can be used to animate multiple objects. This is useful for creating complex animations that are synchronized across multiple objects.

**File:** `ReusableAnimationDriverExample.kt`

This file shows how to create a simple animation driver that toggles an animation on and off every 2 seconds. The `ReusableAnimatedObject` composable takes a boolean to control its animation state.

### 3. Procedural Frame-Based Animation

This technique involves calculating the animation properties of an object on a frame-by-frame basis. This is useful for creating dynamic animations that are not based on pre-authored animation data.

**File:** `ProceduralAnimationExample.kt`

This file shows how to create a simple procedural animation that moves a box up and down using a sine wave. The `produceState` composable is used to create a value that changes over time.

### 4. UI Animations

This technique demonstrates how to add animations to UI elements.

**File:** `AnimatedUI.kt`

This file shows how to create a simple UI with a button that increments a counter. While this example does not have explicit animations, the underlying UI components of the Spatial SDK are built with animations in mind and will provide animated feedback to user interactions.

## How to Run the Sample

1.  Open the project in Android Studio.
2.  Connect your Meta Quest device.
3.  Build and run the app on your device.
