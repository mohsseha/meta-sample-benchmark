package com.meta.mediaplayersample

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun VideoListPanel(viewModel: VideoViewModel = viewModel()) {
    val videos by viewModel.videos.collectAsState()

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(videos) { video ->
            VideoListItem(video = video, onVideoSelected = {
                viewModel.selectVideo(video)
            })
        }
    }
}

@Composable
fun VideoListItem(video: Video, onVideoSelected: (Video) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onVideoSelected(video) }
            .padding(vertical = 8.dp)
    ) {
        // In a real app, you would load the thumbnail here.
        // For simplicity, we'll just show the title.
        Text(
            text = video.title,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
