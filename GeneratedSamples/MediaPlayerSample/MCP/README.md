# Media Player Sample for Meta Spatial SDK v0.8.0

This sample application demonstrates how to create an immersive video playback experience using the Meta Spatial SDK v0.8.0. Users can select videos from a UI panel and watch them in a 3D environment or in passthrough mode.

## Architecture

The application follows the Android ViewModel pattern to manage the state of the video player and the list of videos.

*   **MainActivity.kt**: The main entry point for the application. It extends `AppSystemActivity` and is responsible for creating the immersive VR experience, registering the video list panel, and handling video playback.
*   **VideoPlayerViewModel.kt**: Manages the state of the video player, including the list of available videos, the currently selected video, and the passthrough mode.
*   **VideoListPanel.kt**: A Jetpack Compose UI component that displays the list of available videos and allows the user to select a video for playback.

## How it Works

1.  **Initialization**: The `MainActivity` initializes the `PanelSystem` and `PassthroughSystem` from the Meta Spatial SDK. It then spawns the `VideoListPanel` and observes the `selectedVideo` and `isPassthroughEnabled` state from the `VideoPlayerViewModel`.
2.  **Video Selection**: When the user selects a video from the `VideoListPanel`, the `VideoPlayerViewModel` updates the `selectedVideo` state.
3.  **Video Playback**: The `MainActivity` observes the `selectedVideo` state and, when it changes, it calls the `playVideo()` function. This function creates an `ExoPlayer` instance, a `PlayerView` to render the video, and a new panel to display the video in the 3D environment.
4.  **Passthrough Mode**: The user can toggle passthrough mode from the `VideoListPanel`. The `MainActivity` observes the `isPassthroughEnabled` state and enables or disables passthrough accordingly. It also hides or shows the skybox to ensure that the passthrough feed is visible.

## How to Run

1.  Make sure you have the Meta Spatial SDK v0.8.0 and the Meta Spatial Editor CLI set up in your development environment.
2.  Open the project in Android Studio.
3.  Build and run the application on a Meta Quest headset.

## Notes

*   This sample application uses hardcoded video URLs for demonstration purposes. In a real-world application, you would likely load the video list from a remote server or a local database.
*   The application assumes that you have a skybox entity in your scene. If you do not, you can remove the line of code that hides the skybox when passthrough is enabled.
*   The Meta Spatial SDK documentation is not very detailed, so some assumptions have been made about the API. For example, it is assumed that there is a `PanelSystem` and a `PassthroughSystem` available.
