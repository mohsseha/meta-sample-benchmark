# MRUK Sample - Physical Environment Overlay App

This application demonstrates various capabilities of the Meta Spatial SDK's Mixed Reality Utility Kit (MRUK). It showcases how to build experiences that are influenced by the user's physical surroundings by overlaying virtual objects on top of detected physical objects in the room.

## Features

This sample application includes the following demonstration experiences:

*   **Surface Anchoring**: This experience demonstrates how to place virtual objects on detected physical surfaces like tables, floors, and walls.
*   **Keyboard Tracker**: This experience shows how to track the position and rotation of a physical keyboard in the user's environment.
*   **QR Code Scanner**: This experience demonstrates how to detect and read QR codes in the physical environment.
*   **Raycasting**: This experience shows how to use raycasting to interact with the physical environment and place objects on detected surfaces.

## Getting Started

To build and run this application, you will need:

*   Android Studio
*   Meta Quest 2, 3, or Pro headset
*   Meta Spatial SDK v0.8.0

## Building the Application

1.  Clone this repository.
2.  Open the project in Android Studio.
3.  Connect your Meta Quest headset to your computer.
4.  Build and run the application.

## How to Use

Once the application is running on your Meta Quest headset, you can use the buttons in the main menu to switch between the different demonstration experiences.

## Code Overview

*   `MainActivity.kt`: The main entry point of the application. It handles permission requests and allows the user to select which MRUK demonstration to run.
*   `experiences/`: This directory contains the code for each of the individual demonstration experiences.
    *   `SurfaceAnchorExperience.kt`: Demonstrates how to place virtual objects on detected physical surfaces.
    *   `KeyboardTrackerExperience.kt`: Demonstrates how to track a physical keyboard.
    *   `QRCodeScannerExperience.kt`: Demonstrates how to detect and respond to QR codes.
    *   `RaycastExperience.kt`: Demonstrates how to use raycasting to interact with the physical environment.
*   `assets/`: This directory contains placeholder assets used in the application, such as 3D models and UI graphics.
