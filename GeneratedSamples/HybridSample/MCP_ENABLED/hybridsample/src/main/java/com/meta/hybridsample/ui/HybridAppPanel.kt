package com.meta.hybridsample.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HybridAppPanel(isImmersiveMode: Boolean, onSwitchMode: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to the Hybrid Sample!")
        Text(text = if (isImmersiveMode) "Currently in Immersive Mode" else "Currently in Panel Mode")
        Button(onClick = onSwitchMode) {
            Text(text = if (isImmersiveMode) "Switch to Panel Mode" else "Switch to Immersive Mode")
        }
    }
}
