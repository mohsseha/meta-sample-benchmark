package com.meta.object3dsampleisdk

import android.app.Application
import com.meta.spatial.core.SpatialApplication

class Object3DApplication : Application(), SpatialApplication {
    override fun onCreate() {
        super.onCreate()
        // Initialize the Spatial SDK
        initializeSpatialSdk(this)
    }
}
