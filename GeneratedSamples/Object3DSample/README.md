# 3D Object Sample

This application is an immersive VR experience for the Meta Spatial SDK that allows users to select from a set of 3D objects and insert them into a custom scene environment.

## How to Use

1.  Build and run the application on a Meta Quest headset.
2.  A panel will appear with a list of objects.
3.  Click on an object to place it in the scene.

## Project Structure

*   `app/src/main/java`: Contains the main application code.
    *   `MainActivity.kt`: The main immersive activity.
    *   `data/ObjectCatalog.kt`: A catalog of the available 3D objects.
    *   `ui/ObjectSelectionPanel.kt`: The Jetpack Compose UI for selecting objects.
*   `app/src/main/scenes`: Contains the scene files.
    *   `main.metaspatial`: The main project file for the Meta Spatial Editor.
    *   `Composition/main.metaspatialcomp`: The main scene composition file.
    *   `models`: Contains the 3D models in glTF format.

## Meta Spatial Editor Integration

The scene is designed to be compatible with the Meta Spatial Editor. You can open the `main.metaspatial` file in the editor to modify the scene. The application loads the scene from the exported `.glxf` file.
