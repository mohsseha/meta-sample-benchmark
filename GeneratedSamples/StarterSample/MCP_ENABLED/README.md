# Starter Sample - VR Welcome Panel Application

This is a starter VR application for Meta Spatial SDK v0.8.0 that displays a welcome panel with app information in an immersive 3D environment. This serves as a foundational template for developers getting started with Meta Spatial SDK.

## How to Use

To build and run this sample, you will need:
- Android Studio
- A Meta Quest 2, 3, or Pro headset
- The Meta Spatial SDK and its dependencies set up in your development environment.

Once you have the prerequisites, you can open this project in Android Studio and run it on your connected headset.

## What this sample demonstrates

- **Basic VR Application Structure:** Shows the basic structure of a VR application using the Meta Spatial SDK.
- **Scene Setup:** Demonstrates how to set up a basic 3D scene with lighting and a skybox.
- **UI Panels:** Shows how to create and display a UI panel using Jetpack Compose in a 3D environment.
- **Asset Loading:** Demonstrates how to load assets (in this case, a skybox).

## SDK Features Used

- **`SpatialActivity`:** The main activity for a VR application.
- **`ToolkitFeature`:** The main entry point for the Spatial SDK.
- **`Scene`:** The container for all 3D objects in the application.
- **`PanelSceneObject`:** A scene object that can display a Jetpack Compose UI.
- **`SceneObject.createSkybox`:** A helper function to create a skybox.
- **`scene.setLightingEnvironment`:** A function to set up the lighting in the scene.
