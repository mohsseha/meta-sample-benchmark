
package com.meta.starter.sample.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.meta.starter.sample.ui.theme.StarterSampleTheme

@Composable
fun WelcomePanel() {
    StarterSampleTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Starter Sample",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "Welcome to the Meta Spatial SDK. This is a starter sample to help you get started with building immersive experiences.",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
