
package com.meta.mediaplayersample.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.meta.mediaplayersample.VideoItem
import com.meta.mediaplayersample.VideoViewModel

@Composable
fun VideoListPanel(viewModel: VideoViewModel) {
    val videoItems by viewModel.videoItems.collectAsState()
    val isPassthroughEnabled by viewModel.isPassthroughEnabled.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Video Playlist", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(videoItems) { video ->
                VideoListItem(video = video) {
                    viewModel.selectVideo(video)
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isPassthroughEnabled,
                onCheckedChange = { viewModel.togglePassthrough() }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Enable Passthrough")
        }
    }
}

@Composable
fun VideoListItem(video: VideoItem, onVideoSelected: (VideoItem) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onVideoSelected(video) }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = video.title, style = MaterialTheme.typography.bodyLarge)
            Text(text = video.description, style = MaterialTheme.typography.bodySmall)
        }
    }
}
