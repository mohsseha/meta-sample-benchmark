# MRUK Sample - Physical Environment Overlay App

## Objective
Create an immersive mixed reality application for Meta Spatial SDK v0.8.0 that demonstrates how to build experiences influenced by the user's physical surroundings by overlaying virtual objects on top of detected physical objects in the room (tables, couches, windows, doors, beds, etc.).

## Clear Outcome Description
When the user launches the application on their Meta Quest headset, they should:
- Enter a mixed reality experience that understands their physical room layout
- See virtual objects or visualizations overlaid on detected physical furniture and surfaces
- Experience seamless integration between virtual content and real-world objects
- Be able to interact with or observe various demonstrations of physical environment awareness
- Witness how the app adapts to different room configurations and furniture layouts

## Technical Constraints
- **Target SDK version**: Meta Spatial SDK v0.8.0
- **Target platform**: Meta Quest 2/3/Pro
- **Language/framework**: Kotlin, Android
- **Build system**: Gradle with Meta Spatial SDK Gradle Plugin
- **Required capabilities**: Scene understanding, spatial anchors, room/object detection

## High-Level Components (Conceptual Only)
The application should include:
- A main activity managing the mixed reality experience
- Room understanding and scene data retrieval system
- Physical object detection and classification (tables, walls, furniture, etc.)
- Virtual object placement aligned with physical surfaces
- Multiple demonstration experiences showcasing different MRUK capabilities
- Permission handling for accessing scene data
- Interaction with detected physical environment meshes

## Visual/UX Requirements

### Mixed Reality Experience
- User perceives their actual physical environment
- Virtual overlays clearly distinguish from but integrate with real objects
- Visualizations show detected surfaces and object boundaries
- Clear feedback indicating what physical objects are detected

### Sample Experiences (Multiple Demonstrations)
The app should showcase several interaction patterns with the physical environment:
- **Surface Anchoring**: Placing virtual objects on detected physical surfaces
- **Object Tracking**: Tracking specific physical objects (like keyboards)
- **QR Code Integration**: Detecting and responding to QR codes in the environment
- **Raycasting**: Using ray-based interaction to detect and place objects on physical surfaces

### UI Panels (Optional)
- Control or selection panels for choosing different demo experiences
- Information display showing detected room features
- Follow Meta Spatial SDK UI guidelines

### Placeholder Assets
Create simple placeholder files:
- Virtual object 3D models (glTF format) for placement on surfaces
- UI graphics (PNG format)
Focus on the MRUK integration, not production-quality assets.

## Scene/Environment Requirements
- **Physical space detection**: Detect and classify room elements
- **Surface meshing**: Work with meshes representing physical world
- **Spatial anchors**: Anchor virtual content to physical locations persistently
- **Multi-object support**: Handle various types of physical objects (furniture, architectural elements)
- **Dynamic adaptation**: Respond to different room layouts and configurations

## Functional Requirements

### MRUK Core Integration
- Request and obtain permission to access scene mode data
- Retrieve comprehensive scene data from the Quest device
- Process room geometry including walls, floor, ceiling
- Detect and classify furniture and objects (tables, couches, beds, windows, doors, etc.)
- Access mesh data representing the physical environment

### Anchor Mesh Experience
- Demonstrate anchoring virtual 3D models to physical surfaces
- Show placement and manipulation on tables, floors, and walls
- Persist anchors across sessions (optional)

### Keyboard Tracker Experience
- Detect physical keyboard position in mixed reality
- Track keyboard location for interaction
- Enable typing while maintaining visual awareness

### QR Code Scanner Experience
- Implement QR code detection in the physical environment
- Process QR codes to trigger actions or load content
- Demonstrate practical use of environmental code scanning

### Raycast Experience
- Use raycasting to interact with the physical environment
- Detect surfaces with precision using ray-based interaction
- Place objects accurately based on ray hits

### Permission and Privacy
- Handle scene access permission requests appropriately
- Gracefully handle permission denial
- Follow privacy best practices

## Reference Documentation
Full documentation is available here: `/home/husainal-mohssen/src/Meta-spatial-sdk-docs` (Meta Spatial SDK v0.8.0)

You are encouraged to search this documentation to discover:
- Mixed Reality Utility Kit (MRUK) comprehensive APIs
- Scene mode permission handling
- Retrieving and processing scene data
- Object detection and classification
- Working with physical environment meshes
- Spatial anchor creation and management
- Best practices for keyboard tracking, QR detection, and raycasting
- Room data structures and geometry access

The agent may also search online for general spatial computing, QR code detection, raycasting, and Kotlin documentation as needed.

## Project Structure Requirements
- Standard Android project structure
- Multiple demonstration modules or activities for different experiences
- Permission handling code
- MRUK integration classes
- Scene data processing code
- Navigation or selection UI between different demos
- Gradle configuration for Meta Spatial SDK

## Nice to Have (Optional)
These enhancements will make the sample app easier to understand for Meta developers:
- **README.md file**: Explaining each demonstration experience
- **Code comments**: Clear explanations of MRUK usage patterns
- **Permission flow documentation**: Explain scene access permission process
- **Experience documentation**: Document what each demo showcases
- **MRUK best practices**: Notes on proper scene data handling
- **Room adaptation**: Explain how the app adapts to different room layouts
- **Object classification**: Comments on detecting different furniture types
- **Use case guidance**: When to use each interaction pattern

## Success Criteria
Your generated code will be evaluated on:
- **Completeness**: All necessary files for functional MRUK demonstrations
- **API Usage**: Proper use of Meta Spatial SDK v0.8.0 MRUK APIs
- **Multiple experiences**: Successfully demonstrates various MRUK capabilities
- **Code Quality**: Well-organized code with clear separation between demos
- **SDK Patterns**: Matches MRUK patterns from SDK documentation
- **Documentation**: Clear explanations of physical environment integration
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

Your task is to generate well-structured, complete, and properly documented source code that demonstrates comprehensive MRUK integration with multiple experiences, and could be compiled and run by a developer who has the proper Meta Quest development environment set up locally.
