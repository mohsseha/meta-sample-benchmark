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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.meta.mediaplayersample.VideoViewModel
import com.meta.mediaplayersample.data.VideoItem

@Composable
fun VideoListPanel(viewModel: VideoViewModel) {
    val videoItems by viewModel.videoItems.collectAsState()

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(videoItems) { video ->
            VideoListItem(video = video) {
                viewModel.onVideoSelected(video)
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun VideoListItem(video: VideoItem, onVideoSelected: (VideoItem) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onVideoSelected(video) }
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            // In a real app, you would load the thumbnail image here.
            // For simplicity, we are just showing the title and description.
            Column {
                Text(text = video.title)
                Text(text = video.description)
            }
        }
    }
}
