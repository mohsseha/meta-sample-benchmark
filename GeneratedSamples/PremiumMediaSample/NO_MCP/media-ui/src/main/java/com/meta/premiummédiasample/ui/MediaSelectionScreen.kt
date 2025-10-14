package com.meta.premiummédiasample.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.meta.premiummédiasample.data.MediaCatalog
import com.meta.premiummédiasample.data.MediaItem

@Composable
fun MediaSelectionScreen(onMediaSelected: (MediaItem) -> Unit) {
    LazyColumn {
        items(MediaCatalog.items) { mediaItem ->
            MediaListItem(mediaItem = mediaItem, onMediaSelected = onMediaSelected)
        }
    }
}

@Composable
fun MediaListItem(mediaItem: MediaItem, onMediaSelected: (MediaItem) -> Unit) {
    Row(
        modifier = Modifier
            .clickable { onMediaSelected(mediaItem) }
            .padding(16.dp)
    ) {
        // We will load the thumbnail here later.
        Column {
            Text(text = mediaItem.title)
            Text(text = mediaItem.type.toString())
        }
    }
}
