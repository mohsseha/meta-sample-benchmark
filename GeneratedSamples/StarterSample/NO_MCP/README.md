# Starter Sample for Meta Spatial SDK

This starter sample demonstrates how to create a basic VR application using the Meta Spatial SDK. It serves as a foundational template for developers getting started with building immersive 3D experiences for Meta Quest devices.

## What this sample demonstrates

*   **VR Application Setup**: How to set up a basic Android project for VR development with the Meta Spatial SDK.
*   **Scene Management**: How to create and manage a 3D scene, including setting up a skybox and lighting.
*   **Jetpack Compose Integration**: How to use Jetpack Compose to create and display UI panels in a 3D environment.
*   **Asset Loading**: How to load assets, such as textures and scene compositions, into the application.
*   **Gradle Configuration**: How to configure Gradle for a Meta Spatial SDK project.

## How to use this sample

To build and run this sample, you will need:

*   Android Studio
*   A Meta Quest 2, 3, or Pro headset
*   The Meta Spatial SDK and its dependencies set up in your development environment.

Once you have the necessary tools, you can open this project in Android Studio, build it, and deploy it to your Meta Quest headset.

## Project Structure

The project follows a standard Android project structure:

*   `app/src/main/java`: Contains the Kotlin source code for the application.
    *   `MainActivity.kt`: The main entry point of the application.
    *   `scene/SceneManager.kt`: Manages the 3D scene, lighting, and skybox.
    *   `ui/WelcomePanel.kt`: The Jetpack Compose UI for the welcome panel.
    *   `ui/theme`: Contains the Jetpack Compose theme and color palette.
*   `app/src/main/res`: Contains the Android resources, such as layouts, strings, and themes.
*   `app/src/main/assets`: Contains the application's assets, such as the skybox texture, environment file, and scene composition.
*   `gradle`: Contains the Gradle wrapper files.
*   `build.gradle.kts` and `settings.gradle.kts`: The Gradle build scripts for the project.
