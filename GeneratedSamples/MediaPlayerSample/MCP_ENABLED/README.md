# Media Player Sample

This sample demonstrates how to create an immersive video playback experience using the Meta Spatial SDK.

## Architecture

The sample follows the MVVM (Model-View-ViewModel) architecture pattern.

- **MainActivity.kt**: The main entry point of the application. It sets up the immersive experience.
- **VideoViewModel.kt**: The ViewModel is responsible for managing the state of the video player, including the list of videos, the currently selected video, and the passthrough mode.
- **MainScene.kt**: The main scene of the application. It contains the video list, the video player, and the passthrough toggle.
- **VideoList.kt**: A composable that displays the list of videos.
- **VideoPlayer.kt**: A composable that plays the selected video using ExoPlayer.

## How to Run

1.  Open the project in Android Studio.
2.  Connect your Meta Quest device.
3.  Build and run the application.

## Passthrough Mode

The sample includes a toggle to switch between the immersive environment and passthrough mode. This is handled by the `isPassthroughEnabled` state in the `VideoViewModel`. When the state is updated, the `MainScene` recomposes and updates the passthrough mode of the `Scene`.
