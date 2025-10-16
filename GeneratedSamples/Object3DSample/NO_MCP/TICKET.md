# 3D Object Sample - Interactive 3D Object Selection and Insertion App

## Objective
Create an immersive VR application for Meta Spatial SDK v0.8.0 that allows users to select from a set of 3D objects and insert them into a custom scene environment, with properties adjustable through the Meta Spatial Editor.

## Clear Outcome Description
When the user launches the application on their Meta Quest headset, they should:
- Enter an immersive 3D VR environment
- See a UI allowing them to browse and select from various 3D models
- Be able to insert selected 3D objects into the scene
- View the inserted 3D objects in the environment
- Experience a scene that can be edited and customized using Meta Spatial Editor tools

## Technical Constraints
- **Target SDK version**: Meta Spatial SDK v0.8.0
- **Target platform**: Meta Quest 2/3/Pro
- **Language/framework**: Kotlin, Android
- **Build system**: Gradle with Meta Spatial SDK Gradle Plugin
- **3D assets**: Use glTF format models embedded in scene's glXF file

## High-Level Components (Conceptual Only)
The application should include:
- A main activity managing the immersive VR experience
- Object selection UI panel
- 3D object spawning and placement system
- Scene management for dynamically added objects
- Integration with scene composition loaded from glXF files
- Environment rendering

## Visual/UX Requirements

### Object Selection UI
- Display a catalog or list of available 3D objects
- Show object names or thumbnails
- Allow user to select which object to insert
- Clear, intuitive selection interface following SDK UI guidelines
- Use Jetpack Compose for panel creation

### 3D Objects in Scene
- Various 3D models demonstrating different types of objects
- Objects should be clearly visible and well-lit in the environment
- Proper scale and positioning for comfortable viewing
- Objects may include decorative items, furniture, props, etc.

### Environment
- Custom 3D scene environment showcasing the objects
- Appropriate lighting to display object details
- Background/skybox providing visual context
- Comfortable viewing layout

### Placeholder Assets
Create simple placeholder files:
- Multiple 3D model files (glTF format) - simple geometric shapes or basic models
- Thumbnails for UI (PNG format)
- Scene composition files
Don't worry about professional 3D models or textures.

## Scene/Environment Requirements
- **3D scene loading**: Load scene composition from glXF files
- **Object embedding**: 3D objects embedded in the scene's glXF
- **Lighting**: Scene lighting appropriate for showcasing 3D models
- **Environment mesh**: Background environment or stage area
- **Spatial Editor integration**: Scene structure compatible with Meta Spatial Editor for property adjustment

## Functional Requirements

### Object Management System
- Maintain a catalog of available 3D objects
- Load 3D models from glTF files
- Track spawned object instances in the scene

### Object Selection and Insertion
- UI for browsing available objects
- Mechanism to instantiate selected object in the scene
- Position objects at appropriate locations
- Handle multiple object instances

### Scene Composition
- Load scene from glXF files
- Access nodes and entities within the composition
- Integrate dynamically spawned objects with the loaded scene
- Manage scene entity hierarchy

### glTF and glXF Integration
- Work with glTF models for individual objects
- Use glXF format for scene composition
- Understand the relationship between glTFs embedded in glXF

### Meta Spatial Editor Support
- Scene structure allows property editing in Spatial Editor
- Object properties can be adjusted through editor tools
- Demonstrate editor-compatible scene organization

## Project Structure Requirements
- Standard Android project structure
- Scene assets organized in appropriate directories (scenes folder)
- 3D model files (glTF) for objects
- Object catalog or data structures
- UI panel code (Compose)
- Activity managing scene and object lifecycle
- Gradle configuration for Meta Spatial SDK

## Nice to Have (Optional)
These enhancements will make the sample app easier to understand for Meta developers:
- **README.md file**: Explaining object insertion system and Editor integration
- **Code comments**: Clear explanations of glTF/glXF usage
- **Scene structure documentation**: Explain how scene is organized for Editor compatibility
- **Object catalog**: Document available objects and their properties
- **Editor workflow**: Instructions for using Spatial Editor with this sample
- **glXF explanation**: Comments on scene composition format
- **Best practices**: When to use embedded vs. external glTF files

## Success Criteria
Your generated code will be evaluated on:
- **Completeness**: All necessary files for functional 3D object insertion
- **API Usage**: Proper use of Meta Spatial SDK v0.8.0 3D object and scene APIs
- **glTF/glXF integration**: Correct usage of 3D asset formats
- **Code Quality**: Well-organized object management code
- **SDK Patterns**: Matches 3D object patterns from SDK documentation
- **Editor compatibility**: Scene structure works with Meta Spatial Editor
- **Documentation**: Clear explanations of 3D object workflow
- **Replaceability**: Code quality suitable for inclusion in the official Meta-Spatial-SDK-Samples repository

## ⚠️ IMPORTANT: Code Generation Only

**Generate complete source code only.**

**DO NOT attempt to:**
- Install the Meta Spatial SDK
- Build, compile, or run the code
- Install Android Studio or development tools
- Set up the Meta Spatial Editor CLI
- Download professional 3D models or textures
- Install proprietary Meta tools
- Open or edit scenes in Meta Spatial Editor

**Why**: The Meta Spatial SDK requires proprietary tooling (Spatial Editor CLI) that cannot be installed in standard development environments. These limitations have been consistently observed in agent running environments.

Your task is to generate well-structured, complete, and properly documented source code that demonstrates 3D object insertion and Editor integration, and could be compiled and run by a developer who has the proper Meta Quest development environment set up locally.
