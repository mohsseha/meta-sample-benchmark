# MRUK Sample - Physical Environment Overlay App

This is a sample application that demonstrates how to build mixed reality experiences with the Meta Spatial SDK v0.8.0 that are influenced by the user's physical surroundings. The application overlays virtual objects on top of detected physical objects in the room (tables, couches, windows, doors, beds, etc.).

## Experiences

The application includes the following demonstration experiences:

### 1. Surface Anchoring

This experience demonstrates how to anchor virtual 3D models to physical surfaces. It uses the MRUK APIs to detect horizontal planes in the user's environment and places a virtual cube on each detected plane.

**To run this experience:**

1. Launch the application.
2. Click the "Surface Anchoring" button.

### 2. Object Tracking

This experience demonstrates how to track a physical object, in this case a keyboard. It uses the MRUK APIs to detect the keyboard and then overlays a virtual representation of it.

**To run this experience:**

1. Launch the application.
2. Click the "Object Tracking" button.
3. Make sure you have a physical keyboard in your environment.

### 3. QR Code Integration

This experience demonstrates how to detect QR codes in the environment and display their content. It uses the MRUK APIs to scan for QR codes and then displays the decoded text in a panel.

**To run this experience:**

1. Launch the application.
2. Click the "QR Code Integration" button.
3. Point your headset at a QR code.

### 4. Raycasting

This experience demonstrates how to use raycasting to interact with the physical environment. It casts a ray from the center of the screen and places a cube at the intersection point with a physical surface.

**To run this experience:**

1. Launch the application.
2. Click the "Raycasting" button.
3. Look around your environment to place cubes on surfaces.

## How to Build and Run

To build and run this application, you will need to have the Meta Spatial SDK v0.8.0 and Android Studio set up.

1. Open the project in Android Studio.
2. Build the application and deploy it to a Meta Quest headset.

## Code Structure

The code is organized into the following packages:

- `com.meta.mruksample`: The main package for the application.
- `com.meta.mruksample.surfaceanchoring`: The Surface Anchoring experience.
- `com.meta.mruksample.objecttracking`: The Object Tracking experience.
- `com.meta.mruksample.qrcode`: The QR Code Integration experience.
- `com.meta.mruksample.raycasting`: The Raycasting experience.

Each experience is implemented in its own activity. The `MainActivity` class is the main entry point of the application and displays a menu to launch the different experiences.
