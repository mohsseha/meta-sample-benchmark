# MRUK Sample - Physical Environment Overlay App

This application is a sample project for the Meta Spatial SDK v0.8.0. It demonstrates how to build mixed reality experiences that are influenced by the user's physical surroundings. The app overlays virtual objects on top of detected physical objects in the room, such as tables, couches, windows, and doors.

## Features

This sample showcases several key features of the Mixed Reality Utility Kit (MRUK):

*   **Scene Understanding**: The application requests and processes scene data from the Meta Quest headset to understand the layout of the user's room.
*   **Object Detection**: It detects and classifies various physical objects, including furniture and architectural elements.
*   **Surface Anchoring**: Virtual objects are anchored to the surfaces of detected physical objects.
*   **Keyboard Tracking**: The application can detect and track the position of a physical keyboard.
*   **QR Code Scanning**: It can detect and respond to QR codes in the environment.
*   **Raycasting**: The app uses raycasting to interact with the physical environment and place objects on surfaces.

## Experiences

The application includes four demonstration experiences:

### 1. Anchor Mesh Experience

This experience demonstrates how to anchor virtual 3D models to physical surfaces. The application detects various objects in the room (tables, couches, etc.) and places a corresponding virtual object on top of each one.

### 2. Keyboard Tracker Experience

This experience shows how to detect and track a physical keyboard in mixed reality. A virtual model is placed at the position of the detected keyboard.

### 3. QR Code Scanner Experience

This experience demonstrates how to detect and process QR codes in the physical environment. When a QR code is detected, its data is logged to the console.

### 4. Raycast Experience

This experience showcases how to use raycasting to interact with the physical environment. The user can point their controller and press a button to place a virtual object on the surface they are pointing at.

## How to Use

To run this application, you will need to have the Meta Spatial SDK v0.8.0 and the necessary development tools set up.

1.  **Build the application**: Build the project using Gradle.
2.  **Run on a Meta Quest headset**: Deploy the application to a Meta Quest 2, 3, or Pro headset.
3.  **Grant permissions**: When the application starts, it will request permission to access scene data. You must grant this permission for the application to function correctly.
4.  **Select an experience**: Use the buttons on the UI to switch between the four different experiences.

## Project Structure

The project is a standard Android application with the following key components:

*   `MainActivity.kt`: The main entry point of the application. It manages the UI and the different experiences.
*   `PermissionManager.kt`: A helper class for managing scene permissions.
*   `experiences/`: This directory contains the implementation of the four demonstration experiences:
    *   `AnchorMeshExperience.kt`
    *   `KeyboardTrackerExperience.kt`
    *   `QRCodeScannerExperience.kt`
    *   `RaycastExperience.kt`
*   `res/layout/activity_main.xml`: The layout file for the main activity.
*   `assets/models/`: This directory contains the placeholder 3D models used in the application.