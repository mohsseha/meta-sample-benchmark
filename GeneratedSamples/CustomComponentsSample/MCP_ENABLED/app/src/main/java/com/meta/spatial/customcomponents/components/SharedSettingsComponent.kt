package com.meta.spatial.customcomponents.components

import com.meta.spatial.sdk.Component

/**
 * A component that holds shared settings for the application.
 * In this case, it defines a global rotation speed for all rotating objects.
 * This component is expected to be on a single entity in the scene.
 *
 * @property rotationSpeed The global rotation speed.
 */
data class SharedSettingsComponent(var rotationSpeed: Float = 1.0f) : Component
