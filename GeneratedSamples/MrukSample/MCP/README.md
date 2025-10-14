# MRUK Sample - Physical Environment Overlay App

This is a sample application demonstrating the capabilities of the Meta Spatial SDK's Mixed Reality Utility Kit (MRUK). It showcases how to build mixed reality experiences that are influenced by the user's physical surroundings.

## Features

This application provides several demonstrations of MRUK features:

*   **Anchor Mesh**: This demo shows how to anchor virtual objects to physical surfaces like walls, tables, and floors.
*   **Keyboard Tracker**: This demo shows how to detect and track a physical keyboard in the user's environment.
*   **QR Code Scanner**: This demo shows how to detect and scan QR codes in the physical world.
*   **Raycast**: This demo shows how to use raycasting to interact with the physical environment.

## How to Build and Run

This is a standard Android project. To build and run this application, you will need:

*   Android Studio Hedgehog or newer
*   Meta Quest 2, 3, or Pro headset
*   Meta Spatial SDK v0.8.0

1.  Open the project in Android Studio.
2.  Select the `questDebug` build variant.
3.  Build and run the application on your Meta Quest headset.

## Permissions

This application requires the following permissions:

*   `com.meta.permission.USE_SCENE_DATA`: To access scene data for room understanding.
*   `com.oculus.permission.USE_ANCHOR_API`: To create and manage spatial anchors.

## Code Structure

*   `MainActivity.kt`: The main entry point of the application. It provides a menu to launch the different MRUK demos.
*   `mruk/`: This package contains the activities for each of the MRUK demos.
    *   `AnchorMeshActivity.kt`: Demonstrates anchoring virtual objects to physical surfaces.
    *   `KeyboardTrackerActivity.kt`: Demonstrates tracking a physical keyboard.
    *   `QrCodeScannerActivity.kt`: Demonstrates scanning QR codes.
    *   `RaycastActivity.kt`: Demonstrates raycasting against the physical environment.
*   `assets/`: This directory contains placeholder assets used in the demos.

## MRUK Best Practices

*   **Request Permissions**: Always request the necessary permissions from the user before accessing scene data or creating anchors.
*   **Handle Permission Denial**: Gracefully handle cases where the user denies permission.
*   **Adapt to Different Environments**: Your application should be able to adapt to different room layouts and furniture configurations.
*   **Use Placeholders**: Use placeholder assets during development to focus on the MRUK integration.
