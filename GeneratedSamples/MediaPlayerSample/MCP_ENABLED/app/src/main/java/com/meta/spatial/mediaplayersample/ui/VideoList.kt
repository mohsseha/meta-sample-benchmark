package com.meta.spatial.mediaplayersample.ui

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
import com.meta.spatial.mediaplayersample.Video

@Composable
fun VideoList(videos: List<Video>, onVideoSelected: (Video) -> Unit) {
    LazyColumn {
        items(videos) { video ->
            VideoListItem(video = video, onVideoSelected = onVideoSelected)
        }
    }
}

@Composable
fun VideoListItem(video: Video, onVideoSelected: (Video) -> Unit) {
    Row(
        modifier = Modifier
            .clickable { onVideoSelected(video) }
            .padding(16.dp)
    ) {
        // In a real app, you would display a thumbnail here
        Column {
            Text(text = video.title)
            Text(text = video.description)
        }
    }
}
