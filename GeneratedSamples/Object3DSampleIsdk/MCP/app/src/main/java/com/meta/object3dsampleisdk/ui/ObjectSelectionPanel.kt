package com.meta.object3dsampleisdk.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.meta.object3dsampleisdk.Object3DView
import com.meta.object3dsampleisdk.R

@Composable
fun ObjectSelectionPanel(object3DView: Object3DView) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Select an object to add to the scene:")
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ObjectButton(object3DView = object3DView, objectName = "Cube", imageRes = R.drawable.cube)
                ObjectButton(object3DView = object3DView, objectName = "Sphere", imageRes = R.drawable.sphere)
                ObjectButton(object3DView = object3DView, objectName = "Torus", imageRes = R.drawable.torus)
            }
        }
    }
}

@Composable
fun ObjectButton(object3DView: Object3DView, objectName: String, imageRes: Int) {
    Button(onClick = { object3DView.spawnObject(objectName) }) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = objectName,
                modifier = Modifier.size(48.dp)
            )
            Text(text = objectName)
        }
    }
}
