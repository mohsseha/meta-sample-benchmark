package com.meta.premiumsamples.premiummediasample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.meta.premiumsamples.premiummediasample.data.MediaItem
import com.meta.premiumsamples.premiummediasample.data.MediaRepository
import com.meta.premiumsamples.premiummediasample.ui.theme.PremiumMediaSampleTheme

class MediaBrowserActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PremiumMediaSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MediaList(mediaItems = MediaRepository.getMediaItems()) { selectedMediaItem ->
                        val resultIntent = Intent()
                        resultIntent.putExtra("selected_media_item", selectedMediaItem)
                        setResult(RESULT_OK, resultIntent)
                        finish()
                    }
                }
            }
        }
    }
}

@Composable
fun MediaList(mediaItems: List<MediaItem>, onItemClick: (MediaItem) -> Unit) {
    LazyColumn {
        items(mediaItems) { mediaItem ->
            MediaListItem(mediaItem = mediaItem, onItemClick = onItemClick)
        }
    }
}

@Composable
fun MediaListItem(mediaItem: MediaItem, onItemClick: (MediaItem) -> Unit) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .clickable { onItemClick(mediaItem) }
    ) {
        Text(text = mediaItem.title, style = MaterialTheme.typography.headlineMedium)
        Text(text = mediaItem.description, style = MaterialTheme.typography.bodyMedium)
    }
}
