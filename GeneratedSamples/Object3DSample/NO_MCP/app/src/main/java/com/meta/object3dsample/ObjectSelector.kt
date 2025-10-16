package com.meta.object3dsample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ObjectSelector(onObjectSelected: (String) -> Unit) {
    val models = listOf("cube", "sphere", "cone")
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Select an object to add to the scene:")
        Row {
            models.forEach { model ->
                Button(
                    onClick = { onObjectSelected(model) },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(model)
                }
            }
        }
    }
}
