
# Hybrid Sample - Panel and Immersive Mode Switching App

This sample application demonstrates how to build a "hybrid" VR experience for the Meta Spatial SDK v0.8.0. A hybrid app can switch between a standard Android 2D panel mode and a full immersive VR mode, hosting the same UI panel in both contexts.

## Objective

The goal of this sample is to show developers how to:

- Create an activity that can run in both panel (2D) and immersive (3D VR) modes.
- Implement a mode switching mechanism to toggle between panel and immersive experiences.
- Share UI components (Jetpack Compose) between both modes.
- Manage application state to preserve data across mode transitions.

## How it Works

This sample uses a single `MainActivity` that extends `SpatialActivity`. The `SpatialActivity` class provides the core functionality for handling mode switching. The UI is built with Jetpack Compose, and the same composables are used in both panel and immersive modes. A `MainViewModel` is used to store the application state, ensuring that it is preserved when the mode changes.

### Mode Switching

The `switchToMode()` method of the `SpatialActivity` is used to switch between `Mode.PANEL` and `Mode.IMMERSIVE`. The `onModeSwitched()` callback is used to notify the application when the mode has changed.

### State Management

A simple `MainViewModel` is used to hold the current mode. This view model is retained across configuration changes (including mode switches), so the state is not lost.

## How to Run the Sample

To run this sample, you will need:

- A Meta Quest 2, 3, or Pro headset.
- Android Studio with the Meta Spatial SDK installed.
- The Meta Spatial Editor CLI.

1.  Open the project in Android Studio.
2.  Connect your Meta Quest headset to your computer.
3.  Build and run the application.

When the application launches, it will be in panel mode. You can use the button on the screen to switch to immersive mode. In immersive mode, you will see the same UI panel floating in a simple 3D environment. You can use the button to switch back to panel mode.

## Project Structure

-   `MainActivity.kt`: The main activity that handles mode switching and UI.
-   `MainViewModel.kt`: The view model that stores the application state.
-   `build.gradle.kts`: The Gradle build file with dependencies for the Meta Spatial SDK and Jetpack Compose.
-   `AndroidManifest.xml`: The Android manifest file that declares the main activity and VR features.

## When to Use a Hybrid Approach

A hybrid approach is useful when you want to provide a "lite" experience in a 2D panel, with the option to enter a full immersive VR experience. This can be a good way to ease users into VR, or to provide a quick way to access your application's content without needing to enter a fully immersive environment.

Some examples of when you might use a hybrid approach:

-   A media player that allows users to browse and play videos in a 2D panel, with the option to enter a VR cinema to watch the video.
-   A social application that allows users to chat and view profiles in a 2D panel, with the option to enter a VR space to interact with other users.
-   A productivity application that allows users to manage tasks and documents in a 2D panel, with the option to enter a VR workspace to visualize data or collaborate with others.
