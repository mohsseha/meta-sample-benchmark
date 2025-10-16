# Premium Media Sample

This sample demonstrates advanced media streaming features with the Meta Spatial SDK. It includes:

- **DRM-protected content streaming**: Plays Widevine-protected content using ExoPlayer.
- **180-degree video playback**: Displays 180-degree equirectangular video on a spherical panel.
- **MRUK integration**: Snaps video panels to walls detected in the user's environment.
- **Custom shaders**: Applies a custom reflection shader to the video panels.
- **Multiple panel types**: Uses different panel types for different media formats.
- **Multi-process activities**: Improves performance by running the media view in a separate process.

## How to Use

1.  Build and run the application on a Meta Quest headset.
2.  Click the "Launch Media Viewer" button to enter the media selection screen.
3.  Select a media item to play it.
4.  Click the "Snap to Wall" button to snap the video panel to a nearby wall.

## Code Overview

-   **`MainActivity.kt`**: The main entry point of the application.
-   **`MediaViewActivity.kt`**: The activity that hosts the media viewing experience.
-   **`MediaPlayer.kt`**: Manages the ExoPlayer instance and handles media playback.
-   **`MediaCatalog.kt`**: Provides a list of media items to play.
-   **`MrukManager.kt`**: Handles MRUK integration for wall detection.
-   **`PanelManager.kt`**: Creates and manages the different types of video panels.
-   **`ShaderManager.kt`**: Loads and manages custom shaders.
-   **`assets/shaders`**: Contains the GLSL code for the custom shaders.
