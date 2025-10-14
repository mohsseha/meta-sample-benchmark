# Media Player Sample for Meta Spatial SDK v0.8.0

This sample application demonstrates how to build an immersive video playback experience using the Meta Spatial SDK v0.8.0. Users can browse a list of videos and watch them in a 3D environment or in Passthrough mode.

## Project Structure

The project follows a standard Android application structure:

-   `app/src/main/java/com/meta/mediaplayersample`: Contains the Kotlin source code for the application.
    -   `MediaPlayerActivity.kt`: The main activity that manages the immersive VR experience.
    -   `VideoViewModel.kt`: The ViewModel that manages the video data and state.
    -   `VideoListPanel.kt`: A Jetpack Compose UI that displays the list of videos.
-   `app/src/main/res`: Contains the application resources.
    -   `layout/video_playback.xml`: The layout for the video playback panel, which contains a `WebView`.
    -   `values/strings.xml`: String resources.
    -   `values/themes.xml`: Application theme.
-   `app/build.gradle`: The Gradle build file for the application module.
-   `README.md`: This file.

## Architecture

The application uses the Model-View-ViewModel (MVVM) architecture pattern to separate the UI from the business logic.

-   **View**: The `MediaPlayerActivity` and the `VideoListPanel` are the views. They are responsible for displaying the UI and handling user input.
-   **ViewModel**: The `VideoViewModel` is the ViewModel. It holds the video data and the application state. It exposes the data to the view through `StateFlow`.
-   **Model**: The `Video` data class is the model.

Communication between the `VideoListPanel` and the `MediaPlayerActivity` is handled by the `VideoViewModel`. When a user selects a video in the `VideoListPanel`, the ViewModel is updated, and the `MediaPlayerActivity` observes the change and starts playing the selected video.

## Passthrough Mode

The application supports toggling between a custom 3D environment and Passthrough mode. The `MediaPlayerActivity` manages the Passthrough state and updates the scene accordingly. When Passthrough is enabled, the skybox is hidden to allow the user to see their physical environment.

## How to Run the App

To run this application, you will need:

1.  A Meta Quest 2, 3, or Pro headset.
2.  Android Studio.
3.  The Meta Spatial Editor.

Once you have set up your development environment, you can open the project in Android Studio and run it on your connected Meta Quest headset.
