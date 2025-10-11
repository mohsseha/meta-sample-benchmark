// This code requires the Meta Spatial SDK.
// Please ensure you have the SDK installed and configured in your environment.

package com.meta.animationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.meta.spatial.SpatialActivity
import com.meta.spatial.scene.Scene

class MainActivity : SpatialActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the main scene
        setScene(MainScene())
    }
}
