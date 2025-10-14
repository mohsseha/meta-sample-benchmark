# Hybrid Sample - Panel and Immersive Mode Switching App

## Objective
Create a VR application for Meta Spatial SDK v0.8.0 that demonstrates how to build a "hybrid" experience that can switch between a standard Android 2D panel mode and a full immersive VR mode, hosting the same UI panel in both contexts.

## Clear Outcome Description
When the user launches the application on their Meta Quest headset, they should:
- Initially see the app as a standard 2D panel (non-immersive mode)
- Be able to switch to an immersive 3D VR environment
- See the same UI panel content in both modes
- Be able to toggle back and forth between panel mode and immersive mode
- Experience seamless transition between the two modes without losing application state

## Technical Constraints
- **Target SDK version**: Meta Spatial SDK v0.8.0
- **Target platform**: Meta Quest 2/3/Pro
- **Language/framework**: Kotlin, Android
- **Build system**: Gradle with Meta Spatial SDK Gradle Plugin
- **UI framework**: Jetpack Compose for panel content

## High-Level Components (Conceptual Only)
The application should include:
- An activity that can run in both panel (2D) and immersive (3D VR) modes
- Mode switching mechanism allowing users to toggle between panel and immersive experiences
- Shared UI components that work in both contexts
- State management to preserve data across mode transitions
- VR environment setup for the immersive mode
- 2D panel configuration for the panel mode

## Visual/UX Requirements

### UI Panel Content
The panel should display:
- App title or header
- Interactive controls (buttons, toggles, etc.)
- A clear button or control to switch between panel and immersive modes
- Content that remains consistent across both modes
- Proper theming following Meta Spatial SDK UI guidelines

### Panel Mode Experience
- Functions as a traditional Android 2D window in the Meta Quest environment
- User can position and resize like other Quest panel apps
- UI should be clear and readable in 2D context

### Immersive Mode Experience
- Full VR environment with the UI panel floating in 3D space
- Panel positioned at a comfortable viewing distance in VR
- Environment lighting and skybox for immersion
- Panel integrated naturally into the 3D scene

### Placeholder Assets
Create simple placeholder files as needed:
- Any icons or graphics for the UI (PNG format)
- Don't worry about production-quality images

## Scene/Environment Requirements (Immersive Mode)
When in immersive mode, the 3D environment should include:
- **Lighting**: Appropriate scene lighting
- **Background**: Skybox or environment backdrop
- **Panel placement**: UI panel positioned in 3D space for comfortable viewing
- **VR features**: Proper stereoscopic rendering for the Quest headset

## Functional Requirements

### Mode Switching
- User can initiate switch from panel mode to immersive mode
- User can switch back from immersive mode to panel mode
- Transitions should be smooth and predictable
- Application state persists across mode changes

### Panel Management
- Same UI content renders correctly in both contexts
- Panel size and layout appropriate for each mode
- UI interactions work in both panel and immersive modes

### State Preservation
- User inputs and application state maintained during mode switches
- No data loss when transitioning between modes

## Project Structure Requirements
- Standard Android project structure
- Activity classes that can handle both modes
- Shared UI components (Compose composables)
- Proper state management classes or view models
- Gradle configuration for Meta Spatial SDK

## Nice to Have (Optional)
These enhancements will make the sample app easier to understand for Meta developers:
- **README.md file**: Explaining the hybrid approach and when to use it
- **Code comments**: Clear explanations of mode switching logic
- **Architecture documentation**: Comments explaining how state is preserved
- **UI patterns**: Documentation of composable reuse across modes
- **Transition handling**: Explanation of lifecycle management during mode switches
- **Best practices**: Comments on when hybrid apps are appropriate vs. immersive-only apps

## Success Criteria
Your generated code will be evaluated on:
- **Completeness**: All necessary files for a functional hybrid app
- **API Usage**: Proper use of Meta Spatial SDK v0.8.0 panel and immersive APIs
- **Mode switching**: Successful implementation of mode transitions
- **Code Quality**: Clean architecture allowing UI reuse across modes
- **SDK Patterns**: Follows patterns shown in SDK documentation
- **Documentation**: Clear explanations of the hybrid approach
- **Replaceability**: Code quality suitable for inclusion in the official Meta-Spatial-SDK-Samples repository

## ⚠️ IMPORTANT: Code Generation Only

**Generate complete source code only.**

**DO NOT attempt to:**
- Install the Meta Spatial SDK
- Build, compile, or run the code
- Install Android Studio or development tools
- Set up the Meta Spatial Editor CLI
- Install proprietary Meta tools

**Why**: The Meta Spatial SDK requires proprietary tooling (Spatial Editor CLI) that cannot be installed in standard development environments. These limitations have been consistently observed in agent running environments.

Your task is to generate well-structured, complete, and properly documented source code that demonstrates the hybrid app pattern and could be compiled and run by a developer who has the proper Meta Quest development environment set up locally.
