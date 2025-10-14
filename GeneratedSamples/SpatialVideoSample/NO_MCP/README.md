# Spatial Video Sample

This application is a demonstration of video playback with spatialized audio using the Meta Spatial SDK. It is designed to showcase how to create an immersive VR experience where the audio from a video appears to originate from its position in 3D space.

## How it Works

The application uses the Meta Spatial SDK to create a 3D scene with a video player. The video is rendered onto a `VideoPlayerView`, which is a `SpatialView` that can be placed in the 3D scene.

The audio from the video is spatialized using the `MediaPlayer`'s `isSpatialized` property. When this property is set to `true`, the audio will be rendered as if it is coming from the position of the `VideoPlayerView` in the 3D scene.

## How to Experience the Spatial Audio Effect

To experience the spatial audio effect, you will need to run this application on a Meta Quest headset. Once the application is running, you will see a video playing on a panel in front of you.

To notice the spatial audio effect, try the following:

*   **Turn your head:** As you turn your head, you should hear the audio from the video change as if it is coming from the direction of the video panel.
*   **Move around:** If you move around in your physical space, you should hear the audio from the video get louder or quieter as you move closer to or further away from the video panel.

## Code Overview

*   `MainActivity.kt`: This is the main activity of the application. It sets up the 3D scene, the video player, and the spatial audio.
*   `app/src/main/res/raw/sample.mp4`: This is a placeholder for the video file that is played in the application.
*   `app/src/main/assets/sample.mp4`: This is a placeholder for the video file that is played in the application.
*   `build.gradle.kts`: This file contains the dependencies for the project, including the Meta Spatial SDK.

## Spatial Audio Concepts

*   **HRTF (Head-Related Transfer Function):** This is a function that describes how a sound is filtered by the shape of the head and ears. The Meta Spatial SDK uses HRTF to create a realistic spatial audio experience.
*   **Attenuation:** This is the decrease in the intensity of a sound as it travels through a medium. The Meta Spatial SDK uses attenuation to make sounds appear to get quieter as you move further away from them.
*   **Stereo Positioning:** This is the placement of a sound in the left and right channels of a stereo audio signal. The Meta Spatial SDK uses stereo positioning to make sounds appear to come from a specific direction.
