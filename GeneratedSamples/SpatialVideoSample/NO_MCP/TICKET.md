# Spatial Video Sample - Spatialized Audio Video Playback App

## Objective
Create an immersive VR application for Meta Spatial SDK v0.8.0 that demonstrates video playback with spatialized audio, where the audio appears to come from the video panel's location in 3D space, creating a realistic spatial audio experience.

## Clear Outcome Description
When the user launches the application on their Meta Quest headset, they should:
- Enter an immersive 3D VR environment
- See a video playing on a panel in 3D space
- Experience audio that emanates from the video panel's spatial position
- Hear the audio change realistically as they move their head relative to the video panel
- Understand spatial audio positioning (louder when facing panel, quieter when turned away)
- Experience proper stereo spatialization based on panel location

## Technical Constraints
- **Target SDK version**: Meta Spatial SDK v0.8.0
- **Target platform**: Meta Quest 2/3/Pro
- **Language/framework**: Kotlin, Android
- **Build system**: Gradle with Meta Spatial SDK Gradle Plugin
- **Media framework**: Android media player with spatial audio support

## High-Level Components (Conceptual Only)
The application should include:
- A main activity managing the immersive VR experience
- Video playback system
- Spatial audio configuration and management
- Video panel positioned in 3D space
- Audio source attached to panel spatial position
- Scene environment setup

## Visual/UX Requirements

### Video Panel
- Clear video playback surface positioned in 3D space
- Appropriate size for comfortable viewing
- Positioned at a location that demonstrates spatial audio effectively
- May include playback controls (play, pause, volume)

### Environment
- 3D VR environment with appropriate lighting
- Skybox or background providing spatial context
- Layout that allows user to move and experience audio spatialization
- Comfortable viewing distance and positioning

### Audio Feedback
- Clear audio playback from video
- Noticeable spatial audio effects as user moves head
- Volume and stereo positioning changes based on head orientation
- Realistic sound attenuation with distance (optional)

### Placeholder Assets
Create simple placeholder files:
- Sample video file with audio track - small test video
- UI graphics if needed (PNG format)
Focus on spatial audio mechanics, not production-quality video content.

## Scene/Environment Requirements
- **3D scene setup**: Environment showcasing spatial audio
- **Panel positioning**: Video panel placed to demonstrate spatial effects
- **Lighting**: Appropriate scene lighting
- **Spatial layout**: Room for user to experience audio from different positions/orientations
- **VR environment**: Immersive space for audio testing

## Functional Requirements

### Video Playback
- Load and play video file with audio track
- Render video to a panel in 3D space
- Control playback (play, pause, seek - optional)
- Handle video player lifecycle

### Spatial Audio System
- Configure audio spatialization for the video
- Attach audio source to video panel's 3D position
- Update audio based on user's head position and orientation
- Implement spatial audio rendering (HRTF, attenuation, etc.)

### Audio Positioning
- Position audio source at panel location in 3D space
- Calculate spatial audio parameters based on relative position
- Handle head tracking for audio updates
- Provide realistic stereo positioning

### Panel Management
- Create video panel in 3D space
- Position panel appropriately for demonstration
- Integrate video rendering with spatial audio
- Manage panel in scene hierarchy

### Scene Setup
- Initialize VR environment
- Configure scene lighting and background
- Set up spatial reference frame
- Position elements for effective spatial audio demonstration

## Project Structure Requirements
- Standard Android project structure
- Video playback code with spatial audio integration
- Audio spatialization configuration
- Panel management code
- Activity managing VR scene and audio
- Resource organization for video files
- Gradle configuration for Meta Spatial SDK

## Nice to Have (Optional)
These enhancements will make the sample app easier to understand for Meta developers:
- **README.md file**: Explaining spatial audio concepts and implementation
- **Code comments**: Clear explanations of spatialization setup
- **Spatial audio guide**: Document how spatial audio positioning works
- **Parameter documentation**: Explain audio spatialization settings
- **User experience notes**: How to experience the spatial audio effect
- **Head tracking**: Explain integration with head position/orientation
- **Best practices**: Tips for effective spatial audio in VR
- **Audio concepts**: Brief explanation of HRTF and spatial audio principles

## Success Criteria
Your generated code will be evaluated on:
- **Completeness**: All necessary files for functional spatialized video playback
- **API Usage**: Proper use of Meta Spatial SDK v0.8.0 spatial audio APIs
- **Spatial audio quality**: Correctly implemented audio spatialization
- **Code Quality**: Clean, well-organized audio and video integration
- **SDK Patterns**: Matches spatial audio patterns from SDK documentation
- **Documentation**: Clear explanations of spatial audio concepts
- **Replaceability**: Code quality suitable for inclusion in the official Meta-Spatial-SDK-Samples repository

## ⚠️ IMPORTANT: Code Generation Only

**Generate complete source code only.**

**DO NOT attempt to:**
- Install the Meta Spatial SDK
- Build, compile, or run the code
- Install Android Studio or development tools
- Set up the Meta Spatial Editor CLI
- Download actual video files or media content
- Install proprietary Meta tools
- Test spatial audio on actual Quest hardware

**Why**: The Meta Spatial SDK requires proprietary tooling (Spatial Editor CLI) that cannot be installed in standard development environments. Spatial audio requires Quest hardware to experience properly. These limitations have been consistently observed in agent running environments.

Your task is to generate well-structured, complete, and properly documented source code that demonstrates spatial audio integration with video playback, and could be compiled and run by a developer who has the proper Meta Quest development environment set up locally.
