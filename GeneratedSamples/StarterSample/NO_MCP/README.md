# Starter Sample for Meta Spatial SDK

This is a starter sample application for the Meta Spatial SDK v0.8.0. It demonstrates how to create a basic immersive VR application that displays a welcome panel with app information.

## Features

*   **Immersive VR Experience**: The application is configured to run as an immersive VR experience on Meta Quest headsets.
*   **Welcome Panel**: A welcome panel is displayed in the 3D environment using Jetpack Compose.
*   **Scene and Environment**: The application loads a simple 3D scene with a skybox and directional lighting.
*   **Meta Spatial SDK Integration**: The application demonstrates how to initialize the Meta Spatial SDK, request features, and interact with the SDK's APIs.

## Project Structure

*   `app/src/main/java/com/meta/starter/sample/MainActivity.kt`: The main activity of the application.
*   `app/src/main/assets/scenes/main.glxf`: The scene file that defines the 3D environment.
*   `app/build.gradle.kts`: The build script for the application module.
*   `build.gradle.kts`: The build script for the root project.
*   `settings.gradle.kts`: The settings script for the project.

## How to Build and Run

**Note**: This project is intended for code generation and cannot be built or run in a standard development environment. It requires the Meta Spatial SDK and proprietary tooling (Spatial Editor CLI) to be installed.

To build and run this project, you will need to:

1.  Set up a development environment for Meta Quest development.
2.  Install the Meta Spatial SDK v0.8.0.
3.  Install the Meta Spatial Editor CLI.
4.  Open the project in Android Studio.
5.  Build and run the application on a connected Meta Quest headset.
