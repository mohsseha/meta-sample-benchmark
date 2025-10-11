# Premium Media Sample

This sample demonstrates advanced media streaming features with the Meta Spatial SDK, including:

- **DRM-Protected Content Streaming**: Playback of Widevine DRM-protected content using ExoPlayer and `VideoSurfacePanel` with direct-to-surface rendering.
- **180-Degree Video Playback**: Immersive playback of 180-degree equirectangular videos.
- **MRUK Integration**: Panels can be snapped to walls detected in the user's environment using the Mixed Reality Utility Kit (MRUK).
- **Custom Shaders**: A custom shader is used to create a reflection effect on the video panel.
- **Multi-Process Architecture**: The media browser runs in a separate process for improved UI performance.

## How to Use

1.  Launch the application on a Meta Quest headset.
2.  You will be presented with a simple UI.
3.  Click the "Open Media Browser" button to open the media browser.
4.  Select a media item from the list.
5.  The selected video will be displayed on a panel in your spatial environment.
6.  If a wall is detected, the panel will be placed on the wall.
7.  You can toggle Passthrough mode by clicking the "Enable/Disable Passthrough" button.

## Code Overview

-   **`MainActivity.kt`**: The main activity that manages the scene, panels, and user interactions.
-   **`MediaBrowserActivity.kt`**: A separate activity for browsing and selecting media.
-   **`panels` package**: Contains different panel implementations for different media types.
-   **`player/VideoPlayer.kt`**: A wrapper around ExoPlayer that handles media playback and DRM.
-   **`mruk/MrukManager.kt`**: Manages MRUK integration for wall detection.
-   **`shaders` package**: Contains the shader manager and GLSL shader files.