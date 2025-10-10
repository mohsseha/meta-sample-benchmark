# Premium Media Sample - Advanced Media Streaming with Spatial Integration

## Objective
Create an immersive media streaming application for Meta Spatial SDK v0.8.0 that integrates media viewing into the user's spatial environment, with advanced features including DRM-protected content streaming, 180-degree video playback, panel snapping to walls using MRUK, and custom shaders for panel reflections.

## Clear Outcome Description
When the user launches the application on their Meta Quest headset, they should:
- Enter a media viewing experience integrated into their physical spatial environment
- Browse and select from various media content (standard video, 180-degree video, DRM-protected content)
- Watch media on panels that can snap to walls in their actual room
- Experience video panels that cast realistic reflections onto room surfaces
- Toggle between immersive VR environment and Passthrough mode
- See high-performance media playback with direct-to-surface rendering
- Interact with media controls through performant Jetpack Compose UI

## Technical Constraints
- **Target SDK version**: Meta Spatial SDK v0.8.0
- **Target platform**: Meta Quest 2/3/Pro
- **Language/framework**: Kotlin, Android
- **Build system**: Gradle with Meta Spatial SDK Gradle Plugin (with NDK for custom shaders)
- **Media framework**: ExoPlayer for video playback
- **Advanced features**: Custom shaders, DRM support, MRUK integration

## High-Level Components (Conceptual Only)
The application should include:
- A main activity managing the immersive media experience
- Media library and selection system
- Multiple panel types for different media formats
- DRM-protected content streaming support
- 180-degree equirectangular video panel support
- Direct-to-surface rendering for performance
- Custom shader system for panel reflections
- MRUK integration for wall detection and panel snapping
- Passthrough mode toggle
- Multi-process activities for improved Jetpack Compose performance

## Visual/UX Requirements

### Media Selection Interface
- Browse available media content
- Categorize by type (standard, 180°, DRM-protected)
- Thumbnail previews
- Clear selection UI following SDK guidelines
- High-performance Compose implementation

### Video Playback
- Standard flat video panels
- 180-degree, equirectangular stereo video panels
- High-quality video rendering
- Smooth playback performance
- Media controls (play, pause, seek)

### Spatial Integration
- Video panels that snap to detected walls using MRUK
- Panels positioned naturally in the user's room
- Custom shader effects showing panel reflections on walls
- Seamless integration with physical environment

### Passthrough Mode
- Toggle to visualize physical world
- Media panels remain visible in Passthrough
- Smooth transition between modes

### Placeholder Assets
Create simple placeholder files:
- Sample video files (or URIs) - small test videos
- Thumbnails for media library (PNG format)
- UI graphics (PNG format)
Don't worry about obtaining actual premium media content or DRM licenses.

## Scene/Environment Requirements
- **MRUK Integration**: Detect and utilize user's room walls for panel placement
- **Custom environment**: VR scene for non-Passthrough mode
- **Shader support**: Custom shaders for visual effects
- **Lighting**: Appropriate for media viewing
- **Panel reflections**: Shader effects casting panel light onto MRUK-detected surfaces

## Functional Requirements

### Media Playback System
- Support multiple video formats
- Standard flat video playback
- 180-degree equirectangular video support
- Stereo 3D video rendering (for 180° content)
- Media player lifecycle management

### DRM Protected Streaming
- Widevine DRM support
- Secure video pipeline
- DRM license handling
- Protected content playback via ExoPlayer

### Direct-to-Surface Rendering
- High-performance panel rendering
- Direct surface access for ExoPlayer
- Required for DRM content
- Optimized video path

### Panel Types and Registration
- Standard video panels (Compose-based)
- 180-degree equirect panels for immersive video
- Direct-to-surface video panels for DRM
- Appropriate panel registration for each type

### MRUK Spatial Integration
- Request scene access permissions
- Retrieve room geometry and wall data
- Snap panels to detected walls
- Position panels appropriately on physical surfaces

### Custom Panel Shaders
- Implement custom shaders for panel rendering
- Use SceneTexture for shader input
- Create reflection effects onto MRUK walls
- Panel-to-environment lighting interactions

### Passthrough Support
- Enable/disable Passthrough visualization
- Maintain panel visibility in both modes
- Seamless mode transitions

### Performance Optimization
- Multi-process architecture for Jetpack Compose activities
- Efficient panel management
- Optimized shader execution
- Handle activity process separation

## Reference Documentation
Full documentation is available here: `/home/husainal-mohssen/src/Meta-spatial-sdk-docs` (Meta Spatial SDK v0.8.0)

You are encouraged to search this documentation to discover:
- Panel registration APIs (all types: Compose, Video Surface, etc.)
- 180-degree equirect panel setup
- DRM-protected content streaming
- Direct-to-surface panel rendering
- Custom shader development and SceneTexture usage
- MRUK integration for wall detection and snapping
- Passthrough API
- Multi-process activity architecture for performance
- ExoPlayer integration with Spatial SDK
- NDK setup for custom shaders

The agent may also search online for ExoPlayer, Widevine DRM, shader programming (GLSL), and Android multi-process architecture as needed.

## Project Structure Requirements
- Standard Android project structure
- Multiple activities (potentially in separate processes)
- Custom shader code (GLSL) in appropriate directories
- Media catalog and management code
- Different panel implementations for each media type
- DRM handling code
- MRUK integration classes
- Shader compilation and loading system
- Gradle configuration with NDK support
- build.gradle.kts with NDK version specification

## Nice to Have (Optional)
These enhancements will make the sample app easier to understand for Meta developers:
- **README.md file**: Explaining the advanced media features
- **Code comments**: Clear explanations of DRM, shaders, and MRUK integration
- **Panel type guide**: When to use each panel registration type
- **Shader documentation**: Explain custom shader implementation and SceneTexture
- **DRM setup notes**: How DRM pipeline works
- **180° video guide**: Setting up equirectangular video
- **Performance architecture**: Explain multi-process approach
- **MRUK integration**: Document wall detection and snapping logic
- **NDK requirements**: Custom shader compilation needs

## Success Criteria
Your generated code will be evaluated on:
- **Completeness**: All necessary files for advanced media streaming
- **API Usage**: Proper use of Meta Spatial SDK v0.8.0 media, shader, and MRUK APIs
- **Multiple features**: Successfully demonstrates DRM, 180°, shaders, MRUK
- **Code Quality**: Well-organized, complex feature integration
- **SDK Patterns**: Matches advanced patterns from SDK documentation
- **Architecture**: Proper multi-process setup for performance
- **Documentation**: Clear explanations of advanced concepts
- **Replaceability**: Code quality suitable for inclusion in the official Meta-Spatial-SDK-Samples repository

## ⚠️ IMPORTANT: Code Generation Only

**Generate complete source code only.**

**DO NOT attempt to:**
- Install the Meta Spatial SDK
- Build, compile, or run the code
- Install Android Studio or development tools
- Set up the Meta Spatial Editor CLI
- Configure NDK or compile shaders
- Obtain DRM licenses or protected content
- Download actual premium media files
- Install proprietary Meta tools
- Test on actual Quest hardware

**Why**: The Meta Spatial SDK requires proprietary tooling (Spatial Editor CLI) that cannot be installed in standard development environments. Custom shaders require NDK compilation. DRM requires licensing. These limitations have been consistently observed in agent running environments.

Your task is to generate well-structured, complete, and properly documented source code that demonstrates advanced media integration including DRM, custom shaders, and MRUK, and could be compiled and run by a developer who has the proper Meta Quest development environment set up locally with NDK configured.
