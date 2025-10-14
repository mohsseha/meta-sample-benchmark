# 3D Object Sample with ISDK - Interactive 3D Object Selection with ISDK Input

## Objective
Create an immersive VR application for Meta Spatial SDK v0.8.0 that allows users to select from a set of 3D objects and insert them into a custom scene environment using ISDK (Interaction SDK) for advanced hand and controller interactions, with properties adjustable through the Meta Spatial Editor.

## Clear Outcome Description
When the user launches the application on their Meta Quest headset, they should:
- Enter an immersive 3D VR environment with ISDK-based interaction system
- See a UI allowing them to browse and select from various 3D models
- Be able to interact with objects using enhanced hand tracking and controller features
- Insert selected 3D objects into the scene with natural interaction patterns
- Experience near-field touch, grabbing, and manipulation of objects
- View and interact with inserted 3D objects using ISDK capabilities

## Technical Constraints
- **Target SDK version**: Meta Spatial SDK v0.8.0
- **Target platform**: Meta Quest 2/3/Pro
- **Language/framework**: Kotlin, Android
- **Build system**: Gradle with Meta Spatial SDK Gradle Plugin
- **Input system**: ISDK (default in v0.8.0) for advanced interactions
- **3D assets**: Use glTF format models embedded in scene's glXF file

## High-Level Components (Conceptual Only)
The application should include:
- A main activity managing the immersive VR experience
- ISDK-enabled input and interaction system
- Object selection UI panel with ISDK interaction support
- 3D object spawning with grabbable and manipulatable properties
- Scene management for dynamically added interactive objects
- Integration with scene composition loaded from glXF files
- Hand tracking and controller interaction handling

## Visual/UX Requirements

### Object Selection UI
- Display a catalog or list of available 3D objects
- Support ISDK-based interaction (pointing, touching, selecting)
- Show object names or thumbnails
- Clear, intuitive selection interface following SDK UI guidelines
- Use Jetpack Compose for panel creation
- Panels oriented correctly with normals pointing forward (ISDK requirement)

### 3D Objects in Scene
- Various 3D models with ISDK interaction capabilities
- Objects that can be grabbed and manipulated
- Visual feedback for near-field interactions
- Proper scale and positioning for hand/controller interaction
- Clear grabbable affordances

### Interaction Feedback
- Visual indicators when objects are hovered or touched
- Smooth grabbing and release behavior
- Natural object manipulation with hands or controllers
- Cursor visualization for raycasting interactions

### Environment
- Custom 3D scene environment showcasing interactive objects
- Appropriate lighting to display object details
- Background/skybox providing visual context
- Comfortable interaction space layout

### Placeholder Assets
Create simple placeholder files:
- Multiple 3D model files (glTF format) - simple shapes suitable for grabbing
- UI thumbnails (PNG format)
- Scene composition files
Focus on interaction mechanics, not production-quality assets.

## Scene/Environment Requirements
- **3D scene loading**: Load scene composition from glXF files
- **Object embedding**: 3D objects embedded in the scene's glXF
- **Lighting**: Scene lighting appropriate for viewing and interacting with 3D models
- **Environment mesh**: Background environment or interaction space
- **Spatial Editor integration**: Scene structure compatible with Meta Spatial Editor
- **Interaction zones**: Proper spatial layout for comfortable near-field and far-field interactions

## Functional Requirements

### ISDK Input System
- Enable and configure ISDK as the primary input system (default in v0.8.0)
- Support hand tracking for near-field interactions
- Support controller-based interactions
- Implement raycasting for far-field selection
- Handle microgestures (optional)

### Object Grabbing and Manipulation
- Configure objects with grabbable properties
- Implement grab, hold, and release mechanics
- Support object transformation (position, rotation) while grabbed
- Handle near-field touch limiting
- Ensure single-sided panel interactions (ISDK requirement)

### Object Selection and Insertion
- UI for browsing available objects with ISDK interaction
- Mechanism to instantiate selected object in the scene
- Position objects appropriately for interaction
- Apply interactive properties to spawned objects

### Scene Composition
- Load scene from glXF files
- Access nodes and entities within the composition
- Integrate dynamically spawned interactive objects
- Manage scene entity hierarchy

### Input System Integration
- Configure ISDK system (default in v0.8.0)
- Set up grabbable components on objects
- Implement interaction event handling
- Ensure proper panel orientations for ISDK

## Project Structure Requirements
- Standard Android project structure
- Scene assets in appropriate directories (scenes folder)
- 3D model files (glTF) configured for ISDK interaction
- Object catalog with grabbable properties
- UI panel code (Compose) with correct orientations
- Activity managing ISDK and scene lifecycle
- Interaction event handlers
- Gradle configuration for Meta Spatial SDK with ISDK support

## Nice to Have (Optional)
These enhancements will make the sample app easier to understand for Meta developers:
- **README.md file**: Explaining ISDK integration and object interaction
- **Code comments**: Clear explanations of ISDK setup and usage
- **Interaction patterns**: Document grabbing, touching, and manipulation mechanics
- **ISDK configuration**: Explain default input system and how to opt-out if needed
- **Panel orientation**: Comments on single-sided panel requirements
- **Grabbable setup**: Document how to configure objects for interaction
- **Migration notes**: If coming from simple controller input, explain differences
- **Best practices**: When to use near-field vs far-field interactions

## Success Criteria
Your generated code will be evaluated on:
- **Completeness**: All necessary files for functional ISDK-based 3D object interaction
- **API Usage**: Proper use of Meta Spatial SDK v0.8.0 ISDK and 3D object APIs
- **ISDK integration**: Successfully demonstrates ISDK capabilities
- **Interaction quality**: Natural grabbing and manipulation mechanics
- **Code Quality**: Well-organized interaction code
- **SDK Patterns**: Matches ISDK patterns from SDK documentation
- **Editor compatibility**: Scene structure works with Meta Spatial Editor
- **Documentation**: Clear explanations of ISDK workflow
- **Replaceability**: Code quality suitable for inclusion in the official Meta-Spatial-SDK-Samples repository

## ⚠️ IMPORTANT: Code Generation Only

**Generate complete source code only.**

**DO NOT attempt to:**
- Install the Meta Spatial SDK
- Build, compile, or run the code
- Install Android Studio or development tools
- Set up the Meta Spatial Editor CLI
- Download 3D models or production assets
- Install proprietary Meta tools
- Test with Quest hand tracking or controllers

**Why**: The Meta Spatial SDK requires proprietary tooling (Spatial Editor CLI) that cannot be installed in standard development environments. These limitations have been consistently observed in agent running environments.

Your task is to generate well-structured, complete, and properly documented source code that demonstrates 3D object interaction with ISDK, and could be compiled and run by a developer who has the proper Meta Quest development environment set up locally.
