# Premium Media Sample for Meta Spatial SDK v0.8.0

This sample application demonstrates advanced media streaming features within the Meta Spatial SDK. It showcases how to create an immersive media experience that integrates with the user's spatial environment, including support for DRM-protected content, 180-degree video, and custom shaders.

## Features

*   **Immersive Media Streaming**: Watch videos in an immersive environment that blends with your physical space.
*   **Multiple Media Formats**: Supports standard video, 180-degree equirectangular video, and DRM-protected content.
*   **DRM Protection**: Implements Widevine DRM for secure content streaming, using a `DirectToSurfacePanel` for a secure video path.
*   **180-Degree Video**: Experience immersive 180-degree video playback with stereoscopic rendering.
*   **MRUK Integration**: Video panels can be "snapped" to the walls of your room, using the Mixed Reality Utility Kit (MRUK) to detect room geometry.
*   **Custom Shaders**: A custom reflection shader is applied to the video panels, creating a visual effect of the panel casting light onto the surrounding environment.
*   **Passthrough Mode**: Seamlessly switch between a fully immersive VR environment and a passthrough mode that shows your physical surroundings.
*   **High-Performance UI**: The media selection UI is built with Jetpack Compose and runs in a separate process to ensure high performance and a smooth user experience.

## Project Structure

The project follows a standard Android application structure, with the addition of specific components for the Meta Spatial SDK.

*   `app/src/main/java`: The main source code for the application.
    *   `MainActivity.kt`: The main entry point for the application, handling the Spatial SDK setup and core logic.
    *   `ComposeActivity.kt`: A separate activity for the Jetpack Compose UI, running in its own process.
    *   `data`: Contains the `MediaItem` data class and the `MediaLibrary` that provides the list of media to play.
    *   `mruk`: The `MrukManager` class for handling MRUK integration.
    *   `panels`: Implementations for the different video panel types (`StandardVideoPanel`, `DrmVideoPanel`, `EquirectangularVideoPanel`).
    *   `player`: The `VideoPlayer` class that manages the ExoPlayer instance.
    *   `shaders`: The `ShaderManager` class for loading and applying custom shaders.
    *   `ui`: The Jetpack Compose UI for the media selection screen.
*   `app/src/main/assets/shaders`: The GLSL source code for the custom reflection shader.
*   `app/src/main/cpp`: The C++ source code and `CMakeLists.txt` for the NDK build, used to compile the custom shaders.

## How to Run

To run this sample, you will need:

*   An Android development environment with the Android NDK installed.
*   A Meta Quest 2, 3, or Pro headset.
*   The Meta Spatial SDK v0.8.0.

1.  Clone this repository.
2.  Open the project in Android Studio.
3.  Build and run the application on your Meta Quest headset.

## Technical Details

### DRM

DRM-protected content is played using ExoPlayer's built-in support for Widevine DRM. A `DirectToSurfacePanel` is used to provide a secure video path to the headset's display.

### 180-Degree Video

180-degree equirectangular video is also played using ExoPlayer. The `sphericalV2` parameter is set on the `MediaItem` to tell ExoPlayer that the video is spherical.

### MRUK

The `MrukManager` class uses the `SceneFeature` to query for walls in the user's environment. When a wall is found, the video panel is positioned and oriented to appear as if it is "snapped" to the wall.

### Custom Shaders

The custom reflection shader is written in GLSL and compiled to SPIR-V by the Meta Spatial Plugin for Gradle. The `ShaderManager` class loads the compiled shader from the assets and applies it to the video panel.

### Multi-Process UI

The Jetpack Compose UI runs in a separate process from the main application logic. This is a key performance optimization for the Meta Spatial SDK, as it prevents the UI from blocking the main render thread. Communication between the two processes is handled using a `BroadcastReceiver`.
