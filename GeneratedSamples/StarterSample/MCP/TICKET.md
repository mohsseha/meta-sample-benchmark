# Starter Sample - VR Welcome Panel Application

## Objective
Create a starter VR application for Meta Spatial SDK v0.8.0 that displays a welcome panel with app information in an immersive 3D environment. This serves as a foundational template for developers getting started with Meta Spatial SDK.

## Clear Outcome Description
When the user launches the application on their Meta Quest headset, they should:
- Enter an immersive 3D virtual environment
- See a welcome panel floating in the 3D space displaying the app title and description
- Experience a realistic environment with proper lighting and a skybox
- Be able to interact with the virtual space in VR

## Technical Constraints
- **Target SDK version**: Meta Spatial SDK v0.8.0
- **Target platform**: Meta Quest 2/3/Pro
- **Language/framework**: Kotlin, Android
- **Build system**: Gradle with Meta Spatial SDK Gradle Plugin

## High-Level Components (Conceptual Only)
The application should include:
- A main activity that initializes and manages the VR experience
- VR feature enablement for immersive headset rendering
- A UI panel system using Jetpack Compose for displaying content
- Scene environment setup with lighting and skybox
- Asset loading capabilities for managing resources

## Visual/UX Requirements

### Welcome Panel Content
- **Title**: "Starter Sample" or similar welcome text
- **Description**: Brief text describing the app or SDK
- **Layout**: Content should be centered and properly padded
- **Styling**: Follow Meta Spatial SDK UI guidelines
- **Theme support**: Support both dark and light color themes
- **Panel appearance**: Clean, modern UI that integrates naturally into the 3D environment

### Placeholder Assets
Create simple placeholder image files (PNG format) as needed for:
- App icon or logo (if displayed)
- Any decorative UI elements
Don't worry about finding or downloading actual production-quality images.

## Scene/Environment Requirements
The 3D environment should include:
- **Lighting**: Realistic lighting setup that illuminates the scene appropriately
- **Skybox**: An environment skybox to create depth and immersion
- **Camera**: Proper VR camera setup for stereoscopic rendering
- **Spatial positioning**: The welcome panel should be positioned at a comfortable viewing distance and height for VR users

The exact values for lighting direction, color intensity, and panel positioning should be discovered from the SDK documentation and best practices.

## Functional Requirements

### Core VR Functionality
- Initialize the VR system and enable immersive headset rendering
- Configure the application to run as an immersive VR experience
- Handle VR-specific features and capabilities
- Set up proper reference space for VR tracking

### Scene and Environment Setup
- Load and initialize the 3D scene environment
- Configure scene composition from glXF files (scene files created/edited in Meta Spatial Editor)
- Set up environment lighting for realistic illumination
- Create and position a skybox for environmental backdrop
- Initialize the scene view origin and camera positioning

### Panel System
- Create and register UI panels using Jetpack Compose
- Display the welcome panel in 3D space at an appropriate position
- Configure panel size, styling, and display properties
- Integrate Compose UI with the spatial VR environment
- Support theme-aware rendering (dark/light themes)

### Asset Management
- Initialize asset loading system for networked and local assets
- Set up asset caching mechanisms
- Load scene composition files (glXF format)
- Access and configure entities and nodes from loaded scenes
- Handle asset lifecycle and cleanup

### Application Lifecycle
- Handle Android activity lifecycle events appropriately for VR
- Manage scene initialization and teardown
- Register required spatial features during app startup
- Configure build system integration with Meta Spatial SDK Gradle Plugin

## Project Structure Requirements
- Standard Android project structure with proper package organization
- Gradle build files configured for Meta Spatial SDK
- Resource files organized in appropriate directories (layouts, drawables, strings, etc.)
- Scene assets and configurations in the expected locations

## Nice to Have (Optional)
These enhancements will make the sample app easier to understand for Meta developers using it as reference:
- **README.md file**: Explaining what the sample demonstrates and how to use it
- **Code comments**: Clear comments explaining key SDK patterns and initialization steps
- **Documentation of SDK features**: Comments highlighting which SDK features are being used and why
- **Project description**: AndroidManifest metadata and build configuration descriptions
- **Asset organization**: Clear folder structure for scenes and resources

## Success Criteria
Your generated code will be evaluated on:
- **Completeness**: All necessary files for a working Android VR app are present
- **API Usage**: Appropriate Meta Spatial SDK v0.8.0 APIs discovered from documentation
- **Code Quality**: Follows Android/Kotlin best practices and conventions
- **SDK Patterns**: Matches the patterns and architecture shown in SDK documentation
- **Documentation**: Clear comments and explanations that help developers understand the code
- **Replaceability**: Code quality is good enough to be included as a replacement in the official Meta-Spatial-SDK-Samples repository

## ⚠️ IMPORTANT: Code Generation Only

**Generate complete source code only.**

**DO NOT attempt to:**
- Install the Meta Spatial SDK
- Build, compile, or run the code
- Install Android Studio or development tools
- Set up the Meta Spatial Editor CLI
- Download or install proprietary Meta tools

**Why**: The Meta Spatial SDK requires proprietary tooling (Spatial Editor CLI) that cannot be installed in standard development environments. These limitations have been consistently observed in agent running environments.

Your task is to generate well-structured, complete, and properly documented source code that could be compiled and run by a developer who has the proper Meta Quest development environment set up locally.
