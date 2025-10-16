
# Spatial Video Sample

This project is a sample application for the Meta Spatial SDK v0.8.0 that demonstrates how to play a video with spatialized audio.

## Features

*   **Video Playback:** Plays a video on a spatial panel in a 3D environment.
*   **Spatial Audio:** The audio from the video is spatialized, meaning it appears to come from the location of the video panel.
*   **Immersive VR:** The application is a fully immersive VR experience.

## How to Use

1.  **Open in Android Studio:** Open the project in Android Studio.
2.  **Connect Meta Quest:** Connect your Meta Quest headset to your computer.
3.  **Build and Run:** Build and run the application on your headset.

## Code Overview

*   **`MainActivity.kt`:** The main entry point of the application. It initializes the `SceneManager`.
*   **`SceneManager.kt`:** This class is responsible for setting up the 3D scene, creating the video panel, and managing the video and audio playback.
*   **`video_panel_layout.xml`:** The layout file for the `SurfaceView` that displays the video.
*   **`sample_video.mp4`:** A placeholder video file. You can replace this with your own video.

## Spatial Audio Concepts

This sample uses the `SpatialAudioSystem` and `SpatialSound` components from the Meta Spatial SDK to create the spatial audio effect. The `SpatialSound` component is attached to the video panel entity, and the `isSpatialized` property is set to `true`. This tells the SDK to process the audio from the video and make it sound like it's coming from the panel's position in 3D space.

As you move your head and change your position relative to the video panel, you should hear the audio change accordingly. The audio will be loudest when you are facing the panel and will become quieter and change direction as you turn away from it.
