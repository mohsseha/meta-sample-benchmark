package com.meta.object3dsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.meta.spatial.sdk.activities.ImmersiveActivity
import com.meta.spatial.sdk.compose.SpatialTheme
import com.meta.spatial.sdk.core.Scene
import com.meta.spatial.sdk.core.SceneManager

class MainActivity : ImmersiveActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpatialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ObjectSelector(
                        onObjectSelected = { model ->
                            SceneLoader.addObjectToScene(model)
                        }
                    )
                }
            }
        }
        SceneLoader.loadScene(this)
    }
}
