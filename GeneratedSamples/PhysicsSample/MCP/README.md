# Physics Sample

This project is a sample application for the Meta Spatial SDK v0.8.0 that demonstrates how to add physics components to 3D objects and adjust their properties through the Meta Spatial Editor, showcasing realistic physics interactions including collision, gravity, and object dynamics.

## Project Structure

- `app/src/main/java/com/meta/physicssample/MainActivity.kt`: The main entry point of the application. It extends `AppSystemActivity` and registers the custom systems.
- `app/src/main/java/com/meta/physicssample/systems`: This package contains the custom systems for the different interaction types.
  - `ButtonSystem.kt`: Handles the logic for the button interaction.
  - `SpinnerSystem.kt`: Handles the logic for the spinner interaction.
  - `TriggerSystem.kt`: Handles the logic for the trigger interaction.
- `app/src/main/res/layout/activity_main.xml`: The layout file for the main activity.
- `app/src/main/assets/scenes`: This folder contains the scene files.
  - `main.glxf`: The main scene file. It defines the scene and the objects in it.
  - `models`: This folder contains the 3D models.
    - `button.gltf`: A simple cube model for the button.
    - `spinner.gltf`: A simple cube model for the spinner.
    - `trigger.gltf`: A simple cube model for the trigger.
    - `free_object.gltf`: A simple cube model for the free object.
- `build.gradle`: The build file for the application.
- `settings.gradle`: The settings file for the application.

## How to Build and Run

1.  Install the Meta Spatial SDK v0.8.0.
2.  Open the project in Android Studio.
3.  Build and run the application on a Meta Quest headset.

## How to Adjust Physics Properties

1.  Open the `main.glxf` file in the Meta Spatial Editor.
2.  Select an object in the scene.
3.  Adjust the physics properties in the Inspector panel.
4.  Save the scene.
5.  Rebuild and run the application.
