
# Starter Sample

This is a starter sample for the Meta Spatial SDK. It demonstrates how to create a simple VR application that displays a welcome panel in an immersive 3D environment.

## How to Use

To build and run this sample, you will need to have the Meta Spatial SDK and Android Studio set up.

1.  Open the project in Android Studio.
2.  Connect your Meta Quest device to your computer.
3.  Build and run the application on your device.

When you launch the application, you should see a welcome panel floating in front of you.

## Code Overview

*   `MainActivity.kt`: The main entry point of the application. It initializes the VR scene, sets up the environment, and spawns the welcome panel.
*   `ui/WelcomePanel.kt`: A Jetpack Compose composable that defines the UI of the welcome panel.
*   `assets/scenes/main.glxf`: The scene file that contains the 3D environment.
*   `build.gradle`: The Gradle build file for the application. It includes the necessary dependencies for the Meta Spatial SDK and Jetpack Compose.
*   `AndroidManifest.xml`: The Android manifest file. It includes the necessary metadata for a VR application.
