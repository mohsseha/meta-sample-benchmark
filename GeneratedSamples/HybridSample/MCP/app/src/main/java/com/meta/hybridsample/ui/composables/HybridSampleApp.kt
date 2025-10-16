package com.meta.hybridsample.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.meta.hybridsample.R
import com.meta.hybridsample.ui.MainViewModel

@Composable
fun HybridSampleApp(
    viewModel: MainViewModel,
    onSwitchMode: () -> Unit
) {
    val isImmersive by viewModel.isImmersive.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = if (isImmersive) {
                stringResource(R.string.immersive_mode)
            } else {
                stringResource(R.string.panel_mode)
            }
        )
        Button(onClick = onSwitchMode) {
            Text(
                text = if (isImmersive) {
                    stringResource(R.string.switch_to_panel)
                } else {
                    stringResource(R.string.switch_to_immersive)
                }
            )
        }
    }
}
