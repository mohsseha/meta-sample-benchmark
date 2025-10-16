# Animations Sample - VR Animation Demonstration App

## Objective
Create an immersive VR application for Meta Spatial SDK v0.8.0 that demonstrates multiple animation techniques including playing animation clips from 3D models, creating reusable animation drivers, and implementing frame-based procedural animations.

## Clear Outcome Description
When the user launches the application on their Meta Quest headset, they should:
- Enter an immersive 3D environment with animated objects
- See 3D models (such as drones or other objects) performing animations loaded from their model files
- Observe UI elements (like buttons) that respond with smooth animations when interacted with
- Experience multiple animation techniques working together in a single scene
- Witness both pre-authored animations (from 3D model files) and programmatically-driven animations

## Technical Constraints
- **Target SDK version**: Meta Spatial SDK v0.8.0
- **Target platform**: Meta Quest 2/3/Pro
- **Language/framework**: Kotlin, Android
- **Build system**: Gradle with Meta Spatial SDK Gradle Plugin
- **3D assets**: Use glTF format for 3D models with embedded animation data

## High-Level Components (Conceptual Only)
The application should include:
- A main activity managing the VR experience
- Animation playback system for 3D model animations
- Controller logic for managing animated objects in the scene
- UI components with animation responses
- Scene management for 3D objects with animation capabilities
- Integration with Android's animation frameworks where appropriate

## Visual/UX Requirements

### 3D Animated Objects
- Display 3D models that demonstrate animation (e.g., flying drones, moving objects)
- Animations should loop smoothly and appear natural
- Objects should be positioned clearly in the 3D space for easy viewing

### UI Panel (Optional)
- May include control panels or informational UI built with Jetpack Compose
- UI elements should respond to user interaction with animations
- Follow Meta Spatial SDK UI theming guidelines

### Placeholder Assets
Create simple placeholder files:
- Dummy 3D model files (glTF format) - don't worry about finding actual complex animated models
- Any UI graphics needed (PNG format)
The focus is on the code structure and animation system, not production-quality assets.

## Scene/Environment Requirements
The 3D environment should include:
- **Lighting**: Appropriate lighting to showcase the animated 3D objects
- **Background**: Skybox or environment that provides visual context
- **Spatial layout**: Animated objects positioned at comfortable viewing distances
- **Scene organization**: Clear separation between different animated elements

## Functional Requirements

### Animation Features to Demonstrate
1. **glTF Animation Playback**:
   - Load 3D models that contain animation data in keyframe format
   - Play animations from these models
   - Handle animation looping and timing

2. **Reusable Animation Drivers**:
   - Create animation systems that can be reused across different objects
   - Demonstrate how to build flexible animation controllers

3. **Procedural Frame-Based Animation**:
   - Implement animations that are calculated per-frame programmatically
   - Show how to use standard Android animation tools in the VR context
   - Demonstrate smooth interpolation and timing

4. **Multiple Animation Types**:
   - Combine different animation techniques in one application
   - Show various use cases (object movement, UI responses, etc.)

### Core Functionality
- Load and parse glTF files with animation data
- Initialize and play multiple animations simultaneously
- Handle animation state and lifecycle
- Integrate UI animations with the 3D scene
- Manage frame updates efficiently for smooth performance

## Project Structure Requirements
- Standard Android project structure with proper package organization
- Separate controllers or systems for managing different animated objects
- Gradle build files configured for Meta Spatial SDK
- Resource files for 3D models (scenes folder or assets)
- Organized code separating animation logic from scene management

## Nice to Have (Optional)
These enhancements will make the sample app easier to understand for Meta developers:
- **README.md file**: Explaining the different animation techniques demonstrated
- **Code comments**: Clear explanations of animation concepts and SDK usage
- **Animation documentation**: Comments describing animation timing, keyframes, and interpolation
- **Controller pattern documentation**: Explain how animation controllers are structured
- **Performance notes**: Comments about optimization considerations for VR animations
- **Example variations**: Show different ways to achieve similar animation effects

## Success Criteria
Your generated code will be evaluated on:
- **Completeness**: All necessary files for demonstrating multiple animation techniques
- **API Usage**: Proper use of Meta Spatial SDK v0.8.0 animation APIs
- **Animation variety**: Successfully demonstrates glTF animations, reusable drivers, and procedural animations
- **Code Quality**: Well-organized animation code following Kotlin best practices
- **SDK Patterns**: Follows animation patterns shown in SDK documentation
- **Documentation**: Clear explanations helping developers understand different animation approaches
- **Replaceability**: Code quality suitable for inclusion in the official Meta-Spatial-SDK-Samples repository

## ⚠️ IMPORTANT: Code Generation Only

**Generate complete source code only.**

**DO NOT attempt to:**
- Install the Meta Spatial SDK
- Build, compile, or run the code
- Install Android Studio or development tools
- Set up the Meta Spatial Editor CLI
- Download actual animated 3D models or production assets
- Install proprietary Meta tools

**Why**: The Meta Spatial SDK requires proprietary tooling (Spatial Editor CLI) that cannot be installed in standard development environments. These limitations have been consistently observed in agent running environments.

Your task is to generate well-structured, complete, and properly documented source code that demonstrates various animation techniques and could be compiled and run by a developer who has the proper Meta Quest development environment set up locally.
