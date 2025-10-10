# Ticket Creation Guidelines

## Purpose
Create TICKET.md files based on examples from [Meta-Spatial-SDK-Samples](https://github.com/meta-quest/Meta-Spatial-SDK-Samples) to benchmark agent performance with/without ChBird.ai.

## Core Principle
**Tickets describe WHAT to build (outcomes & requirements), not HOW to build it (implementation details).**

Let agents demonstrate their ability to navigate documentation, discover correct APIs, and understand SDK patterns.

THE AGENT WILL BE SCORED BASED ON HOW GOOD IS THE OUTPUT CODE TO BE INCLUDE AS A REPLACEMENT IN THE CURRENT CODE IN [Meta-Spatial-SDK-Samples](https://github.com/meta-quest/Meta-Spatial-SDK-Samples)

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
- Create resource dummy placeholder files (eg. PNGs etc) don't worry about finding or downloading actual images or 3D models etc.  

### 5. Scene/Environment Requirements
Describe what the 3D environment includes (lighting, skybox, objects) using general terms, not exact values.

✅ **Good:** "Environment should have realistic lighting and a skybox"
❌ **Bad:** "Set sun color to (7.0, 7.0, 7.0) and direction to (-1.0, 3.0, -2.0)"

### 6. Reference Documentation
Full documentation is avilable here: /home/husainal-mohssen/src/Meta-spatial-sdk-docs (Meta Spatial SDK v0.8.0) no need to go online to access SDK documentation. 
Agent is enocuraged to go online to search for documentation other than (Meta Spatial SDK v0.8.0) as it sees fit. 

### 7. Nice to Have (Optional)
Non-essential enhancements that keep main requirements focused:
- README.md files
- Code comments
- Debug features
Ie. everything that will make the sample app easier to understand for the users of the Meta Developers that will use the sample app as reference. 


---

## What to EXCLUDE from Tickets

### ❌ Never Include:
1. **Specific class names or API calls** - Let agents discover these from documentation
2. **Implementation details** - No exact method signatures, file structures, initialization sequences, or parameter values
3. **Line-by-line instructions** - No "Create function X", "In onCreate(), do Y" style directions
4. **Obvious details** - Standard Android project structure, resource file organization, Kotlin conventions

DO however include at least 1 high level line with the the obvious platform/language do not include Details though. 

---

## Code Generation Requirements (must be included in TICKET.md ticket description)

### ⚠️ CRITICAL: Code Generation Only

**Agents must generate complete source code but:**
- **NEVER attempt to install the Meta Spatial SDK**
- **NEVER attempt to build, compile, or run the code**
- **The SDK requires proprietary tools (Spatial Editor CLI) that cannot be installed in standard environments**
- Expelicitly mention to the Agent tha tthe above recommendations because it's been show in to be very hard to do in the agent's running env. 

**Success criteria:**
- Generate complete, well-structured source code
- Use appropriate Meta Spatial SDK v0.8.0 APIs discovered from documentation
- Follow Android/Kotlin best practices
- Match SDK patterns from documentation
- Has clear documentation and comments to make the final developer of the sample app happy. 

**Every ticket must explicitly state:**
```
⚠️ IMPORTANT: Generate complete source code only.
DO NOT attempt to install the Meta Spatial SDK or build/compile the code.
The SDK requires proprietary tooling not available in this environment.
```

---

## Example: Good vs Bad Ticket

(the following are abriged examples the tickets should be more detailed than this)

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
