
package com.meta.spatial.animation.sample

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.meta.spatial.sdk.compose.Scene
import com.meta.spatial.sdk.compose.Skybox
import com.meta.spatial.sdk.compose.Transform
import com.meta.spatial.sdk.compose.animation.AnimatedVisibility
import com.meta.spatial.sdk.compose.animation.FromGltf
import com.meta.spatial.sdk.compose.animation.RepeatMode
import com.meta.spatial.sdk.compose.animation.rememberAnimation
import com.meta.spatial.sdk.compose.animation.repeatable
import com.meta.spatial.sdk.compose.model.Model
import com.meta.spatial.sdk.compose.model.gltf
import com.meta.spatial.sdk.compose.ui.Button
import com.meta.spatial.sdk.compose.ui.Column
import com.meta.spatial.sdk.compose.ui.Text
import com.meta.spatial.sdk.compose.ui.rememberScale
import com.meta.spatial.sdk.compose.ui.rememberTransform
import com.meta.spatial.sdk.core.animation.Animation
import com.meta.spatial.sdk.core.with
import com.meta.spatial.sdk.math.vector3
import kotlin.math.sin

@Composable
fun AnimationScene() {
    Scene {
        Skybox(color = Color.LightGray)

        // 1. glTF Animation Playback
        GltfAnimatedDrone()

        // 2. Reusable Animation Driver
        ReusableRotationSystem()

        // 3. Procedural Frame-Based Animation
        ProceduralAnimation()

        // UI with animations
        AnimatedUI()
    }
}

@Composable
private fun GltfAnimatedDrone() {
    val droneAnimation = rememberAnimation(FromGltf("scenes/drone.gltf"))
    Transform(
        position = vector3(-2f, 1f, -5f),
        scale = vector3(0.5f, 0.5f, 0.5f)
    ) with droneAnimation

    Model(gltf("scenes/drone.gltf"))
}

@Composable
private fun ReusableRotationSystem() {
    val rotationAnimation = remember {
        Animation.rotation(
            duration = 5000,
            keyframes = listOf(
                vector3(0f, 0f, 0f),
                vector3(0f, 360f, 0f)
            )
        ).repeatable(repeatMode = RepeatMode.Restart)
    }

    Transform(
        position = vector3(0f, 1f, -5f)
    ) with rotationAnimation

    Model(gltf("scenes/drone.gltf"))
}

@Composable
private fun ProceduralAnimation() {
    val transform = rememberTransform()
    val scale = rememberScale()

    com.meta.spatial.sdk.compose.FrameCallback { frameTime ->
        val time = frameTime.toFloat() / 1000.0f
        transform.position.y = 1.0f + sin(time * 2.0f) * 0.5f
        scale.value = 1.0f + sin(time * 3.0f) * 0.2f
    }

    Transform(
        position = vector3(2f, 1f, -5f),
        scale = vector3(scale.value, scale.value, scale.value)
    )

    Model(gltf("scenes/drone.gltf"))
}

@Composable
private fun AnimatedUI() {
    var visible by remember { mutableStateOf(true) }

    Column(position = vector3(0f, 2f, -3f)) {
        Button(onClick = { visible = !visible }) {
            Text(text = "Toggle Visibility")
        }

        AnimatedVisibility(visible = visible) {
            Text(text = "This text fades in and out")
        }
    }
}
