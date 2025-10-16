# Hybrid Sample Application

This sample application demonstrates how to create a hybrid VR application for the Meta Spatial SDK that can switch between a 2D panel mode and a fully immersive VR mode.

## Overview

The application showcases the following key concepts:

*   **Mode Switching:** Seamlessly transition between a 2D panel and an immersive VR environment.
*   **Shared UI:**  Utilize the same Jetpack Compose UI in both panel and immersive modes.
*   **State Preservation:** Maintain application state across mode changes.

## Project Structure

The project follows a standard Android application structure:

*   `app/src/main/java/com/meta/hybrid/sample/MainActivity.kt`: The main entry point of the application, responsible for handling mode switching and hosting the UI.
*   `app/src/main/java/com/meta/hybrid/sample/ui/theme/`: Contains the Jetpack Compose theme files.
*   `app/src/main/AndroidManifest.xml`:  Declares the application's components and features, including support for both panel and immersive modes.
*   `build.gradle.kts`:  The project's build configuration, including dependencies on the Meta Spatial SDK.

## How it Works

The application uses the `PanelActivity` and `SpatialActivity` classes from the Meta Spatial SDK to launch the application in either panel or immersive mode. The `MainActivity` checks the intent data to determine which mode to launch.

The UI is built using Jetpack Compose, and the same composables are used in both modes. A simple state management system is used to preserve the application's state when switching between modes.

## Building and Running the Application

To build and run this application, you will need:

*   Android Studio
*   The Meta Quest 2, 3, or Pro headset
*   The Meta Spatial SDK configured in your development environment

1.  Open the project in Android Studio.
2.  Connect your Meta Quest headset to your computer.
3.  Build and run the application on your headset.

When the application launches, you will see a 2D panel with a button to switch to immersive mode. Clicking this button will transition the application to a fully immersive VR environment, where you will see the same UI panel floating in 3D space. You can then click the button again to switch back to panel mode.
