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
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.meta.mediaplayersample.Video
import com.meta.mediaplayersample.VideoPlayerViewModel

@Composable
fun VideoListPanel(viewModel: VideoPlayerViewModel) {
    val videos by viewModel.videos.collectAsState()
    val isPassthroughEnabled by viewModel.isPassthroughEnabled.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Video Player", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { viewModel.togglePassthrough() }
        ) {
            Checkbox(
                checked = isPassthroughEnabled,
                onCheckedChange = { viewModel.togglePassthrough() }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Enable Passthrough")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(videos) { video ->
                VideoListItem(video = video, onClick = { viewModel.selectVideo(video) })
            }
        }
    }
}

@Composable
fun VideoListItem(video: Video, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = video.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = video.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
