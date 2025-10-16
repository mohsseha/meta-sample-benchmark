
# Media Player Sample for Meta Spatial SDK

This sample application demonstrates how to build an immersive video playback experience using the Meta Spatial SDK v0.8.0. Users can select and play videos from a UI panel within a custom 3D environment or in Passthrough mode.

## Architecture

The application follows a modern Android architecture, utilizing:

-   **Kotlin**: The primary programming language.
-   **Jetpack Compose**: For building the UI panels.
-   **ViewModel**: To manage and share data between the UI panels and the main activity.
-   **ExoPlayer**: For handling video playback.
-   **Meta Spatial SDK**: For creating the immersive VR experience, managing panels, and handling Passthrough.

### Components

-   **MainActivity.kt**: The main entry point of the application. It initializes the Meta Spatial SDK, sets up the scene, and creates the UI panels.
-   **VideoViewModel.kt**: A ViewModel that holds the list of videos, the currently selected video, and the Passthrough state. It acts as a single source of truth for the application's data.
-   **VideoListPanel.kt**: A Jetpack Compose UI that displays a list of available videos and a toggle for Passthrough mode. When a user selects a video or toggles Passthrough, it updates the `VideoViewModel`.
-   **VideoPlayer.kt**: A Jetpack Compose UI that displays the video playback. It observes the `selectedVideo` from the `VideoViewModel` and plays the corresponding video using ExoPlayer.
-   **VideoItem.kt**: A data class representing a video in the playlist.

### Data Flow

1.  `MainActivity` creates the `VideoViewModel`.
2.  `MainActivity` creates the `VideoListPanel` and `VideoPlayer` panels, providing them with the `VideoViewModel`.
3.  `VideoListPanel` displays the list of videos from the `VideoViewModel`.
4.  When a user selects a video in the `VideoListPanel`, it calls a method in the `VideoViewModel` to update the `selectedVideo` state.
5.  `VideoPlayer` observes the `selectedVideo` state in the `VideoViewModel`. When the state changes, it starts playing the new video.
6.  When the user toggles the Passthrough checkbox in the `VideoListPanel`, it updates the `isPassthroughEnabled` state in the `VideoViewModel`.
7.  `MainActivity` observes the `isPassthroughEnabled` state and enables or disables Passthrough accordingly.

## How to Use

1.  **Set up your environment**: Make sure you have the Meta Quest development environment set up, including the Meta Spatial SDK and the Spatial Editor CLI.
2.  **Build and run**: Build and run the application on your Meta Quest headset.
3.  **Interact**:
    -   Look at the video list panel to see the available videos.
    -   Select a video to start playback.
    -   Use the checkbox to toggle between the custom 3D environment and Passthrough mode.

## Customization

-   **Video Playlist**: You can customize the video playlist by modifying the `_videoItems` list in `VideoViewModel.kt`. You can add your own videos by providing URLs to video and thumbnail files.
-   **Environment**: The 3D environment can be customized using the Meta Spatial Editor. You can change the lighting, background, and panel placement to create your own unique experience.
-   **UI**: The UI panels are built with Jetpack Compose, so you can easily customize their appearance and layout by modifying the Composable functions in `VideoListPanel.kt` and `VideoPlayer.kt`.
