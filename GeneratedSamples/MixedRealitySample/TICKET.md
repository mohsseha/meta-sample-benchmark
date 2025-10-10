# Mixed Reality Sample - Physical Environment Interaction App

## Objective
Create an immersive mixed reality application for Meta Spatial SDK v0.8.0 that allows users to interact with their physical environment by shooting basketballs at targets on their room's walls, with realistic physics interactions including bouncing off walls, ceilings, and objects.

## Clear Outcome Description
When the user launches the application on their Meta Quest headset, they should:
- Enter a mixed reality experience where they can see their actual physical room
- See virtual targets attached to their real walls
- Be able to spawn and shoot virtual basketballs
- Watch the basketballs bounce realistically off detected physical surfaces (walls, ceiling, floor, furniture)
- Experience seamless integration of virtual objects with their physical environment
- Interact with the scene using VR controllers

## Technical Constraints
- **Target SDK version**: Meta Spatial SDK v0.8.0
- **Target platform**: Meta Quest 2/3/Pro
- **Language/framework**: Kotlin, Android
- **Build system**: Gradle with Meta Spatial SDK Gradle Plugin
- **Required capabilities**: Scene understanding, spatial anchors, physics simulation

## High-Level Components (Conceptual Only)
The application should include:
- A main activity managing the mixed reality experience
- Room understanding and scene data retrieval system
- Virtual object spawning (basketballs)
- Target placement on physical surfaces
- Physics simulation for object interactions
- Collision detection with physical environment
- Permission handling for accessing scene data
- Procedural mesh generation aligned with physical surfaces

## Visual/UX Requirements

### Mixed Reality Experience
- User sees their actual physical room through Passthrough or scene understanding
- Virtual basketballs rendered with clear appearance
- Targets visibly attached to wall surfaces
- Clear visual distinction between virtual and physical elements
- Smooth rendering and tracking

### Interactive Objects
- Basketballs that can be spawned by the user
- Shooting/throwing mechanism via controller
- Visible trajectory and physics behavior
- Targets that respond to hits (optional visual feedback)

### Physics Feedback
- Realistic bouncing behavior
- Proper collision sounds (optional)
- Visual feedback on impacts

### Placeholder Assets
Create simple placeholder files:
- Basketball 3D model (glTF format) - simple sphere with texture is fine
- Target 3D model (glTF format) - simple geometric shape
- Textures for objects (PNG format)
Focus on the MR interaction system, not production-quality assets.

## Scene/Environment Requirements
- **Physical space integration**: Detect and map the user's actual room
- **Surface detection**: Identify walls, floor, ceiling, and furniture
- **Collision meshes**: Generate or use procedural meshes aligned with physical boundaries
- **Spatial anchors**: Anchor virtual objects to physical locations
- **Lighting**: Consider real-world lighting for better integration (optional)

## Functional Requirements

### Mixed Reality Utility Kit (MRUK) Integration
- Request and obtain permission to access scene mode data
- Retrieve scene data from the Quest device
- Process room geometry and surface information
- Create procedural meshes aligned with 2D plane boundaries
- Manage spatial anchors for persistent object placement

### Physics System
- Enable physics features for gravity and collision
- Apply physics properties to basketballs (mass, bounciness, etc.)
- Configure collision detection with room surfaces
- Handle physics updates per frame

### Object Interaction
- Spawn basketball objects in the scene
- Implement shooting/throwing mechanics
- Track object velocities and trajectories
- Handle object lifecycle (cleanup after time or distance)

### Target System
- Place targets on wall surfaces automatically or via user input
- Detect collisions between basketballs and targets
- Provide feedback on successful hits (optional)

### Permission and Privacy
- Request scene access permission appropriately
- Handle permission denial gracefully
- Follow best practices for privacy and user consent

## Reference Documentation
Full documentation is available here: `/home/husainal-mohssen/src/Meta-spatial-sdk-docs` (Meta Spatial SDK v0.8.0)

You are encouraged to search this documentation to discover:
- Mixed Reality Utility Kit (MRUK) APIs and usage
- Scene mode permission handling
- How to retrieve and process scene data
- Creating procedural meshes with AnchorProceduralMesh
- Physics feature enablement and configuration
- Collision detection implementation
- Best practices for mixed reality experiences

The agent may also search online for general physics simulation, spatial computing, and Kotlin documentation as needed.

## Project Structure Requirements
- Standard Android project structure
- Permission handling code (Android manifest and runtime permissions)
- MRUK integration classes
- Physics system setup
- Object spawning and management code
- Controller input handling
- Gradle configuration for Meta Spatial SDK with physics support

## Nice to Have (Optional)
These enhancements will make the sample app easier to understand for Meta developers:
- **README.md file**: Explaining the mixed reality and physics integration
- **Code comments**: Clear explanations of MRUK usage and physics setup
- **Permission flow documentation**: Explain the scene access permission process
- **Physics tuning notes**: Comments on physics parameters and how to adjust them
- **MRUK best practices**: Document proper scene data handling
- **Collision detection**: Explain the collision mesh generation process
- **Performance considerations**: Notes on optimizing physics and mesh processing
- **User experience tips**: Comfortable interaction patterns for mixed reality

## Success Criteria
Your generated code will be evaluated on:
- **Completeness**: All necessary files for a functional mixed reality physics app
- **API Usage**: Proper use of Meta Spatial SDK v0.8.0 MRUK and Physics APIs
- **Physical integration**: Successfully demonstrates interaction with real environment
- **Code Quality**: Well-organized code following best practices
- **SDK Patterns**: Matches MRUK and physics patterns from SDK documentation
- **Documentation**: Clear explanations of mixed reality concepts
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
- Test on actual Quest hardware

**Why**: The Meta Spatial SDK requires proprietary tooling (Spatial Editor CLI) that cannot be installed in standard development environments. These limitations have been consistently observed in agent running environments.

Your task is to generate well-structured, complete, and properly documented source code that demonstrates mixed reality physics interaction, and could be compiled and run by a developer who has the proper Meta Quest development environment set up locally.
