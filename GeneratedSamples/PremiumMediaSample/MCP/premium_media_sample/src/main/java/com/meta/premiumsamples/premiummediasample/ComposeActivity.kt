package com.meta.premiumsamples.premiummediasample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.meta.premiumsamples.premiummediasample.ui.theme.PremiumMediaSampleTheme
import com.meta.premiumsamples.premiummediasample.ui.MediaSelectionScreen

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PremiumMediaSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MediaSelectionScreen()
                }
            }
        }
    }
}
