package com.meta.spatial.animation_sample

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import com.meta.spatial.sdk.SystemBase
import com.meta.spatial.sdk.compose.ComposePanel
import com.meta.spatial.sdk.core.scene

class UiAnimationSystem : SystemBase() {

    override fun onEnter() {
        // It's assumed that a `ComposePanel` can be created and added to the scene.
        val composePanel = scene.createEntity().apply {
            setComponent(ComposePanel(400, 200) {
                AnimatedButton()
            })
        }
    }
}

@Composable
fun AnimatedButton() {
    var clicked by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(if (clicked) 1.2f else 1.0f)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { clicked = !clicked },
            modifier = Modifier
                .size(100.dp)
                .scale(scale)
        ) {
            Text("Click Me")
        }
    }
}
