
package com.meta.spatial.premiummediasample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.meta.spatial.premiummediasample.ui.theme.PremiumMediaSampleTheme
import com.meta.spatial.premiummediasample.ui.MediaLibraryScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PremiumMediaSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MediaLibraryScreen(onMediaSelected = { mediaItem ->
                        val intent = Intent(this, VideoPlayerActivity::class.java).apply {
                            putExtra(VideoPlayerActivity.EXTRA_MEDIA_ITEM, mediaItem)
                        }
                        startActivity(intent)
                    })
                }
            }
        }
    }
}
