# Ticket Creation Guidelines for Phase 1

## Purpose
These guidelines ensure tickets are **fair, realistic, and effective** at demonstrating ChBird.ai's value without being too prescriptive or too vague.

## Core Principle
**Tickets should describe WHAT to build (outcomes & requirements), not HOW to build it (implementation details).**

The goal is to let Agent B (with ChBird) demonstrate its advantage in navigating documentation, discovering correct APIs, and understanding SDK patterns - not just following a recipe.

---

## What to INCLUDE in Tickets

### ✅ 1. Clear Outcome Description
- What should the end user experience?
- What does the app do when it runs?
- What should be visible/interactive?

**Example:** "Create an immersive VR app that displays a welcome panel with the app title and description in a 3D environment."

### ✅ 2. Technical Constraints
- Target SDK version (e.g., Meta Spatial SDK v0.8.0)
- Target platform/devices (e.g., Meta Quest 2/3/Pro)
- Language/framework (e.g., Kotlin, Android)

### ✅ 3. High-Level Components (Conceptual)
- What major parts are needed (e.g., "main activity", "UI panel", "3D scene")
- Use general terms, not specific class names

**Good:** "Create a main activity that enables VR features and displays a UI panel"
**Bad:** "Extend AppSystemActivity and register VRFeature and ComposeFeature"

### ✅ 4. Visual/UX Requirements
- Content that should be displayed (text, images, etc.)
- Basic layout expectations (centered, has padding, themed)
- Styling requirements (follows SDK UI guidelines, supports dark/light themes)

### ✅ 5. Scene/Environment Requirements
- What should the 3D environment include (lighting, skybox, objects)?
- Where should things be positioned (general placement, not exact coordinates)

**Good:** "The environment should have realistic lighting and a skybox"
**Bad:** "Set sun color to (7.0, 7.0, 7.0) and direction to (-1.0, 3.0, -2.0)"

### ✅ 6. Reference Documentation Setup
- Provide git clone command to get documentation locally
- Use relative path: `./meta-spacial-sdk-8.0.0-docs`
- For this project: `git clone https://github.com/mohsseha/Meta-spatial-sdk-docs ./meta-spacial-sdk-8.0.0-docs`
- Make cloning documentation the **FIRST STEP** in the ticket
- Let agents discover specific APIs from docs

### ✅ 7. Nice to Have Section (Optional)
- Include a "Nice to Have (Optional)" section for non-essential enhancements
- Examples: README.md files, code comments, debug features
- Keeps main requirements focused while allowing quality improvements
- Agents can skip these if focused on core functionality

---

## What to EXCLUDE from Tickets

### ❌ 1. Specific Class Names or API Calls
Don't prescribe: `ComposeViewPanelRegistration`, `VRFeature`, `SceneMaterial.UNLIT_SHADER`

Let agents discover these through documentation.

### ❌ 2. Implementation Details
Don't specify:
- Exact method signatures
- Code structure (which files, package names)
- Initialization sequences
- Exact parameter values

### ❌ 3. Line-by-Line Instructions
Don't write:
- "Create a function called X that does Y"
- "In onCreate(), initialize Z with A and B"
- Step-by-step procedural instructions

### ❌ 4. Obvious Implementation Details
Don't specify things any competent agent knows:
- Standard Android project structure
- Basic resource file organization (strings.xml, AndroidManifest.xml, etc.)
- Common Kotlin/Android conventions
- Exact file paths or naming conventions

---

## Code Generation Requirements

### ✅ DECISION: Code Generation Only (Manual Assessment)

**For Phase 1:**
- Agents generate complete source code for the app
- **DO NOT build, compile, or run the code**
- Success = "Generate complete, well-structured source code"

**Rationale:**
- Meta Spatial SDK requires proprietary tools (Spatial Editor CLI) that are not feasible in automated/container builds
- Focus on documentation navigation and API discovery (ChBird's value)
- Manual code review is fastest path to Phase 1 completion
- Can add automated verification in Phase 2 if needed

**Assessment Criteria (Manual Review):**
- Code completeness: All necessary files and components present?
- API correctness: Uses appropriate Meta Spatial SDK v0.8.0 APIs?
- Code structure: Follows Android/Kotlin best practices?
- Documentation alignment: Matches SDK patterns from documentation?

**Important for Tickets:**
- **Explicitly tell agents NOT to attempt building/compiling**
- Focus on code generation task only
- Provide documentation references for API discovery

---

## Example: Good vs Bad Ticket

### ❌ BAD (Too Prescriptive)
```
Create StarterSampleActivity that extends AppSystemActivity.
In registerFeatures(), return a list containing:
- VRFeature(this)
- ComposeFeature()

In onCreate(), call NetworkedAssetLoader.init() with...
```

### ✅ GOOD (Outcome-Focused, No Build Required)
```
Create a starter VR application for Meta Spatial SDK v0.8.0 that:
- Displays a welcome panel with the app title "Starter Sample" and
  a brief description
- Renders in an immersive 3D environment with a skybox and realistic lighting
- Supports Meta Quest devices (Quest 2/3/Pro)
- Follows SDK best practices for panel creation and scene setup
- Uses Jetpack Compose for the UI panel

## Reference Documentation

**FIRST STEP:** Clone the documentation repository:
git clone https://github.com/mohsseha/Meta-spatial-sdk-docs ./meta-spacial-sdk-8.0.0-docs

Use the documentation at ./meta-spacial-sdk-8.0.0-docs to discover APIs and patterns.

**Important:** Generate complete source code only. Do NOT attempt to build or compile the code.
```
