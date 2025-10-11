# Spatial Video Sample

This sample application demonstrates how to play a video with spatialized audio using the Meta Spatial SDK v0.8.0. The audio is positioned in 3D space, making it sound as if it's coming from the video panel.

## Overview

The application sets up a simple VR scene with a skybox and a video panel. The video is played using Android's `MediaPlayer`, and the audio is spatialized using the Meta Spatial SDK's `SpatialAudio` system.

## Key Concepts

### Spatial Audio

Spatial audio creates the illusion of sound coming from a specific location in 3D space. This is achieved by using Head-Related Transfer Functions (HRTF) to modify the audio signal based on the listener's head position and orientation relative to the sound source.

In this sample, the audio source is attached to the video panel's transform. The `SpatialAudio` system automatically handles the processing required to make the audio sound like it's emanating from the panel.

### How it Works

1.  **Scene Setup**: A `SpatialActivity` is created, and a 3D scene is set up with a skybox and a `Panel` entity for the video.
2.  **MediaPlayer Initialization**: An Android `MediaPlayer` is initialized to play the video file (`sample.mp4`).
3.  **SpatialAudioSource Creation**: A `SpatialAudioSource` is created from the `SpatialAudio` system.
4.  **Attaching MediaPlayer**: The `MediaPlayer` is attached to the `SpatialAudioSource`.
5.  **Attaching to Transform**: The `SpatialAudioSource` is attached to the `Transform` of the video panel. This links the audio's position to the panel's position in the 3D world.

## How to Experience the Spatial Audio Effect

When you run this application on a Meta Quest headset, you can experience the spatial audio by moving your head:

*   **Facing the panel**: The audio will be loudest and centered.
*   **Turning your head away**: The audio will become quieter and shift to the ear that is closer to the panel.
*   **Moving closer or further away**: The audio volume will change based on the distance from the panel (this feature is part of the SDK's spatial audio system).

## Project Structure

*   `VideoPlayerActivity.kt`: The main activity that sets up the scene, initializes the media player, and configures spatial audio.
*   `app/src/main/assets/`: Contains the `sample.mp4` video file and `skybox.png` texture.
*   `app/src/main/res/`: Contains the layout, values, and other resources for the Android application.
*   `build.gradle`: The Gradle build scripts, which include the Meta Spatial SDK dependency.

This sample provides a basic template for developers looking to integrate spatialized video audio into their Meta Spatial SDK applications.