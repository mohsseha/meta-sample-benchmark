# Hybrid Sample - Panel and Immersive Mode Switching App

This sample demonstrates how to build a "hybrid" VR application for the Meta Spatial SDK that can switch between a standard Android 2D panel mode and a full immersive VR mode.

## Overview

The application starts in panel mode, displaying a simple UI created with Jetpack Compose. The user can then switch to an immersive VR environment where the same UI panel is displayed in a 3D scene. The user can seamlessly toggle back and forth between the two modes without losing the application state.

## How it Works

### 1. `PanelActivity`

The core of this hybrid application is the `com.meta.xr.vrshell.panel.PanelActivity` class. By extending this class, your activity can support both panel and immersive modes.

### 2. Mode Switching

The `PanelActivity` provides the following methods to switch between modes:

- `requestImmersiveMode()`: Switches the application to the immersive VR mode.
- `requestPanelMode()`: Switches the application back to the 2D panel mode.

In this sample, the `HybridAppPanel` composable contains a button that calls these methods to toggle between the modes.

### 3. Immersive Scene

When the application switches to immersive mode, the `PanelActivity` calls the `createImmersiveScene()` method. This method should return an instance of a `com.meta.xr.sdk.scene.MetaScene` subclass, which defines the 3D environment.

In this sample, the `AppScene` class creates a simple immersive environment.

### 4. `AndroidManifest.xml`

To enable the hybrid mode, the `AndroidManifest.xml` file must be configured as follows:

- The activity's `meta-data` for `com.meta.xr.hybrid.app.mode` should be set to `"hybrid"`.
- An additional `intent-filter` for the `com.meta.xr.intent.action.LAUNCH` action and `com.meta.xr.intent.category.IMMERSIVE` category should be added to the activity.

### 5. State Preservation

The application state is preserved across mode switches by using a `ViewModel`. The `MainViewModel` holds the `isImmersiveMode` state, which is observed by the `MainActivity` and the `HybridAppPanel` composable.

## How to Build and Run

1.  **Set up your development environment:** Follow the instructions in the [Meta Spatial SDK documentation](https://developer.meta.com/horizon/spatial-sdk/documentation/development/getting-started/) to set up your development environment for Meta Quest development.
2.  **Open the project:** Open this project in Android Studio.
3.  **Build and run:** Build and run the application on your Meta Quest headset.

## Project Structure

- **`MainActivity.kt`**: The main activity of the application, which extends `PanelActivity`.
- **`MainViewModel.kt`**: The `ViewModel` that holds the application state.
- **`HybridAppPanel.kt`**: The Jetpack Compose UI for the application.
- **`scene/AppScene.kt`**: The class that defines the immersive VR scene.
- **`AndroidManifest.xml`**: The Android manifest file, configured for hybrid mode.
- **`build.gradle.kts`**: The Gradle build file, with the necessary dependencies for the Meta Spatial SDK.
