# Custom Components Sample - Shared Component System App

## Objective
Create an immersive VR application for Meta Spatial SDK v0.8.0 that demonstrates how to create custom components that embody data shared across multiple instances of objects in the application, showcasing the component-based architecture pattern.

## Clear Outcome Description
When the user launches the application on their Meta Quest headset, they should:
- Enter an immersive 3D VR environment
- See multiple objects or entities that share common behavior through custom components
- Observe how custom component data affects object behavior
- Witness the component system pattern in action with reusable, data-driven components
- Understand how components can be created and attached to different entities

## Technical Constraints
- **Target SDK version**: Meta Spatial SDK v0.8.0
- **Target platform**: Meta Quest 2/3/Pro
- **Language/framework**: Kotlin, Android
- **Build system**: Gradle with Meta Spatial SDK Gradle Plugin
- **Architecture**: Component-based entity system

## High-Level Components (Conceptual Only)
The application should include:
- A main activity managing the VR experience
- Custom component definitions that encapsulate shared data
- Multiple entities/objects that use these custom components
- Systems that process and update component data
- UI panels (optional) for displaying component information or controls
- Scene management for entities with custom components

## Visual/UX Requirements

### 3D Scene Elements
- Multiple 3D objects in the scene demonstrating component usage
- Visual feedback showing how component data affects object appearance or behavior
- Objects positioned clearly in 3D space for easy observation
- Clear demonstration of data sharing across component instances

### UI Panel (Optional)
- May include informational or control panels built with Jetpack Compose
- Display component data or allow interaction with component properties
- Follow Meta Spatial SDK UI theming guidelines

### Placeholder Assets
Create simple placeholder files:
- Basic 3D models (glTF format) for objects using components
- UI graphics if needed (PNG format)
Focus on the component architecture, not production-quality assets.

## Scene/Environment Requirements
The 3D environment should include:
- **Lighting**: Appropriate scene lighting for viewing objects
- **Background**: Skybox or environment backdrop
- **Spatial layout**: Objects arranged to demonstrate component system
- **VR optimization**: Efficient rendering for Quest headset

## Functional Requirements

### Custom Component Creation
- Define one or more custom component types
- Components should encapsulate data that can be shared across entities
- Demonstrate proper component structure and data management

### Component System Integration
- Show how components are attached to entities
- Demonstrate accessing and modifying component data
- Illustrate component lifecycle management

### Multi-Instance Demonstration
- Multiple objects/entities using the same custom component types
- Show how component data affects different instances
- Demonstrate data sharing and isolation as appropriate

### System Processing
- Create systems that query for and process entities with specific components
- Show how systems update component data over time
- Demonstrate the entity-component-system (ECS) pattern

## Project Structure Requirements
- Standard Android project structure
- Separate files/packages for custom component definitions
- System classes for processing components
- Entity creation and management code
- Gradle configuration for Meta Spatial SDK
- Clear separation of concerns (components, systems, entities)

## Nice to Have (Optional)
These enhancements will make the sample app easier to understand for Meta developers:
- **README.md file**: Explaining the component-based architecture approach
- **Code comments**: Clear explanations of component patterns
- **Architecture documentation**: Comments describing ECS principles
- **Component documentation**: Explanation of each custom component's purpose
- **System documentation**: How systems query and process components
- **Best practices**: When to use custom components vs. built-in ones
- **Data flow diagrams**: Comments explaining how data flows through the component system

## Success Criteria
Your generated code will be evaluated on:
- **Completeness**: All necessary files for a functional custom component demonstration
- **API Usage**: Proper use of Meta Spatial SDK v0.8.0 component APIs
- **Component design**: Well-structured custom components with clear purposes
- **Code Quality**: Clean architecture following ECS patterns
- **SDK Patterns**: Follows component system patterns from SDK documentation
- **Documentation**: Clear explanations of component-based architecture
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

**Why**: The Meta Spatial SDK requires proprietary tooling (Spatial Editor CLI) that cannot be installed in standard development environments. These limitations have been consistently observed in agent running environments.

Your task is to generate well-structured, complete, and properly documented source code that demonstrates custom component creation and usage, and could be compiled and run by a developer who has the proper Meta Quest development environment set up locally.
