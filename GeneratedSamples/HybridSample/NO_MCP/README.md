
# Hybrid Sample App

This sample application demonstrates how to create a hybrid VR application for the Meta Spatial SDK v0.8.0. A hybrid app can switch between a standard Android 2D panel mode and a full immersive VR mode, hosting the same UI panel in both contexts.

## Features

*   **Mode Switching**: Toggle between a 2D panel and an immersive VR experience.
*   **Shared UI**: The same Jetpack Compose UI is used in both modes.
*   **State Preservation**: The application state is preserved across mode transitions.

## How to Run

1.  **Prerequisites**:
    *   Android Studio with the Meta Spatial SDK installed.
    *   A Meta Quest 2, 3, or Pro headset.
2.  **Build and Run**:
    *   Open the project in Android Studio.
    *   Build and run the application on your connected Meta Quest headset.

## Architecture

The application is structured as follows:

*   **`MainActivity.kt`**: The main entry point of the application. It handles the mode switching logic and renders the appropriate UI based on the current mode.
*   **`SharedUI.kt`**: Contains the Jetpack Compose UI that is shared between the 2D panel and the immersive VR mode.
*   **`VrScene.kt`**: Defines the immersive VR scene. It uses the `SpatialApp` composable from the Meta Spatial SDK to render the 3D scene.
*   **`ui/theme`**: Contains the theme, color, and typography for the Jetpack Compose UI.

### Mode Switching Logic

The `MainActivity` maintains a mutable state variable `isImmersiveMode` that tracks the current mode. When the user clicks the "Toggle Mode" button in the `SharedUI`, the `onToggleMode` callback is invoked, which updates the `isImmersiveMode` state. This triggers a recomposition of the `App` composable, which then renders either the `VrScene` or the `SharedUI` based on the new state.

### State Preservation

The application state is preserved across mode transitions because the `isImmersiveMode` state is managed by the `MainActivity`, which is not destroyed when the mode changes. Any other state that needs to be preserved can be managed in a similar way, for example, by using a `ViewModel`.
