# Physics Sample - Interactive Physics Simulation App

## Objective
Create an immersive VR application for Meta Spatial SDK v0.8.0 that demonstrates how to add physics components to 3D objects and adjust their properties through the Meta Spatial Editor, showcasing realistic physics interactions including collision, gravity, and object dynamics.

## Clear Outcome Description
When the user launches the application on their Meta Quest headset, they should:
- Enter an immersive 3D VR environment with physics-enabled objects
- See various 3D objects demonstrating different physics behaviors
- Interact with physics objects (push buttons, pull triggers, spin objects)
- Watch objects collide, bounce, and respond to forces realistically
- Experience multiple interaction types implemented through custom systems
- Observe how physics components affect object behavior

## Technical Constraints
- **Target SDK version**: Meta Spatial SDK v0.8.0
- **Target platform**: Meta Quest 2/3/Pro
- **Language/framework**: Kotlin, Android
- **Build system**: Gradle with Meta Spatial SDK Gradle Plugin
- **3D assets**: Use glTF format models embedded in scene's glXF file
- **Physics**: Meta Spatial SDK physics simulation

## High-Level Components (Conceptual Only)
The application should include:
- A main activity managing the immersive VR experience with physics
- Physics simulation enablement and configuration
- Multiple 3D objects with varying physics properties
- Custom systems implementing different interaction types (Button, Trigger, Spinner, etc.)
- Scene management with physics-enabled entities
- Integration with scene composition from glXF files
- Collision handling and response
- Meta Spatial Editor integration for property adjustment

## Visual/UX Requirements

### Physics Objects
- Various 3D objects demonstrating different physics behaviors
- Clear visual distinction between different object types and their interactions
- Objects with appropriate mass, size, and appearance for their physics role
- Smooth physics animation and response

### Interaction Types
- **Buttons**: Objects that can be pushed and respond with physics
- **Triggers**: Pull-able mechanisms with physics constraints
- **Spinners**: Rotatable objects with angular physics
- **Free objects**: Items that can be moved, thrown, or collide freely
- Each interaction type clearly demonstrable

### Environment
- Custom 3D scene setup for physics demonstrations
- Stable surfaces and structures for physics interactions
- Appropriate lighting to see object movement
- Visual feedback for interactions (optional)

### Placeholder Assets
Create simple placeholder files:
- Multiple 3D model files (glTF format) - buttons, levers, spinning objects, etc.
- Simple geometric shapes suitable for physics demonstrations
- Scene composition files
Focus on physics behavior, not production-quality 3D models.

## Scene/Environment Requirements
- **3D scene loading**: Load scene composition from glXF files
- **Physics-enabled objects**: 3D objects embedded in glXF with physics components
- **Collision geometry**: Proper collision meshes for physics interactions
- **Lighting and environment**: Scene setup showing physics behavior clearly
- **Spatial Editor integration**: Scene structure allowing physics property adjustment in Editor

## Functional Requirements

### Physics System Integration
- Enable physics features in the application
- Configure gravity and physics simulation parameters
- Handle physics updates per frame
- Manage physics component lifecycle

### Physics Properties
- Assign physics components to 3D objects
- Configure properties: mass, bounciness, friction, collision shapes, etc.
- Set up constraints for specific interaction types
- Define collision behavior

### Custom Interaction Systems
- Implement systems for different interaction patterns
- **Button System**: Handle button press physics and state
- **Trigger System**: Manage trigger pull mechanics
- **Spinner System**: Control rotational physics
- Use the system architecture pattern for processing physics-enabled entities

### Collision Handling
- Detect collisions between objects
- Respond to collision events
- Configure collision layers or filters (optional)
- Implement physics-based responses

### Scene and Object Management
- Load scene from glXF files
- Access and configure physics-enabled entities
- Spawn or activate physics objects
- Manage entity hierarchy with physics components

### Meta Spatial Editor Integration
- Structure scene for Editor-based physics property adjustment
- Allow physics parameters to be tuned in the Editor
- Document which properties are editor-configurable

## Project Structure Requirements
- Standard Android project structure
- Scene assets organized in scenes folder
- 3D model files (glTF) with physics-appropriate collision geometry
- Custom system implementations (Button, Trigger, Spinner, etc.)
- Physics configuration code
- Activity managing physics lifecycle
- Gradle configuration for Meta Spatial SDK with physics support

## Nice to Have (Optional)
These enhancements will make the sample app easier to understand for Meta developers:
- **README.md file**: Explaining physics integration and different interaction systems
- **Code comments**: Clear explanations of physics setup and system implementations
- **Physics properties documentation**: Explain typical values for mass, friction, etc.
- **System pattern explanation**: Document the custom system architecture
- **Editor workflow**: Instructions for adjusting physics in Spatial Editor
- **Interaction type guide**: When to use each interaction pattern
- **Performance tips**: Optimizing physics for VR
- **Collision tuning**: How to configure collision behavior

## Success Criteria
Your generated code will be evaluated on:
- **Completeness**: All necessary files for functional physics demonstrations
- **API Usage**: Proper use of Meta Spatial SDK v0.8.0 physics APIs
- **Multiple interactions**: Successfully demonstrates various physics-based interactions
- **System architecture**: Well-implemented custom systems for different interaction types
- **Code Quality**: Clean, organized physics code
- **SDK Patterns**: Matches physics and system patterns from SDK documentation
- **Editor compatibility**: Physics properties adjustable in Meta Spatial Editor
- **Documentation**: Clear explanations of physics concepts
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
- Test physics on actual Quest hardware

**Why**: The Meta Spatial SDK requires proprietary tooling (Spatial Editor CLI) that cannot be installed in standard development environments. These limitations have been consistently observed in agent running environments.

Your task is to generate well-structured, complete, and properly documented source code that demonstrates physics simulation and interactive systems, and could be compiled and run by a developer who has the proper Meta Quest development environment set up locally.
