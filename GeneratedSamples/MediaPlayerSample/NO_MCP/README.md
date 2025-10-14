# Media Player Sample

This sample application demonstrates how to build an immersive video playback experience using the Meta Spatial SDK. Users can browse a list of videos and play them in a 3D environment. The sample also showcases how to toggle Passthrough mode to blend the virtual and physical worlds.

## Architecture

The application follows a standard Android architecture, utilizing a ViewModel to manage and share state between different UI components.

- **MainActivity.kt**: The main entry point of the application. It's a `SpatialActivity` that sets up the scene, including the video list and video player panels.
- **VideoViewModel.kt**: A ViewModel that holds the list of videos, the currently selected video, and the state of the Passthrough mode. It exposes these as `StateFlow`s to be observed by the UI.
- **VideoListPanel.kt**: A Jetpack Compose UI that displays the list of available videos. When a user selects a video, it notifies the `VideoViewModel`.
- **VideoPlayerPanel.kt**: A Jetpack Compose UI that hosts an ExoPlayer instance to play the selected video. It observes the `selectedVideo` StateFlow from the `VideoViewModel` and updates the player accordingly.
- **data/VideoItem.kt**: A data class representing a single video item.

## Panel Communication

The communication between the `VideoListPanel` and the `VideoPlayerPanel` is handled by the `VideoViewModel`.

1.  The `VideoListPanel` displays a list of `VideoItem`s fetched from the `VideoViewModel`.
2.  When a user clicks on a video in the list, the `onVideoSelected` function in the `VideoViewModel` is called.
3.  The `VideoViewModel` updates the `selectedVideo` `StateFlow`.
4.  The `VideoPlayerPanel` observes the `selectedVideo` `StateFlow` and, when it changes, it initializes the ExoPlayer with the new video URL and starts playback.

This architecture decouples the UI components and makes the code more modular and easier to maintain.

## Passthrough Mode

The `MainActivity` also demonstrates how to toggle Passthrough mode. The `VideoViewModel` holds the state of the Passthrough mode in the `isPassthroughEnabled` `StateFlow`. The `Scene` in the `MainActivity` observes this state and adds or removes the `Passthrough` content accordingly.

A UI control to toggle this state can be added to one of the panels to allow the user to switch between the virtual and mixed reality environments.

## How to Build and Run

1.  Make sure you have the Meta Spatial SDK and the Spatial Editor CLI set up correctly.
2.  Open the project in Android Studio.
3.  Build and run the application on a Meta Quest device.

## Performance Considerations

- **Video Format**: For optimal performance, use video formats that are well-supported by the hardware decoders on the Meta Quest devices, such as H.264 or H.265.
- **Video Resolution and Bitrate**: Be mindful of the video resolution and bitrate. High-resolution videos with high bitrates can consume a lot of resources and may lead to performance issues.
- **Optimization**: For a production application, consider implementing more advanced features like video streaming with adaptive bitrate, caching, and pre-loading to improve the user experience.
