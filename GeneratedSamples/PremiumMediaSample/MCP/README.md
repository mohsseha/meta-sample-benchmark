
# Premium Media Sample

This sample application demonstrates advanced media streaming features with the Meta Spatial SDK v0.8.0. It showcases how to integrate DRM-protected content, 180-degree video playback, custom shaders, and MRUK for wall snapping into an immersive media experience.

## Features

*   **DRM-Protected Content Streaming**: Playback of Widevine DRM-protected content using ExoPlayer.
*   **180-Degree Video Playback**: Immersive playback of 180-degree equirectangular video.
*   **MRUK Wall Snapping**: Discover walls in the user's environment and snap video panels to them.
*   **Custom Shaders**: Apply custom shaders to panels for effects like reflections.
*   **Multi-Process Architecture**: The video player runs in a separate process for improved performance and stability, especially when using Jetpack Compose.
*   **Passthrough Mode**: Toggle between a virtual environment and the real world with passthrough.

## Project Structure

*   `app/src/main/java`: Main application source code.
    *   `MainActivity.kt`: The main entry point of the application, displaying the media library.
    *   `VideoPlayerActivity.kt`: The activity responsible for video playback, running in a separate process.
    *   `VideoPlayer.kt`: A helper class that encapsulates ExoPlayer logic, including DRM handling.
    *   `MRUKManager.kt`: A helper class for interacting with MRUK to find walls.
    *   `ShaderManager.kt`: A helper class for loading and applying custom shaders.
    *   `ui/`: Jetpack Compose UI code.
*   `app/src/main/assets/shaders`: Custom GLSL shader files.
*   `app/src/main/cpp/CMakeLists.txt`: CMake build script for the custom shaders.

## How to Build

1.  Make sure you have the Android NDK installed.
2.  Open the project in Android Studio.
3.  Sync Gradle.
4.  Build and run the application on a Meta Quest device.

## Notes

*   The media URLs in `MediaLibraryScreen.kt` are placeholders. You will need to replace them with your own media URLs.
*   The DRM license URL in `VideoPlayer.kt` is also a placeholder. You will need to replace it with your own license server URL.
*   The shader implementation is a simple example. You can create more complex shaders for different effects.
*   The MRUK wall snapping logic is simplified. A real implementation would need to handle more complex scenarios.
