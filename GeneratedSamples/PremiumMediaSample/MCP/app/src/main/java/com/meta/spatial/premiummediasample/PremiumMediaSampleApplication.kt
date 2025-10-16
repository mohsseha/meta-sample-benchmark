
package com.meta.spatial.premiummediasample

import android.app.Application
import com.meta.spatial.SpatialSdk

class PremiumMediaSampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        SpatialSdk.initialize(this)
    }
}
