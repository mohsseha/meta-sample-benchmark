
package com.meta.spatial.premiummediasample

import android.os.Bundle
import androidx.activity.compose.setContent
import com.meta.spatial.core.AppSystemActivity
import com.meta.spatial.premiummediasample.ui.VideoPlayerScreen
import com.meta.spatial.premiummediasample.ui.theme.PremiumMediaSampleTheme

class VideoPlayerActivity : AppSystemActivity() {

    companion object {
        const val EXTRA_MEDIA_ITEM = "extra_media_item"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mediaItem = intent.getParcelableExtra<MediaItem>(EXTRA_MEDIA_ITEM)
            ?: throw IllegalStateException("MediaItem not provided")

        setContent {
            PremiumMediaSampleTheme {
                VideoPlayerScreen(mediaItem = mediaItem)
            }
        }
    }
}
