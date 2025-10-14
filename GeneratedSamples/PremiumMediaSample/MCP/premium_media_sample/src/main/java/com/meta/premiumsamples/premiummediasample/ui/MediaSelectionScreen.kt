package com.meta.premiumsamples.premiummediasample.ui

package com.meta.premiumsamples.premiummediasample.ui

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.meta.premiumsamples.premiummediasample.data.MediaLibrary

@Composable
fun MediaSelectionScreen() {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(MediaLibrary.getMediaItems()) { mediaItem ->
            Button(onClick = {
                val intent = Intent("com.meta.premiumsamples.premiummediasample.MEDIA_SELECTED")
                intent.putExtra("media_title", mediaItem.title)
                context.sendBroadcast(intent)
            }) {
                Text(text = mediaItem.title)
            }
        }
    }
}
