
package com.meta.spatial.premiummediasample.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.meta.spatial.premiummediasample.MediaItem
import com.meta.spatial.premiummediasample.MediaType
import com.meta.spatial.premiummediasample.DrmScheme

@Composable
fun MediaLibraryScreen(onMediaSelected: (MediaItem) -> Unit) {
    val mediaItems = listOf(
        MediaItem("1", "Big Buck Bunny", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4", "", MediaType.STANDARD),
        MediaItem("2", "Elephants Dream", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4", "", MediaType.STANDARD),
        MediaItem("3", "Sintel", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4", "", MediaType.STANDARD),
        MediaItem("4", "Tears of Steel", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4", "", MediaType.STANDARD),
        MediaItem("5", "180 Video", "http://your-180-video-url.com/video.mp4", "", MediaType.VIDEO_180),
        MediaItem("6", "DRM Video", "http://your-drm-video-url.com/video.mpd", "", MediaType.STANDARD, DrmScheme.WIDEVINE)
    )

    LazyColumn {
        items(mediaItems) { mediaItem ->
            MediaListItem(mediaItem = mediaItem, onMediaSelected = onMediaSelected)
        }
    }
}

@Composable
fun MediaListItem(mediaItem: MediaItem, onMediaSelected: (MediaItem) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onMediaSelected(mediaItem) }
            .padding(16.dp)
    ) {
        Column {
            Text(text = mediaItem.title)
            Text(text = mediaItem.mediaType.name)
        }
    }
}
