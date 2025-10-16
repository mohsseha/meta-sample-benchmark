
# Spatial Video Sample

This is a sample application that demonstrates how to play a video with spatialized audio using the Meta Spatial SDK v0.8.0.

## How to Use

1.  **Place your video file**: This project uses a placeholder video file named `sample.mp4`. Please replace the placeholder file in `app/src/main/assets/sample.mp4` with your own video file. The video should have an audio track.
2.  **Build and run**: Build and run the application on a Meta Quest headset.
3.  **Experience spatial audio**: Move your head around to experience the spatial audio effect. The audio will sound like it is coming from the video panel's location in the 3D space.

## Implementation Notes

*   **`MainActivity.kt`**: This is the main entry point of the application. It sets up the VR scene, creates the video panel, and initializes the media player.
*   **Spatial Audio**: The application creates an entity to act as the audio source and positions it at the same location as the video panel. The audio is then attached to the `MediaPlayer`'s audio session ID. This is a conceptual implementation, and the actual API for attaching a `MediaPlayer` to a spatial audio source may differ in the final version of the SDK.
*   **Placeholder Video**: The `sample.mp4` file in the `assets` directory is a placeholder. You should replace it with your own video file.
