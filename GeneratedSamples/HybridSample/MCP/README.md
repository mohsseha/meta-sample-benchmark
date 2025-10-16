# Hybrid Sample

This sample demonstrates how to create a hybrid application with the Meta Spatial SDK that can switch between a 2D panel and an immersive VR mode.

## How it Works

The application uses a single `MainActivity` that can be launched in either panel or immersive mode. The `MainViewModel` holds the current mode state.

When the application is launched, the `MainActivity` checks the current mode from the `MainViewModel` and starts the appropriate UI.

The UI is built with Jetpack Compose and is shared between both modes. The `HybridSampleApp` composable takes the current mode as a parameter and displays the appropriate UI.

The "Switch Mode" button in the UI toggles the mode in the `MainViewModel` and then restarts the `MainActivity` to switch to the new mode.

## How to Run

1.  Open the project in Android Studio.
2.  Connect your Meta Quest device.
3.  Build and run the application.

## Placeholder for Immersive Mode

The immersive mode in this sample is a placeholder. In a real application, you would render the UI to a texture and display it on a quad in the 3D scene. The Meta Spatial SDK documentation does not currently provide information on how to do this, so this sample uses the same UI for both modes.
