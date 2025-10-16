package com.meta.object3dsample

import android.app.Application
import com.meta.spatial.sdk.QuestSdk

class Object3DApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        QuestSdk.initialize(this)
    }
}
