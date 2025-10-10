# Media Player Sample - Immersive Video Playback Experience

## Objective
Create an immersive VR application for Meta Spatial SDK v0.8.0 that provides a video playback experience where users can discover and play videos in a custom 3D environment or using Passthrough mode to integrate with their physical environment.

## Clear Outcome Description
When the user launches the application on their Meta Quest headset, they should:
- Enter an immersive VR environment (or Passthrough mixed reality mode)
- See a UI panel listing available videos to play
- Be able to select a video from the list
- Watch the selected video playing in the immersive 3D space
- Toggle between VR environment and Passthrough mode
- Experience seamless communication between the video list panel and the video playback

## Technical Constraints
- **Target SDK version**: Meta Spatial SDK v0.8.0
- **Target platform**: Meta Quest 2/3/Pro
- **Language/framework**: Kotlin, Android
- **Build system**: Gradle with Meta Spatial SDK Gradle Plugin
- **UI framework**: Jetpack Compose for panels
- **Architecture**: Android ViewModel pattern for communication between components

## High-Level Components (Conceptual Only)
The application should include:
- A main activity managing the immersive VR experience
- A video list panel displaying available videos (Jetpack Compose)
- A video playback surface or panel for rendering video
- Passthrough toggle capability for mixed reality mode
- View model or data layer for communication between list and playback components
- Environment management (custom 3D scene or Passthrough)
- Video player integration

## Visual/UX Requirements

### Video List Panel
- Display a list or grid of available videos
- Show video titles/descriptions
- Allow user selection of videos
- Clear, readable UI following SDK guidelines
- Responsive interaction feedback

### Video Playback
- Large, clear video display surface in the 3D environment
- Positioned at comfortable viewing distance
- Playback controls (play, pause, seek - optional)
- Video should render smoothly

### Environment Modes
- **Custom Environment**: 3D scene with lighting and skybox for video viewing
- **Passthrough Mode**: Ability to toggle to see physical environment with video overlay
- Clear UI control to switch between modes

### Placeholder Assets
Create simple placeholder files:
- Dummy video files (or references to video URIs) - small test videos
- Thumbnail images for video list (PNG format)
- UI icons for controls (PNG format)
Don't worry about obtaining actual production video content.

## Scene/Environment Requirements

### Custom Environment Mode
- **Lighting**: Scene lighting appropriate for video viewing (not too bright)
- **Background**: Skybox or environment backdrop
- **Panel placement**: List and video surfaces positioned for comfortable viewing
- **Spatial audio**: Consider audio positioning (optional)

### Passthrough Mode
- Ability to enable visualization of the physical world
- Video and UI panels remain visible over Passthrough
- Smooth transition between environment modes

## Functional Requirements

### Video Management
- System to manage a catalog of available videos
- Support for loading videos from resources or network (demo purposes)
- Video metadata (title, description, duration, etc.)

### Playback System
- Initialize and control video playback
- Handle video player lifecycle
- Render video to a surface in the 3D environment

### Panel Communication
- Implement communication pattern between video list panel and playback system
- Use View Model or similar architecture for data sharing
- Selection in list panel triggers playback

### Passthrough Integration
- Enable/disable Passthrough mode
- Maintain UI and video visibility during mode switch
- Provide user control for toggling Passthrough

### Environment Editing (Optional)
- Scene may be editable with Meta Spatial Editor
- Document which aspects can be customized

## Reference Documentation
Full documentation is available here: `/home/husainal-mohssen/src/Meta-spatial-sdk-docs` (Meta Spatial SDK v0.8.0)

You are encouraged to search this documentation to discover:
- How to create and manage 2D panels in immersive environments
- Video rendering approaches (panels, surfaces)
- Passthrough API and implementation
- Android ViewModel integration with Spatial SDK
- Panel communication patterns
- Best practices for media playback in VR

The agent may also search online for Android MediaPlayer/ExoPlayer, Jetpack Compose, ViewModel, and general video playback documentation as needed.

## Project Structure Requirements
- Standard Android project structure
- ViewModel or data layer classes for state management
- Panel definitions (Compose files) for UI
- Activity managing the immersive experience
- Video player integration code
- Resource organization for videos and assets
- Gradle configuration for Meta Spatial SDK and video libraries

## Nice to Have (Optional)
These enhancements will make the sample app easier to understand for Meta developers:
- **README.md file**: Explaining the media playback architecture
- **Code comments**: Clear explanations of panel communication and video integration
- **ViewModel documentation**: Explain the data flow pattern
- **Passthrough notes**: Comments on when and how to use Passthrough mode
- **Performance considerations**: Notes on video format and optimization for VR
- **Environment customization**: Documentation of scene editing capabilities
- **User experience notes**: Comments on comfortable viewing distances and panel sizing

## Success Criteria
Your generated code will be evaluated on:
- **Completeness**: All necessary files for a functional video playback app
- **API Usage**: Proper use of Meta Spatial SDK v0.8.0 panel and Passthrough APIs
- **Architecture**: Clean ViewModel-based communication pattern
- **Code Quality**: Well-organized code following Android best practices
- **SDK Patterns**: Matches patterns from SDK documentation
- **Documentation**: Clear explanations of media integration approach
- **Replaceability**: Code quality suitable for inclusion in the official Meta-Spatial-SDK-Samples repository

## ⚠️ IMPORTANT: Code Generation Only

**Generate complete source code only.**

**DO NOT attempt to:**
- Install the Meta Spatial SDK
- Build, compile, or run the code
- Install Android Studio or development tools
- Set up the Meta Spatial Editor CLI
- Download actual video files or production media content
- Install proprietary Meta tools

**Why**: The Meta Spatial SDK requires proprietary tooling (Spatial Editor CLI) that cannot be installed in standard development environments. These limitations have been consistently observed in agent running environments.

Your task is to generate well-structured, complete, and properly documented source code that demonstrates video playback in VR, and could be compiled and run by a developer who has the proper Meta Quest development environment set up locally.
