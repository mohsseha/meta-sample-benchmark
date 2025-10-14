package com.meta.object3dsample.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ObjectSelectionPanel(
    onObjectSelected: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = { onObjectSelected("cube") }) {
            Text("Cube")
        }
        Button(onClick = { onObjectSelected("sphere") }) {
            Text("Sphere")
        }
        Button(onClick = { onObjectSelected("cone") }) {
            Text("Cone")
        }
    }
}
