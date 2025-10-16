package com.meta.object3dsampleisdk.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ObjectSelectionPanel(onObjectSelected: (String) -> Unit) {
    val objects = listOf("Cube", "Sphere", "Cylinder")
    Column {
        Text("Select an object to add to the scene")
        Row {
            objects.forEach { obj ->
                Button(
                    onClick = { onObjectSelected(obj) },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(obj)
                }
            }
        }
    }
}
