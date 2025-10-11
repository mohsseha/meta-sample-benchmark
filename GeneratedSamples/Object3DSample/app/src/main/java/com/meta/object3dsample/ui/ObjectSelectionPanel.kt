package com.meta.object3dsample.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.meta.object3dsample.data.ObjectCatalog

@Composable
fun ObjectSelectionPanel(onObjectSelected: (String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Select an object to place")
        Spacer(modifier = Modifier.height(16.dp))
        ObjectCatalog.objects.forEach { obj ->
            Button(onClick = { onObjectSelected(obj.gltfPath) }) {
                Text(text = obj.name)
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}