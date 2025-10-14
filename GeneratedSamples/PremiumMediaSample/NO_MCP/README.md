# Premium Media Sample for Meta Spatial SDK

This application demonstrates advanced media streaming capabilities using the Meta Spatial SDK. It showcases features like DRM-protected content playback, 180-degree equirectangular video, panel snapping to walls using MRUK, and custom shaders for reflections.

## Features

### 1. DRM-Protected Content Streaming
The application uses ExoPlayer with a `DefaultDrmSessionManager` to handle Widevine DRM-protected content. The `DirectToSurfaceVideoPanel` is used for secure, high-performance rendering directly to a surface, which is a requirement for DRM content.

### 2. 180-Degree Equirectangular Video
For immersive 180-degree videos, the `EquirectangularVideoPanel` is used. This panel type correctly projects the equirectangular video format, creating an immersive viewing experience.

### 3. MRUK Integration for Wall Snapping
The application uses the Mixed Reality Utility Kit (MRUK) to access the user's room layout. It queries for wall anchors and snaps the video panels to the detected walls, integrating the virtual content with the user's physical environment.

### 4. Custom Shaders for Reflections
A custom GLSL shader is used to create a reflection effect on the walls. The shader takes the scene texture from the `PassthroughSystem` as input and applies it to the wall material, simulating the video panel's light reflecting on the surface.

### 5. Multi-Process Architecture for UI
The media selection UI is implemented using Jetpack Compose and runs in a separate process. This is a performance optimization technique to prevent the UI from impacting the main render thread of the immersive application.

## Project Structure
- **app**: The main application module, containing the immersive experience, media playback, panel implementations, MRUK integration, and shader management.
- **media-ui**: A separate module for the Jetpack Compose-based media selection UI.
- **app/src/main/assets/shaders**: Contains the GLSL shader code.
- **app/src/main/jni**: Contains the NDK build scripts for compiling the shaders.

## How to Build and Run
1.  Make sure you have the Meta Spatial SDK and Android Studio set up correctly.
2.  Install the NDK in Android Studio.
3.  Open the project in Android Studio.
4.  Build and run the application on a Meta Quest device.
