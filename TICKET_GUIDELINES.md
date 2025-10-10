# Ticket Creation Guidelines

## Purpose
Create TICKET.md files based on examples from [Meta-Spatial-SDK-Samples](https://github.com/meta-quest/Meta-Spatial-SDK-Samples) to benchmark agent performance with/without ChBird.ai.

## Core Principle
**Tickets describe WHAT to build (outcomes & requirements), not HOW to build it (implementation details).**

Let agents demonstrate their ability to navigate documentation, discover correct APIs, and understand SDK patterns.

---

## Required Ticket Sections

### 1. Clear Outcome Description
What should the app do when it runs? What's the end user experience?

**Example:** "Create an immersive VR app that displays a welcome panel with app title and description in a 3D environment."

### 2. Technical Constraints
- Target SDK version: Meta Spatial SDK v0.8.0
- Target platform: Meta Quest 2/3/Pro
- Language/framework: Kotlin, Android

### 3. High-Level Components (Conceptual Only)
Describe needed parts using general terms, not specific class names.

✅ **Good:** "Create a main activity that enables VR features and displays a UI panel"
❌ **Bad:** "Extend AppSystemActivity and register VRFeature and ComposeFeature"

### 4. Visual/UX Requirements
- Content to display (text, images, etc.)
- Layout expectations (centered, padded, themed)
- Styling (follows SDK UI guidelines, supports dark/light themes)

### 5. Scene/Environment Requirements
Describe what the 3D environment includes (lighting, skybox, objects) using general terms, not exact values.

✅ **Good:** "Environment should have realistic lighting and a skybox"
❌ **Bad:** "Set sun color to (7.0, 7.0, 7.0) and direction to (-1.0, 3.0, -2.0)"

### 6. Reference Documentation
**Make this the FIRST STEP in every ticket:**
```bash
git clone https://github.com/mohsseha/Meta-spatial-sdk-docs ./meta-spacial-sdk-8.0.0-docs
```
Let agents discover specific APIs from the documentation.

### 7. Nice to Have (Optional)
Non-essential enhancements that keep main requirements focused:
- README.md files
- Code comments
- Debug features

---

## What to EXCLUDE from Tickets

### ❌ Never Include:
1. **Specific class names or API calls** - Let agents discover these from documentation
2. **Implementation details** - No exact method signatures, file structures, initialization sequences, or parameter values
3. **Line-by-line instructions** - No "Create function X", "In onCreate(), do Y" style directions
4. **Obvious details** - Standard Android project structure, resource file organization, Kotlin conventions

---

## Code Generation Requirements

### ⚠️ CRITICAL: Code Generation Only

**Agents must generate complete source code but:**
- **NEVER attempt to install the Meta Spatial SDK**
- **NEVER attempt to build, compile, or run the code**
- **The SDK requires proprietary tools (Spatial Editor CLI) that cannot be installed in standard environments**

**Success criteria:**
- Generate complete, well-structured source code
- Use appropriate Meta Spatial SDK v0.8.0 APIs discovered from documentation
- Follow Android/Kotlin best practices
- Match SDK patterns from documentation

**Every ticket must explicitly state:**
```
⚠️ IMPORTANT: Generate complete source code only.
DO NOT attempt to install the Meta Spatial SDK or build/compile the code.
The SDK requires proprietary tooling not available in this environment.
```

---

## Example: Good vs Bad Ticket

### ❌ BAD (Too Prescriptive - Specifies HOW)
```
Create StarterSampleActivity that extends AppSystemActivity.
In registerFeatures(), return a list with VRFeature(this) and ComposeFeature().
In onCreate(), call NetworkedAssetLoader.init() with File(applicationContext.getCacheDir()).
Create WelcomePanel composable using SpatialTheme with LocalColorScheme.current.panel.
Set sun color to Vector3(7.0f, 7.0f, 7.0f) and direction to -Vector3(1.0f, 3.0f, -2.0f).
```

### ✅ GOOD (Outcome-Focused - Describes WHAT)
```
## Objective
Create a starter VR application for Meta Spatial SDK v0.8.0 that displays a welcome panel
in an immersive 3D environment.

## Requirements
- Target platform: Meta Quest 2/3/Pro (Kotlin/Android)
- Display a welcome panel with app title and description using Jetpack Compose
- Render in immersive 3D environment with realistic lighting and skybox
- UI should support both dark and light themes
- Follow SDK best practices for UI panel creation and scene setup

## Reference Documentation
**FIRST STEP:** Clone the documentation:
git clone https://github.com/mohsseha/Meta-spatial-sdk-docs ./meta-spacial-sdk-8.0.0-docs

Use the documentation to discover appropriate APIs and implementation patterns.

## Nice to Have
- Code comments explaining key SDK patterns
- Basic README with project description

⚠️ IMPORTANT: Generate complete source code only.
DO NOT attempt to install the Meta Spatial SDK or build/compile the code.
The SDK requires proprietary tooling not available in this environment.
```
