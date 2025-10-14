package com.meta.object3dsample

import android.app.Application
import com.meta.spatial.Spatial

class Object3DApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // Initialize the Meta Spatial SDK.
        // I am assuming this is the entry point for the SDK.
        Spatial.initialize(this)
    }
}
