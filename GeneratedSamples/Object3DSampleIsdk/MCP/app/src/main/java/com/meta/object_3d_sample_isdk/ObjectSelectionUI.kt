
package com.meta.object_3d_sample_isdk

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meta.spatial.sdk.Entity
import com.meta.spatial.sdk.Scene
import com.meta.spatial.sdk.Transform
import com.meta.spatial.sdk.components.Grabbable
import com.meta.spatial.sdk.components.Model
import com.meta.spatial.sdk.compose.SpatialUI

data class ObjectData(val modelName: String, val displayName: String)

private val objectList = listOf(
    ObjectData("cube", "Cube"),
    ObjectData("sphere", "Sphere"),
    ObjectData("cylinder", "Cylinder")
)

@Composable
fun ObjectSelectionUI(spatialUI: SpatialUI) {
    val context = LocalContext.current
    val scene = (context as MainActivity).scene

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Select an Object",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(objectList) { obj ->
                ObjectCard(obj, onClick = {
                    addObjectToScene(scene, obj.modelName)
                })
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun ObjectCard(objectData: ObjectData, onClick: () -> Unit) {
    val context = LocalContext.current
    val bitmap = context.assets.open("scenes/${objectData.modelName}.png").use {
        BitmapFactory.decodeStream(it)
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                bitmap = bitmap.asImageBitmap(),
                contentDescription = objectData.displayName,
                modifier = Modifier.size(64.dp)
            )
            Text(text = objectData.displayName, fontSize = 20.sp)
            Button(onClick = onClick) {
                Text("Add")
            }
        }
    }
}

private fun addObjectToScene(scene: Scene, modelName: String) {
    val entity = scene.createEntity(modelName)
    val transform = entity.getOrCreateComponent(Transform::class.java)
    // Position the object in front of the user
    transform.position = floatArrayOf(0.0f, 1.0f, -1.0f)

    val model = entity.getOrCreateComponent(Model::class.java)
    model.uri = "scenes/$modelName.gltf"

    // Make the object grabbable
    entity.getOrCreateComponent(Grabbable::class.java)
}
